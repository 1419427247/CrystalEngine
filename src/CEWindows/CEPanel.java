package CEWindows;

import javax.swing.*;
import java.awt.geom.*;
import CEApplication.CEGameObjectManager;
import CEApplication.CEWorldManager;
import CEComponents.CESprite;
import CEUtility.CETime;
import CEUtility.CEVector;
import CEComponents.*;
import java.awt.*;
import java.awt.image.*;

class CEPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		long s = System.currentTimeMillis();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;

		if (CECamera.mainCamera == null) {
			g2d.setFont(new Font("", 0, 80));
			g2d.drawString("没有主摄像机", 30, this.getHeight() / 2);
			return;
		}
		g2d.setColor(CECamera.mainCamera.backGroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		for (CESprite sprite : CESprite.sprites) {
			AffineTransform transform1 = new AffineTransform();

			CEVector position = CEVector.Subtract(sprite.gameObject.transform.position,
					CECamera.mainCamera.gameObject.transform.position);
			transform1.translate(-position.getX(), position.getY());

			CEVector scale = sprite.gameObject.transform.scale;
			transform1.scale(scale.getX(), scale.getY());

			double angle = (sprite.gameObject.transform.angle - CECamera.mainCamera.gameObject.transform.angle)
					* Math.PI / 180.0;
			transform1.rotate(angle);

			g2d.drawImage(sprite.image, transform1, null);
		}
		CETime.FPS = (1000f / (System.currentTimeMillis() - s));
	}
}
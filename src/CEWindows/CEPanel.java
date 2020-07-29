package CEWindows;

import javax.imageio.ImageIO;
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
import java.io.File;
import java.io.IOException;

class CEPanel extends JPanel {

	Image img = null;
	float an = 0;

	public CEPanel() {
		try {
			img = ImageIO.read(new File("OIP.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		// try {
		// 	Thread.sleep(10);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		Graphics2D g2d = (Graphics2D) g;

		if (CECamera.mainCamera == null) {
			g2d.setFont(new Font("", 0, 80));
			g2d.drawString("没有主摄像机", 30, this.getHeight() / 2);
			return;
		}

		synchronized (this) {
			System.out.println(CECamera.mainCamera.gameObject.transform.angle);
			long s = System.currentTimeMillis();

			g2d.setColor(CECamera.mainCamera.backGroundColor);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			g2d.rotate(CECamera.mainCamera.gameObject.transform.angle * Math.PI / 180f, getWidth() / 2,
					getHeight() / 2);

			for (CESprite sprite : CESprite.sprites) {
				AffineTransform transform1 = new AffineTransform();

				CEVector position = CEVector.Subtract(sprite.gameObject.transform.position,
						CECamera.mainCamera.gameObject.transform.position);
				transform1.translate(-position.getX() * CECamera.mainCamera.filedOfView / 90f + getWidth() / 2,
						position.getY() * CECamera.mainCamera.filedOfView / 90f + getHeight() / 2);
				transform1.translate(-sprite.image.getWidth() / 2, -sprite.image.getHeight() / 2);

				double angle = -sprite.gameObject.transform.angle * Math.PI / 180f;

				transform1.rotate(angle, sprite.image.getWidth() / 2, sprite.image.getHeight() / 2);

				// CEVector scale = sprite.gameObject.transform.scale;
				// transform1.scale(scale.getX() * CECamera.mainCamera.filedOfView / 90f,
				// scale.getY() * CECamera.mainCamera.filedOfView / 90f);

				g2d.drawImage(sprite.image, transform1, null);
			}
			CETime.FPS = (1000f / (System.currentTimeMillis() - s));
		}
	}
}
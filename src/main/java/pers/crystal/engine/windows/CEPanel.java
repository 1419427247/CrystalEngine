package pers.crystal.engine.windows;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import java.awt.*;

import pers.crystal.engine.application.CEApplication;
import pers.crystal.engine.application.CEGameObject;
import pers.crystal.engine.application.CEGameObjectManager;
import pers.crystal.engine.application.CEWorld;
import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.components.sprite.CESprite;
import pers.crystal.engine.utility.CETime;
import pers.crystal.engine.utility.CEVector;

class CEPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (CECamera.mainCamera == null) {
			g2d.setFont(new Font("", 0, 80));
			g2d.drawString("没有主摄像机", 30, this.getHeight() / 2);
			return;
		}
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				CECamera.mainCamera.antialiasing == CECamera.ANTIALIASING_ON ? RenderingHints.VALUE_ANTIALIAS_ON
						: RenderingHints.VALUE_ANTIALIAS_OFF);

		synchronized (CEGameObject.getWorld()){
			long s = System.currentTimeMillis();

			g2d.setColor(CECamera.mainCamera.backGroundColor);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			g2d.rotate(CECamera.mainCamera.gameObject.transform.angle * Math.PI / 180f, getWidth() / 2,
					getHeight() / 2);
			g2d.scale(CECamera.mainCamera.filedOfView / 90f, CECamera.mainCamera.filedOfView / 90f);

			g2d.translate(
					-(CECamera.mainCamera.filedOfView / 90f - 1) * getWidth()
							/ (2 * CECamera.mainCamera.filedOfView / 90f),
					-(CECamera.mainCamera.filedOfView / 90f - 1) * getHeight()
							/ (2 * CECamera.mainCamera.filedOfView / 90f));

			try {
				for (CESprite sprite : CESprite.sprites) {
					if (sprite.image == null) {
						continue;
					}

					AffineTransform transform1 = new AffineTransform();

					CEVector position = CEVector.Subtract(sprite.gameObject.transform.position,
							CECamera.mainCamera.gameObject.transform.position);

					transform1.translate(position.getX() - sprite.image.getWidth() / 2 + getWidth() / 2,
							position.getY() - sprite.image.getHeight() / 2 + getHeight() / 2);

					double angle = -sprite.gameObject.transform.angle * Math.PI / 180f;

					transform1.rotate(angle, sprite.image.getWidth() / 2, sprite.image.getHeight() / 2);

					// CEVector scale = sprite.gameObject.transform.scale;
					// transform1.scale(scale.getX() * 3,
					// scale.getY() * 3);

					g2d.drawImage(sprite.image, transform1, null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			CETime.FPS = (1000f / (System.currentTimeMillis() - s));
		}

	}
}
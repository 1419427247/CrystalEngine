package CEApplication;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Windows extends JFrame implements Runnable {
	World world;

	public Windows(World world) {
		this.world = world;
	}

	@Override
	public void show() {
		super.show();
		new Thread(this).start();
	}

	float i = 0;

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		BufferedImage bufferedImage = new BufferedImage(100, 200, BufferedImage.TYPE_INT_ARGB);
		Graphics imageGraphics = bufferedImage.getGraphics();
		imageGraphics.fillRect(0, (int) i, 100, 200);
		imageGraphics.drawLine(0, (int) i, 100, 200);
		i = i + 0.2f;
		graphics.drawImage((Image) bufferedImage, 0, 0, null);
	}

	@Override
	public void run() {
		while (true) {
			this.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

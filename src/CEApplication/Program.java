package CEApplication;

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import CEComponents.CECamera;
import CEComponents.CESprite;
import CEUtility.CETime;
import CEUtility.CEVector;
import CEWindows.CEInput;

class Print extends CEComponent {

	@Override
	public void Start() {
		System.out.println(gameObject.GetName() + "开始啦");

	}

	int x = -1, y = -1;

	@Override
	public void Update() {
		if (CEInput.IsKeyDown(KeyEvent.VK_A)) {
			gameObject.transform.Translate(1, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_D)) {
			gameObject.transform.Translate(-1, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_E)) {
			CECamera.mainCamera.filedOfView++;
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_Q)) {
			CECamera.mainCamera.gameObject.transform.angle++;
		}
		if (CEInput.IsKeyDown(1)) {
			if (x == -1 && y == -1) {
				x = CEInput.mouseX;
				y = CEInput.mouseY;
				return;
			}
			gameObject.transform.Translate((x-CEInput.mouseX) / 1f, (y-CEInput.mouseY) / 1f);
			x = CEInput.mouseX;
			y = CEInput.mouseY;
		} else {
			x = -1;
			y = -1;
		}
	}

	@Override
	public void Destroy() {
		System.out.println("我被摧毁啦");
	}
}

/**
 * Frame extends JFrame
 */

public class Program {
	public static void main(final String[] args) {
		CEWorld world = new CEWorld();
		world.gameObjectManager.AddGameObject(new CEGameObject("123"));

		world.gameObjectManager.AddGameObject(new CEGameObject("234"));
		world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);

		CESprite sprite1 =(CESprite)
		world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CESprite.class);
		sprite1.setImage("4.bmp");

		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);

		CESprite sprite2 =(CESprite)
		world.gameObjectManager.GetGameObject("123").componentManager.GetComponent(CESprite.class);
		sprite2.setImage("无标题.png");

		CEApplication application = new CEApplication(world);

		CEWorld world2 = new CEWorld();
		world2.gameObjectManager.AddGameObject(new CEGameObject("a"));
		world2.gameObjectManager.AddGameObject(new
		CEGameObject("b")).SetParent(world2.gameObjectManager.GetGameObject("a"));
		world2.gameObjectManager.GetGameObject("a").componentManager.AddComponent(CECamera.class);
		world2.gameObjectManager.GetGameObject("b").componentManager.AddComponent(Print.class);

		//CEWorldManager.LoadWorld(world2);

		System.out.println("价值");
	}
}

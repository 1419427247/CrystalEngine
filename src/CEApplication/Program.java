package CEApplication;

import java.awt.event.*;

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

	int x=-1,y=-1;

	@Override
	public void Update() {
		if (CEInput.IsKeyDown(KeyEvent.VK_A)) {
			gameObject.transform.Translate(1,0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_D)) {
			gameObject.transform.Translate(CEVector.Multiply(CEVector.LEFT,CETime.deltaTime));
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_E)) {
			gameObject.transform.angle++;
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_Q)) {
			gameObject.transform.scale.Subtract(0.01f,0.01f);
		}
		if(CEInput.IsKeyDown(1)){
			if (x == -1 && y == -1) {
				x = CEInput.mouseX;
				y = CEInput.mouseY;
				return;
			}
			gameObject.transform.Translate((CEInput.mouseX - x) / 1f,-(CEInput.mouseY - y) / 1f);
			x = CEInput.mouseX;
			y = CEInput.mouseY;
		}else{
			x=-1;
			y=-1;
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
	public static void main(String[] args) {

		


		// CEWorld world = new CEWorld();
		// world.gameObjectManager.AddGameObject(new CEGameObject("123"));

		// world.gameObjectManager.AddGameObject(new CEGameObject("234"));
		// world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);

		// CESprite sprite1 =(CESprite) world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CESprite.class);
		// sprite1.setImage("长史");

		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);


		// CESprite sprite2 =(CESprite) world.gameObjectManager.GetGameObject("123").componentManager.GetComponent(CESprite.class);
		// sprite2.setImage("无标题.png");

		// CEApplication application = new CEApplication(world);


		// Thread.sleep(200);

		// CEWorld world2 = new CEWorld();
		// world2.gameObjectManager.AddGameObject(new CEGameObject("a"));
		// world2.gameObjectManager.AddGameObject(new
		// CEGameObject("b")).SetParent(world2.gameObjectManager.GetGameObject("a"));
		// world2.gameObjectManager.GetGameObject("a").componentManager.AddComponent(Print.class);
		// world2.gameObjectManager.GetGameObject("b").componentManager.AddComponent(Print.class);

		// System.out.println("价值");

		// world.gameObjectManager.AddGameObject(perfab.Instantiation()
	}
}

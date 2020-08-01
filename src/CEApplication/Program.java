package CEApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import CEComponents.CEAudio;
import CEComponents.CECamera;
import CEComponents.CESprite;


public class Program {
	public static void main(final String[] args) throws FileNotFoundException {
		World w =new World(new Vec2(0, 0));
		
		CEWorld world = new CEWorld();
		world.gameObjectManager.AddGameObject(new CEGameObject("123"));

		world.gameObjectManager.AddGameObject(new CEGameObject("234"));
		world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);

		CESprite sprite1 =(CESprite)
	
		world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CESprite.class);
		sprite1.setImage("4.bmp");

		 world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CEAudio.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);

		CESprite sprite2 =(CESprite)
		world.gameObjectManager.GetGameObject("123").componentManager.GetComponent(CESprite.class);
		sprite2.setImage("OIP.jpg");

		CEApplication application = new CEApplication(world);

		// CEWorld world2 = new CEWorld();
		// world2.gameObjectManager.AddGameObject(new CEGameObject("a"));
		// world2.gameObjectManager.AddGameObject(new
		// CEGameObject("b")).SetParent(world2.gameObjectManager.GetGameObject("a"));
		// world2.gameObjectManager.GetGameObject("a").componentManager.AddComponent(CECamera.class);
		// world2.gameObjectManager.GetGameObject("b").componentManager.AddComponent(Print.class);

		// //CEWorldManager.LoadWorld(world2);

		// System.out.println("浠峰��");
	}
}

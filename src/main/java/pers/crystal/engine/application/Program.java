package pers.crystal.engine.application;

import java.io.FileNotFoundException;

import pers.crystal.engine.components.CEAudio;
import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.components.CESprite;

public class Program {
	public static void main(final String[] args) throws FileNotFoundException {

		// World w =new World(new Vec2());
		CEWorld world = new CEWorld();
		world.gameObjectManager.AddGameObject(new CEGameObject("123"));

		world.gameObjectManager.AddGameObject(new CEGameObject("234"));
		world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);

		CESprite sprite1 = (CESprite)

		world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CESprite.class);
		sprite1.setImage("asset/4.bmp");

		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CEAudio.class);
		world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);

		CESprite sprite2 = (CESprite) world.gameObjectManager.GetGameObject("123").componentManager
				.GetComponent(CESprite.class);
		sprite2.setImage("asset/OIP.jpg");

		new CEApplication(world);

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

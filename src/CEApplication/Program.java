package CEApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import CEComponents.CECamera;
import CEComponents.CESprite;

public class Program {
	public static void main(final String[] args) throws FileNotFoundException {
		// long s = System.currentTimeMillis();

		// CEXml xml = new CEXml();

		// CEGameObject g1 = new CEGameObject("方块1");
		// CEGameObject g2 = new CEGameObject("方块2");
		// g1.AddChild(g2);

		// CEApplication.xml.write(CEApplication.xml.convertToDocument(g1),new File("1.xml"));

		

		//CEGameObject root = (CEGameObject) CEApplication.xml.convertToObject(new FileInputStream(new File("1.xml")));

		// System.out.println(g.GetName());
		// System.out.println(g.GetChildrenSize());

		// System.out.println((System.currentTimeMillis()-s) / 1000f);

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

		// CEWorld world2 = new CEWorld();
		// world2.gameObjectManager.AddGameObject(new CEGameObject("a"));
		// world2.gameObjectManager.AddGameObject(new
		// CEGameObject("b")).SetParent(world2.gameObjectManager.GetGameObject("a"));
		// world2.gameObjectManager.GetGameObject("a").componentManager.AddComponent(CECamera.class);
		// world2.gameObjectManager.GetGameObject("b").componentManager.AddComponent(Print.class);

		// //CEWorldManager.LoadWorld(world2);

		// System.out.println("价值");
	}
}

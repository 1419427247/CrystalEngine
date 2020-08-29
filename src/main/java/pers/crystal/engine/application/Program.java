package pers.crystal.engine.application;

import java.util.ArrayList;

import org.jbox2d.dynamics.BodyType;

import pers.crystal.engine.components.CEAudio;
import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.components.CETransform;
import pers.crystal.engine.components.gui.CEButton;
import pers.crystal.engine.components.physics.CERectCollision;
import pers.crystal.engine.components.physics.CERigidbody;
import pers.crystal.engine.components.sprite.CEGraphics;
import pers.crystal.engine.components.sprite.CESprite;
import pers.crystal.engine.utility.CEAsset;
import pers.crystal.engine.utility.CEVector;

public class Program {

	static ArrayList<Integer> i = new ArrayList<Integer>();

	public static void main(String[] args) {

		// CEAudioClip audio = new CEAudioClip(CEAsset.GetFile("y.wav"));
		// audio.Play();

		// while (true) {
		// audio.IsPlaying();
		// try {
		// Thread.sleep(20);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// CEServer server = new CEServer();
		// CEClient client = new CEClient();

		// try {
		// client.Connect(InetAddress.getLocalHost(), 13501);
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// }
		// CESyncValue i1 = server.CreateSyncValue("ABCDEFGH", new byte[]{127,1});
		// CESyncValue i2 = server.CreateSyncValue("IJKLMNOP",
		// "qwasfafasfasda撒大苏打实打实的啊沙发沙发沙发沙发ed");

		// CESyncValue j1 = client.CreateSyncValue("ABCDEFGH");
		// CESyncValue j2 = client.CreateSyncValue("IJKLMNOP");

		// while (true) {
		// server.Update();
		// if (j1.GetValue() != null) {
		// System.out.println(((byte[])j1.GetValue())[0]);

		// }
		// System.out.println(j2.GetValue());
		// }

		CEWorld world = extracted();

		CEApplication.Create(world);

	}

	public static CEWorld extracted() {
		CEWorld world = new CEWorld();
		// CEWorld.gameObjectManager.AddGameObject(new CEGameObject("234"));
		// CEWorld.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);
		// CEWorld.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CEAudio.class);
		// CEWorld.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CERectCollision.class);
		// CEWorld.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CERigidbody.class);
		// CESprite sprite1 = (CESprite)
		// CEWorld.gameObjectManager.GetGameObject("234").componentManager
		// .GetComponent(CESprite.class);
		// sprite1.SetImage(CEAsset.GetFile("OIP.jpg"));

		// CEAudio audio = (CEAudio)
		// world.gameObjectManager.GetGameObject("234").componentManager
		// .GetComponent(CEAudio.class);
		// audio.LoadAudioFile(CEAsset.GetFile("歌剧魅影(纯音乐).wav"));

		// world.gameObjectManager.AddGameObject(new CEGameObject("55"));
		// world.gameObjectManager.GetGameObject("55").componentManager.AddComponent(CERigidbody.class);
		// world.gameObjectManager.GetGameObject("55").componentManager.AddComponent(CESprite.class);
		// world.gameObjectManager.GetGameObject("55").componentManager.AddComponent(CERectCollision.class);
		// CETransform transform = (CETransform) world.gameObjectManager.GetGameObject("55").componentManager
		// 		.GetComponent(CETransform.class);
		// transform.position = new CEVector(17, 50);
		// CERigidbody rigidbody = (CERigidbody) world.gameObjectManager.GetGameObject("55").componentManager
		// 		.GetComponent(CERigidbody.class);
		// rigidbody.type = BodyType.STATIC;
		// CESprite sprite5 = (CESprite) world.gameObjectManager.GetGameObject("55").componentManager
		// 		.GetComponent(CESprite.class);
		// sprite5.SetImage(CEAsset.GetFile("4.bmp"));

		CEWorld.gameObjectManager.AddGameObject(new CEGameObject("123"));
		CEWorld.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
		CEWorld.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);

		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		// CESprite sprite2 = (CESprite) world.gameObjectManager.GetGameObject("123").componentManager
		// 		.GetComponent(CESprite.class);
		// sprite2.SetImage(CEAsset.GetFile("OIP.jpg"));

		return world;
	}
}

package pers.crystal.engine.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Base64;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import pers.crystal.engine.components.CEAudio;
import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.components.CEClient;
import pers.crystal.engine.components.CEServer;
import pers.crystal.engine.components.CESprite;
import pers.crystal.engine.utility.CEAsset;
import pers.crystal.engine.utility.net.CEInstruction;
import pers.crystal.engine.utility.net.CEMessage;
import pers.crystal.engine.utility.net.CESocket;
import pers.crystal.engine.utility.net.CESyncValue;

public class Program {

	public static void main(final String[] args) throws FileNotFoundException {
		CEServer server = new CEServer();
		CEClient client = new CEClient();

		// client.RegisterInstruction("A", new CEInstruction() {
		// 	@Override
		// 	public void Do(InetAddress inetAddress, byte signal, Object... args) {
		// 		System.out.println(signal);
		// 		for (Object object : args) {
		// 			System.out.println(object);
		// 		}
		// 	}
		// });

		// try {
		// 	server.SendMessage(new CEMessage().AddInstruction("A", (byte) 1, 2, 3), InetAddress.getLocalHost(),
		// 			4231);
		// } catch (UnknownHostException e1) {
		// 	e1.printStackTrace();
		// }

		try {
			client.Connect(InetAddress.getLocalHost(), 4232);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CESyncValue i1 = server.CreateSyncValue("ABCDEFGH",41242141);
		CESyncValue i2 = server.CreateSyncValue("IJKLMNOP","qwasfafasfasda撒大苏打实打实的啊沙发沙发沙发沙发ed");

		CESyncValue j1 = client.CreateSyncValue("ABCDEFGH");
		CESyncValue j2 = client.CreateSyncValue("IJKLMNOP");

		while (true) {
			server.Update();
			System.out.println(j1.GetValue());
			System.out.println(j2.GetValue());
		}

		// CEWorld world = new CEWorld();
		// world.gameObjectManager.AddGameObject(new CEGameObject("123"));

		// world.gameObjectManager.AddGameObject(new CEGameObject("234"));
		// world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CESprite.class);
		// world.gameObjectManager.GetGameObject("234").componentManager.AddComponent(CEAudio.class);

		// CESprite sprite1 = (CESprite)
		// world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CESprite.class);
		// sprite1.SetImage(CEAsset.GetFile("4.bmp"));

		// CEAudio audio = (CEAudio)
		// world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class);

		// audio.SetAudioFile(CEAsset.GetFile("y.wav"));

		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CESprite.class);
		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);

		// world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(CECamera.class);

		// CESprite sprite2 = (CESprite)
		// world.gameObjectManager.GetGameObject("123").componentManager
		// .GetComponent(CESprite.class);
		// sprite2.SetImage(CEAsset.GetFile("OIP.jpg"));

		// new CEApplication(world);

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

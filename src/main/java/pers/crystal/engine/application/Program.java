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
import pers.crystal.engine.utility.CEInstruction;
import pers.crystal.engine.utility.net.CEMassage;
import pers.crystal.engine.utility.net.CESocket;

public class Program {

	public static void main(final String[] args) throws FileNotFoundException {
		CESocket server = new CESocket(14333);
		CESocket client = new CESocket(14332);

		client.RegisterInstruction(1, new CEInstruction() {
			@Override
			public void Do(CEMassage massage) {
				System.out.println(massage.GetString());
				System.out.println(massage.GetInt());
				System.out.println(massage.GetInt());
			}
		});
		client.RegisterInstruction(2, new CEInstruction() {
			@Override
			public void Do(CEMassage massage) {
				System.out.println(massage.GetString());
				System.out.println(massage.GetChar());
				System.out.println(massage.GetBoolean());
			}
		});
		CEMassage m = null;
		try {
			m = new CEMassage(InetAddress.getLocalHost());
			m.AddInstruction(1, "撒v dvsdfsd旦", 456, 8656);
			m.AddInstruction(2, "撒旦", '下', true);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.SendMessage(m, 14332);
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

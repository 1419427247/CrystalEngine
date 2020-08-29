package pers.crystal.engine.application;

import java.awt.event.KeyEvent;

import org.w3c.dom.events.MouseEvent;

import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.components.sprite.CESprite;
import pers.crystal.engine.utility.CEAsset;
import pers.crystal.engine.utility.CETime;
import pers.crystal.engine.utility.CEVector;
import pers.crystal.engine.windows.CEFrame;

public class Print extends CEComponent {

	@Override
	public void Start() {
		CEFrame.SetFullScreenWindow(false);
	}

	int x = -1, y = -1;

	@Override
	public void Update() {
		if (CEInputManager.GetKey(KeyEvent.VK_A)) {
			gameObject.transform.Translate(-150*CETime.deltaTime, 0);
		}
		if (CEInputManager.GetKey(KeyEvent.VK_D)) {
			gameObject.transform.Translate(150*CETime.deltaTime, 0);
		}
		if (CEInputManager.GetKey(KeyEvent.VK_E)) {
			gameObject.transform.angle++;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("歌剧魅影(纯音乐).wav"));
		}
		if (CEInputManager.GetKey(KeyEvent.VK_Q)) {
			gameObject.transform.angle--;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("脚步光脚地毯运行.wav"));
		}

		if (CEInputManager.GetKey(KeyEvent.VK_F)) {
			CECamera.mainCamera.filedOfView --;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("脚步光脚地毯运行.wav"));
		}
		if (CEInputManager.GetKey(KeyEvent.VK_G)) {
			CECamera.mainCamera.filedOfView ++;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("脚步光脚地毯运行.wav"));
		}


		if (CEInputManager.GetKey(KeyEvent.VK_SPACE)) {


			CEVector position = CECamera.mainCamera.ScreenToWorldPoint();
			CEGameObject g = new CEGameObject(Math.random() + "asfdas");
			g.componentManager.AddComponent(CESprite.class);
			CESprite sprite = (CESprite) g.componentManager.GetComponent(CESprite.class);
			sprite.SetImage(CEAsset.GetFile("4.bmp"));
			
			g.transform.position = position;

			System.out.println(position);

			CEWorld.gameObjectManager.NewGameObject(g);
		}
	}

	@Override
	public void Destroy() {

	}
}
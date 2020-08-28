package pers.crystal.engine.application;

import java.awt.event.KeyEvent;

import pers.crystal.engine.utility.CETime;
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
	}

	@Override
	public void Destroy() {

	}
}
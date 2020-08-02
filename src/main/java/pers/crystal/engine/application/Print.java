package pers.crystal.engine.application;

import java.awt.event.KeyEvent;

import pers.crystal.engine.components.CEAudio;
import pers.crystal.engine.components.CECamera;
import pers.crystal.engine.utility.CEAsset;
import pers.crystal.engine.utility.CETime;
import pers.crystal.engine.windows.CEInput;

public class Print extends CEComponent {

	@Override
	public void Start() {
		System.out.println(gameObject.GetName() + "寮�濮嬪暒");

	}

	int x = -1, y = -1;

	@Override
	public void Update() {
		if (CEInput.IsKeyDown(KeyEvent.VK_A)) {
			gameObject.transform.Translate(-150*CETime.deltaTime, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_D)) {
			gameObject.transform.Translate(150*CETime.deltaTime, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_E)) {
			gameObject.transform.angle++;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("歌剧魅影(纯音乐).wav"));

		}
		if (CEInput.IsKeyDown(KeyEvent.VK_Q)) {
			gameObject.transform.angle--;
			//((CEAudio)gameObject.world.gameObjectManager.GetGameObject("234").componentManager.GetComponent(CEAudio.class)).SetAudioFile(CEAsset.GetFile("脚步光脚地毯运行.wav"));
		}
	}

	@Override
	public void Destroy() {
		System.out.println("鎴戣鎽ф瘉鍟�");
	}
}
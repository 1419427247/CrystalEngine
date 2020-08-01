package CEApplication;

import CEComponents.CEAudio;
import CEComponents.CECamera;
import CEUtility.CETime;
import CEWindows.CEInput;

import java.awt.event.*;
import java.io.FileInputStream;

public class Print extends CEComponent {

	CEGameObject o;
	@Override
	public void Start() {
		o =  gameObject.world.gameObjectManager.GetGameObject("234");
		System.out.println(gameObject.GetName() + "寮�濮嬪暒");

	}

	int x = -1, y = -1;

	@Override
	public void Update() {
		if (CEInput.IsKeyDown(KeyEvent.VK_A)) {
			o.transform.Translate(-150*CETime.deltaTime, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_D)) {
			o.transform.Translate(150*CETime.deltaTime, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_E)) {
			CECamera.mainCamera.filedOfView++;
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_Q)) {
			o.transform.angle++;
		}
		if (CEInput.IsKeyDown(1)) {
			CEAudio audio = (CEAudio)gameObject.componentManager.GetComponent(CEAudio.class);
			audio.Play();
		}
	}

	@Override
	public void Destroy() {
		System.out.println("鎴戣鎽ф瘉鍟�");
	}
}
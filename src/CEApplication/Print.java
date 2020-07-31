package CEApplication;

import CEComponents.CECamera;
import CEUtility.CETime;
import CEWindows.CEInput;
import java.awt.event.*;
import java.io.File;

public class Print extends CEComponent {

	CEGameObject o;
	@Override
	public void Start() {
		o =  gameObject.world.gameObjectManager.GetGameObject("234");
		System.out.println(gameObject.GetName() + "开始啦");

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
            //CEApplication.xml.write(CEApplication.xml.convertToDocument(gameObject.world.gameObjectManager.root),new File("1.xml"));


			if (x == -1 && y == -1) {
				x = CEInput.mouseX;
				y = CEInput.mouseY;
				return;
			}
			gameObject.transform.Translate((x - CEInput.mouseX) / 1f, (y - CEInput.mouseY) / 1f);
			x = CEInput.mouseX;
			y = CEInput.mouseY;
		} else {
			x = -1;
			y = -1;
		}
	}

	@Override
	public void Destroy() {
		System.out.println("我被摧毁啦");
	}
}
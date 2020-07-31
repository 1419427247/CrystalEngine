package CEApplication;

import CEComponents.CECamera;
import CEWindows.CEInput;
import java.awt.event.*;
import java.io.File;

public class Print extends CEComponent {

	@Override
	public void Start() {
		System.out.println(gameObject.GetName() + "开始啦");

	}

	int x = -1, y = -1;

	@Override
	public void Update() {
		if (CEInput.IsKeyDown(KeyEvent.VK_A)) {
			gameObject.transform.Translate(1, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_D)) {
			gameObject.transform.Translate(-1, 0);
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_E)) {
			CECamera.mainCamera.filedOfView++;
		}
		if (CEInput.IsKeyDown(KeyEvent.VK_Q)) {
			CECamera.mainCamera.gameObject.transform.angle++;
		}
		if (CEInput.IsKeyDown(1)) {
            CEApplication.xml.write(CEApplication.xml.convertToDocument(gameObject.world.gameObjectManager.root),new File("1.xml"));


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
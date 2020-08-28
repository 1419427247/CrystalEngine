package pers.crystal.engine.components;

import java.awt.Color;

import pers.crystal.engine.application.CEApplication;
import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.application.CEInputManager;
import pers.crystal.engine.application.CEWorld;
import pers.crystal.engine.utility.CEVector;
import pers.crystal.engine.windows.CEFrame;

public class CECamera extends CEComponent {
	public static final int SOILDCOLOR = 1;
	public static final int DONTCLEAR = 2;

	public static final int ANTIALIASING_ON = 3;
	public static final int ANTIALIASING_OFF = 4;

	public static CECamera mainCamera;
	public int cleanFlat = CECamera.SOILDCOLOR;

	public int antialiasing = ANTIALIASING_ON;

	public Color backGroundColor = Color.BLUE;

	public float filedOfView = 90f;

	@Override
	public void Start() {
		mainCamera = this;
	}

	@Override
	public void Update() {
		System.out.println((ScreenToWorldPoint()));
	}

	@Override
	public void Destroy() {
		// TODO: Implement this method
	}

	public CEVector ScreenToWorldPoint() {
		CEVector position = mainCamera.gameObject.transform.position;
		double angle = mainCamera.gameObject.transform.angle * Math.PI / 180;
		double x = CEInputManager.mouseX - CEFrame.GetWidth() / 2;
		double y = CEInputManager.mouseY - CEFrame.GetHeight() / 2;

		double _x = x * Math.cos(angle) + y * Math.sin(angle);
		double _y = -x * Math.sin(angle) + y * Math.cos(angle);

		return new CEVector(position.getX() + _x, position.getY() + _y);
	}
}

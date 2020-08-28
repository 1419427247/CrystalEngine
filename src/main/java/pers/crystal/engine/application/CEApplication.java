package pers.crystal.engine.application;

import pers.crystal.engine.windows.CEFrame;

public class CEApplication {
	public static CEXml xml = new CEXml();

	private static CEApplication instance = null;

	private CEApplication(CEWorld world) {
		CEFrame.Create();
		CEXml.Create();
		CEWorldManager.LoadWorld(world);
		CEWorldManager.Run();
	}

	public static synchronized CEApplication Create(CEWorld world) {
		if (instance == null) {
			instance = new CEApplication(world);
		}
		return instance;
	}

}

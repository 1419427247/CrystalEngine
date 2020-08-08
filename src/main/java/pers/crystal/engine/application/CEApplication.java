package pers.crystal.engine.application;

import pers.crystal.engine.windows.CEFrame;

public class CEApplication {
	public static CEFrame frame = new CEFrame();
	public static CEWorldManager world = new CEWorldManager();

	public static CEXml xml = new CEXml();

	private static CEApplication instance = null;

	private CEApplication(CEWorld world) {
		CEApplication.world.LoadWorld(world);
		CEApplication.world.run();
	}

	public static synchronized CEApplication Create(CEWorld world) {
		if (instance == null) {
			instance = new CEApplication(world);
		}
		return instance;
	}

}

package pers.crystal.engine.application;

import pers.crystal.engine.utility.CETime;

public class CEWorldManager {
	private static CEWorld world = null;
	private static CEWorld newWorld = null;
	private static int state;

	public static void LoadWorld(CEWorld world) {
		if (CEWorldManager.world == null) {
			state = CEBehaviorContainer.START;
			CEGameObject.world = world;
			CEWorldManager.world = world;
		} else {
			state = CEBehaviorContainer.DESTORY;
			newWorld = world;
		}
	}

	public static void Run() {
		while (true) {
			long s = System.currentTimeMillis();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			if (world != null) {
				if (state == CEBehaviorContainer.START) {
					world.Start();
					state = CEBehaviorContainer.UPDATE;
				} else if (state == CEBehaviorContainer.UPDATE) {
					world.Update();
				} else if (state == CEBehaviorContainer.DESTORY) {
					world.Destroy();
					CEGameObject.world = world;
					world = newWorld;
					state = CEBehaviorContainer.START;
				}
			}
			CETime.deltaTime = (System.currentTimeMillis() - s) / 1000f;
		}
	}
}

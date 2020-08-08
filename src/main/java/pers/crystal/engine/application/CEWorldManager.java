package pers.crystal.engine.application;

import pers.crystal.engine.utility.CETime;

public class CEWorldManager implements Runnable {
	private CEWorld world;
	private CEWorld newWorld;
	private int state;

	public void LoadWorld(CEWorld world) {
		if (this.world == null) {
			state = CEBehaviorContainer.START;
			CEGameObject.world = world;
			this.world = world;
		}else{
			state = CEBehaviorContainer.DESTORY;
			newWorld = world;
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			long s = System.currentTimeMillis();
			try
			{
				Thread.sleep(20);
			}
			catch (InterruptedException e)
			{
				System.err.println(e);
			}
			if (world != null)
			{
				if (state == CEBehaviorContainer.START)
				{
					System.out.println("START");
					world.Start();
					state = CEBehaviorContainer.UPDATE;
				}
				else if (state == CEBehaviorContainer.UPDATE)
				{
					System.out.println("Update");
					world.Update();
				}
				else if (state == CEBehaviorContainer.DESTORY)
				{
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

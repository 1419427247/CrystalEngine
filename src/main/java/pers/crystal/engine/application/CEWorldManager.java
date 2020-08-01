package pers.crystal.engine.application;

import pers.crystal.engine.utility.CETime;

public class CEWorldManager implements Runnable
{
	private static CEWorld world;
	private static int state;
	private static Thread thread;
	public static void LoadWorld(CEWorld world)
	{
		if (CEWorldManager.world != null)
		{
			CEWorldManager.state = CEBehaviorContainer.DESTORY;
		}
		if (thread != null)
		{
			while (thread.getState() != Thread.State.TERMINATED)
			{
				try
				{
					Thread.sleep(20);
				}
				catch (InterruptedException e)
				{
					System.err.println(e);
				}
			}
		}
		CEWorldManager.world = world;
		CEWorldManager.state = CEBehaviorContainer.START;
		thread = new Thread(new CEWorldManager());
		thread.start();
	}

	@Override
	public void run()
	{
		while (true)
		{
			long s = System.currentTimeMillis();
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				System.err.println(e);
			}
			if (world != null)
			{
				if (state == CEBehaviorContainer.START)
				{
					world.Start();
					state = CEBehaviorContainer.UPDATE;
				}
				else if (state == CEBehaviorContainer.UPDATE)
				{
					world.Update();
				}
				else if (state == CEBehaviorContainer.DESTORY)
				{
					world.Destroy();
					break;
				}
			}
			CETime.deltaTime = (System.currentTimeMillis() - s) / 1000f;
		}
	}
}

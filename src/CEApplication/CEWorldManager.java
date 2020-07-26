package CEApplication;

import CEUtility.CETime;
import CEWindows.CEInput;

public class CEWorldManager implements Runnable
{
	private static CEWorld world;
	private static CEBehaviorState state;
	private static Thread thread;
	public static void LoadWorld(CEWorld world)
	{
		if (CEWorldManager.world != null)
		{
			CEWorldManager.state = CEBehaviorState.destory;
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
		CEWorldManager.state = CEBehaviorState.start;
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
				if (state == CEBehaviorState.start)
				{
					world.Start();
					state = CEBehaviorState.update;
				}
				else if (state == CEBehaviorState.update)
				{
					world.Update();
				}
				else if (state == CEBehaviorState.destory)
				{
					world.Destroy();
					break;
				}
			}
			CETime.deltaTime = (System.currentTimeMillis() - s) / 1000f;
		}
	}
}

package CEApplication;

import CEWindows.CEFrame;

public class CEApplication
{
	public static CEFrame frame = new CEFrame();
	CEApplication(CEWorld world){
		CEWorldManager.LoadWorld(world);
	}
}

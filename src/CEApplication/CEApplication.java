package CEApplication;

import CEWindows.CEFrame;

public class CEApplication
{
	private static CEFrame frame = new CEFrame();
	public static CEXml xml = new CEXml();
	CEApplication(CEWorld world){
		CEWorldManager.LoadWorld(world);
	}
}

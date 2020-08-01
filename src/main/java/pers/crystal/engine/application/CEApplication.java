package pers.crystal.engine.application;

import pers.crystal.engine.windows.CEFrame;

public class CEApplication
{
	public static CEFrame frame = new CEFrame();
	public static CEXml xml = new CEXml();
	CEApplication(CEWorld world){
		CEWorldManager.LoadWorld(world);
	}
}

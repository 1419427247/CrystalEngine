package CEWindows;
import CEApplication.*;

public abstract class CERenderControl
{
	public CEWorld world;
	public CERenderControl(CEWorld world){
		this.world=world;
	}
	public abstract void Paint();
}

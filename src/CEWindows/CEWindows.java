package CEWindows;
import CEApplication.*;

public abstract class CEWindows
{
	public CEWorld world;
	public CEWindows(CEWorld world){
		this.world=world;
	}
	public abstract void Paint();
}

package CEWindows;
import CEApplication.*;

public abstract class CERenderControl
{
	public CEWorld world;
	public CEPaint paint;
	public CERenderControl(CEWorld world,CEPaint paint){
		this.world=world;
		this.paint=paint;
	}
	public abstract void Draw();
}

package CEWindows;
import java.util.*;

public abstract class CEPaint
{
	public static final enum Style
    {
        FILL,
        FILL_AND_STROKE,
        STROKE,
    }
	
	protected int color;
	protected Style style;
	
	public void SetColor(int color){
		this.color=color;
	}
	
	public void SetStyle(Style style){
		this.style=style;
	}
	
}

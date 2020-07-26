package CEComponents;

import CEApplication.*;
import java.awt.*;

public class CECamera extends CEComponent
{
	public enum CleanFlat{
		SOILDCOLOR,
		DONTCLEAR,
	}
	public static CECamera mainCamera;
	public CleanFlat cleanFlat;
	public Color backGroundColor = Color.BLUE;
	@Override
	public void Start()
	{
		mainCamera=this;
	}

	@Override
	public void Update()
	{
		// TODO: Implement this method
	}

	@Override
	public void Destroy()
	{
		// TODO: Implement this method
	}
}

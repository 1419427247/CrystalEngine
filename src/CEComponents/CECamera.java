package CEComponents;

import CEApplication.*;
import java.awt.*;

public class CECamera extends CEComponent
{
	public static final int SOILDCOLOR = 1;
	public static final int DONTCLEAR = 2;
	public static CECamera mainCamera;
	public int cleanFlat = CECamera.SOILDCOLOR;
	public Color backGroundColor = Color.BLUE;
	public float filedOfView = 90f;
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

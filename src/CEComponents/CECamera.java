package CEComponents;

import CEApplication.*;

public class CECamera extends CEComponent
{
	public enum CleanFlat{
		SOILDCOLOR,
		DONTCLEAR,
	}
	public static CECamera mainCamera;
	private CleanFlat cleanFlat;
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

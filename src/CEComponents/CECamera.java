package CEComponents;

import CEApplication.*;

public class CECamera extends CEComponent
{
	public static CECamera mainCamera;
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

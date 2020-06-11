package CEGameObject;

import CEApplication.CEGameObject;
import CEApplication.CEWorld;

public class Sprite extends CEGameObject
{

	@Override
	public void Destroy()
	{
		// TODO: Implement this method
	}
	
	
	protected int order;
	public Sprite(String name) {
		
		super(name);
	
	}
	public Sprite(String name, CEWorld world) {
		super(name, world);
	}
	
}

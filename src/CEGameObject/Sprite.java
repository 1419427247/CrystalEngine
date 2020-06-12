package CEGameObject;

import CEApplication.CEGameObject;
import CEApplication.CEWorld;

public class Sprite extends CEGameObject
{
	
	protected int order;
	public Sprite(String name) {
		
		super(name);
	
	}
	public Sprite(String name, CEWorld world) {
		super(name, world);
	}
	
}

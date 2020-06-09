package CEGameObject;

import CEApplication.GameObject;
import CEApplication.World;

public class Sprite extends GameObject {
	protected int order;
	public Sprite(String name, World world) {
		super(name, world);
	}
	
}

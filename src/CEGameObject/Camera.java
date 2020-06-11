package CEGameObject;

import CEApplication.CEGameObject;
import CEApplication.CEWorld;
import java.util.*;
import CEApplication.*;

public class Camera extends CEGameObject
{
	public Camera(String name)
	{
		super(name);
	}
	public Camera(String name, CEWorld world)
	{
		super(name, world);
	}
}

package CEApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Perfab
{
	private GameObject gameObject;
	public Perfab(GameObject gameObject)
	{
		this.gameObject = gameObject;
	}
	private GameObject Clone(GameObject gameObject)
	{
		GameObject object = new GameObject(gameObject.name);
		for (Component component : gameObject.components)
		{
			object.AddComponent(component.getClass());
		}
		for (GameObject child : gameObject.children)
		{
			object.AddChild(Clone(child));
		}
		return gameObject;
	}

	public GameObject Instantiation()
	{
		return Clone(gameObject);
	}
}

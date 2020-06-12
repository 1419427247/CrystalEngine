package CEApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class CEPerfab implements Serializable
{
	private CEGameObject gameObject;
	public CEPerfab(CEGameObject gameObject)
	{
		this.gameObject = gameObject;
	}
	private CEGameObject Clone(CEGameObject gameObject)
	{
		CEGameObject object = new CEGameObject(gameObject.name);
		for (CEBehave behave : gameObject.componentManager.list)
		{
			object.componentManager.AddComponent(((CEComponent)behave).getClass());
		}
		for (CEGameObject child : gameObject.children)
		{
			object.AddChild(Clone(child));
		}
		return gameObject;
	}

	public CEGameObject Instantiation()
	{
		return Clone(gameObject);
	}
}

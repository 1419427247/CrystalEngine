package CEApplication;

import CEUtility.*;
import java.util.*;

public class CEGameObjectManager extends CEBehaviorContainer
{
	public class EventType {
		public static final int OnGameObjectCreated=1;
	}
		
	HashMap<String,CEGameObject> gameObjectsMap;
	CEWorld world;
	
	public CEGameObjectManager(CEWorld world)
	{
		gameObjectsMap=new HashMap<String,CEGameObject>();
		this.world=world;
	}
	
	public void AddEventListener(CEEventListener<CEBehaviorContainer> listener){
		event.Add(listener);
	}
	
	public CEGameObject AddGameObject(CEGameObject gameObject)
	{
		if (gameObject == null)
		{
			throw new NullPointerException();
		}
		
		if (gameObjectsMap.containsKey(gameObject.name))
		{
			throw new RuntimeException("Game object name: "+gameObject.name+" already exists");
		}
		gameObject.world=this.world;
		super.Add(gameObject);
		gameObjectsMap.put(gameObject.name,gameObject);
		event.DoEvent(this,EventType.OnGameObjectCreated,gameObject);
		for (CEGameObject child:gameObject.children)
		{
			gameObject.AddChild(AddGameObject(child));	
		}
		return gameObject;			
	}

	public CEGameObject AddGameObject(CEGameObjectPerfab perfab)
	{
		return AddGameObject(perfab.Instantiation());
	}

	public CEGameObject AddGameObject(String name)
	{
		return AddGameObject(new CEGameObject(name));
	}
	
	public CEGameObject NewGameObject(CEGameObject gameObject)
	{
		if (gameObject == null)
		{
			throw new NullPointerException();
		}
		if (!gameObjectsMap.containsKey(gameObject.name))
		{
			gameObject.world=this.world;
			gameObjectsMap.put(gameObject.name, gameObject);
			super.New(gameObject);
			for (CEGameObject child:gameObject.children)
			{
				gameObject.AddChild(NewGameObject(child));	
			}			
		}
		return gameObject;
	}
	
	
	public void NewGameObject(CEGameObjectPerfab perfab)
	{
		if (perfab == null)
		{
			throw new NullPointerException();
		}
		NewGameObject(perfab.Instantiation());
	}

	public void NewGameObject(String name)
	{
		NewGameObject(new CEGameObject(name));
	}


	public CEGameObject GetGameObject(String name)
	{
		return gameObjectsMap.get(name);
	}

	public void RemoveGameObject(CEGameObject gameObject){
//		if (gameObjectsMap.get(gameObject.name) == null)
//		{
//			throw new NullPointerException();
//		}
//		LinkedList<CEGameObject> list = new LinkedList<CEGameObject>();
//		list.add(gameObjectsMap.get(gameObject.name));
//		while (list.size() > 0)
//		{
//			CEGameObject first = list.getFirst();
//			for (CEGameObject child : first.children)
//			{
//				list.add(child);
//			}
//			gameObject.isDestoryed=true;
//			gameObjectsMap.remove(first.name);
//			super.Remove(first);
//			list.removeFirst();
//		}
		
		if (gameObjectsMap.get(gameObject.name) == null)
		{
			throw new NullPointerException();
		}
		for (CEGameObject child : gameObject.children)
		{
			RemoveGameObject(child);
		}
		
		gameObject.isDestoryed=true;
		gameObjectsMap.remove(gameObject.name);
		super.Remove(gameObject);
		gameObject.SetParent(null);
		
	}
	
	public void RemoveGameObject(String name)
	{
		RemoveGameObject(GetGameObject(name));
	}

	public void DestroyGameObject(CEGameObject gameObject)
	{
		if (gameObject == null)
		{
			throw new NullPointerException();
		}
		
		for (CEGameObject child : gameObject.children)
		{
			DestroyGameObject(child);
		}
		gameObject.isDestoryed=true;
		gameObjectsMap.remove(gameObject.name);
		super.Destroy(gameObject);
	}
	
	public void DestroyGameObject(String name)
	{
		DestroyGameObject(GetGameObject(name));
	}
	
}

package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import CETool.Event;
import CETool.EventListener;

enum WorldState
{
	really,
	run,
	finish,
}

public class World
{
	public static class WorldEvent
	{
		public static final int OnGameObjectCreated = 1;
		public static final int OnGameObjectDestroyed = 2;
		public static final int OnComponentCreated = 3;
		public static final int OnComponentDestroyed = 4;
	}
	Event<World> event;
	WorldState state;
	HashMap<String, GameObject> gameObjects;

	ArrayList<GameObject> gameObjectsTrash;
	ArrayList<GameObject> gameObjectsNew;

	public World()
	{
		event = new Event<World>(this);
		state = WorldState.really;
		gameObjects = new HashMap<String, GameObject>();
		gameObjectsTrash = new ArrayList<GameObject>();
		gameObjectsNew = new ArrayList<GameObject>();
	}

	public void Update()
	{
		if (state == WorldState.really)
		{
			state = WorldState.run;
			for (GameObject gameObject : gameObjects.values())
			{
				gameObject.Start();
			}
		}
		if (state == WorldState.run)
		{
			for (GameObject gameObject : gameObjects.values())
			{
				gameObject.Update();
			}
		}
		if (state == WorldState.finish)
		{
			for (GameObject gameObject : gameObjects.values())
			{
				gameObject.Destroyed();
			}
			return;
		}

		for (int i = gameObjectsTrash.size() - 1;i >= 0;i--)
		{
			DestroyComponent(gameObjectsTrash.get(i));
		}
		for (int i = gameObjectsNew.size() - 1;i >= 0;i--)
		{
			NewGameObject(gameObjectsNew.get(i));
		}
		gameObjectsTrash.clear();
		gameObjectsNew.clear();
	}

	public void Destroy()
	{
		state = WorldState.finish;
	}

	public WorldState GetState()
	{
		return state;
	}

	public GameObject AddGameObject(GameObject gameObject)
	{
		if (gameObject == null)
		{
			throw new NullPointerException();
		}
		if (state != WorldState.really)
		{
			throw new RuntimeException("You can’t use the method ‘AddGameObject’ when GameState == really");
		}
		if (gameObjects.containsKey(gameObject.name))
		{
			throw new RuntimeException("Game object name: "+gameObject.name+" already exists");
		}
		gameObject.world = this;
		gameObjects.put(gameObject.name,gameObject);
		for (GameObject child:gameObject.children)
		{
			AddGameObject(child);	
		}
		return gameObject;			
	}

	public GameObject AddGameObject(Perfab perfab)
	{
		return AddGameObject(perfab.Instantiation());
	}

	public GameObject AddGameObject(String name)
	{
		return AddGameObject(new GameObject(name));
	}

	public void NewGameObject(Perfab perfab)
	{
		if (perfab == null)
		{
			throw new NullPointerException();
		}
		gameObjectsNew.add(perfab.Instantiation());
	}

	public void NewGameObject(String name)
	{
		gameObjectsNew.add(new GameObject(name));
	}

	private void NewGameObject(GameObject gameObject)
	{
		if (gameObjects == null)
		{
			throw new NullPointerException();
		}
		if (!gameObjects.containsKey(gameObject.name))
		{
			gameObject.world = this;
			gameObjects.put(gameObject.name, gameObject);
			event.DoEvent(WorldEvent.OnGameObjectCreated, gameObject);
			gameObject.Start();
			for (GameObject child:gameObject.children)
			{
				NewGameObject(child);	
			}			
		}
	}

	public GameObject GetGameObject(String name)
	{
		return gameObjects.get(name);
	}

	public void RemoveGameObject(String name)
	{
		if (gameObjects.get(name) == null)
		{
			throw new NullPointerException();
		}
		LinkedList<GameObject> list = new LinkedList<GameObject>();
		list.add(gameObjects.get(name));
		while (list.size() > 0)
		{
			GameObject gameObject = list.getFirst();
			for (GameObject child : gameObject.children)
			{
				list.add(child);
			}
			gameObjects.remove(gameObject.name);
			list.removeFirst();
		}
	}

	public void DestroyComponent(String name)
	{
		gameObjectsTrash.add(gameObjects.get(name));
	}

	private void DestroyComponent(GameObject gameObject)
	{
		if (gameObject == null)
		{
			throw new NullPointerException();
		}
		LinkedList<GameObject> list = new LinkedList<GameObject>();
		list.add(gameObject);
		while (list.size() > 0)
		{
			GameObject object = list.getFirst();
			for (GameObject child : object.children)
			{
				list.add(child);
			}
			event.DoEvent(WorldEvent.OnGameObjectDestroyed, gameObject);
			object.Destroyed();
			gameObjects.remove(object.name);
			list.removeFirst();
		}
	}
	//	public GameObject CreateGameObject(Perfab name) {
//		if (state == WorldState.really) {
//			
//		}
//	}
//	
//	public GameObject CreateGameObject(String name) {
//		if (state == WorldState.run) {
//			GameObject gameObject = new GameObject(name, this);
//			if (!gameObjects.containsKey(name)) {
//				gameObjects.put(name, gameObject);
//				event.DoEvent(WorldEvent.OnGameObjectCreated,gameObject);
//				return gameObject;
//			}
//			return null;
//		}
//	}
//
//	public GameObject GetGameObject(String name) {
//		return gameObjects.get(name);
//	}
//
//	public void DestroyGameObject(String name) {
//		gameObjectsTrash.add(name);
//	}
//	
//	public void CreateComponent(String name,Class<? extends Component> component) {
//		Component c;
//		try {
//			c = component.getDeclaredConstructor().newInstance();
//			c.gameObject = gameObjects.get(name);
//			if (state == WorldState.run) {
//				c.Start();				
//			}
//			gameObjects.get(name).components.add(c);
//			event.DoEvent(WorldEvent.OnComponentCreated,c);
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public Component GetComponent(String name,Class<? extends Component> clazz) {
//		for (Component component : gameObjects.get(name).components) {
//			if (component.getClass() == clazz) {
//				return component;
//			}
//		}
//		return null;
//	}
//
//	public void DestroyComponent(String name,Class<? extends Component> clazz) {
//		gameObjects.get(name).componentsTrash.add(clazz);
//	}

	public void AddListener(EventListener<World> listener)
	{
		event.addListener(listener);
	}
}

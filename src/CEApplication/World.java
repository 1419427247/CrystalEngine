package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import CETool.Event;
import CETool.EventListener;

enum WorldState{
	really,
	run,
	finish,
}

public class World {
	public static class WorldEvent{
		public static final int OnGameObjectCreated = 1;
		public static final int OnGameObjectDestroyed = 2;
		public static final int OnComponentCreated = 3;
		public static final int OnComponentDestroyed = 4;
	}
	Event<World> event;
	WorldState state;
	HashMap<String, GameObject> gameObjects;
	
	ArrayList<String> gameObjectsTrash;
	ArrayList<Perfab> gameObjectsNew;
	
	public World() {
		event = new Event<World>(this);
		state = WorldState.really;
		gameObjects = new HashMap<String, GameObject>();
		gameObjectsTrash = new ArrayList<String>();
		gameObjectsNew = new ArrayList<Perfab>();
	}
	
	public void Update() {
		if (state == WorldState.really) {
			state = WorldState.run;
			for (GameObject gameObject : gameObjects.values()) {
				gameObject.Start();
			}
		}
		if (state == WorldState.run) {
			for (String name : gameObjectsTrash) {
				RemoveGameObject(name);
			}
			for (Perfab perfab : gameObjectsNew) {
				AddGameObject(perfab);
			}
			gameObjectsTrash.clear();
			for (GameObject gameObject : gameObjects.values()) {
				gameObject.Update();
			}
		}
		if (state == WorldState.finish) {
			for (GameObject gameObject : gameObjects.values()) {
				gameObject.Destroyed();
			}
			gameObjectsTrash.clear();
			return;
		}
	}

	public void Destroy() {
		state = WorldState.finish;
	}
	
	public WorldState GetState() {
		return state;
	}
	
	public ArrayList<GameObject> AddGameObject(Perfab perfab) {
		ArrayList<GameObject> list = perfab.Instantiation(this);
		for (GameObject object : list) {
			if (!gameObjects.containsKey(object.name)) {
				gameObjects.put(object.name, object);
				event.DoEvent(WorldEvent.OnGameObjectCreated, object);
				if (state == WorldState.run) {
					object.Start();
				}
			}
		}
		return list;
	}
	
	public ArrayList<GameObject> AddGameObject(String name) {
		return AddGameObject(new Perfab(new GameObject(name)));
	}
	
	public void NewGameObject(Perfab perfab){
		gameObjectsNew.add(perfab);
	}
	
	public void NewGameObject(String name){
		gameObjectsNew.add(new Perfab(new GameObject(name)));
	}

	public GameObject GetGameObject(String name) {
		return gameObjects.get(name);
	}
	
	public void RemoveGameObject(String name){
		if (gameObjects.get(name) != null) {
			LinkedList<GameObject> list = new LinkedList<GameObject>();
			list.add(gameObjects.get(name));
			while (list.size() > 0) {
				GameObject gameObject = list.getFirst();
				for (GameObject child : gameObject.children) {
					list.add(child);
				}
				event.DoEvent(WorldEvent.OnGameObjectDestroyed,gameObject);
				gameObject.Destroyed();
				gameObjects.remove(name);
				list.removeFirst();
			}
		}
	}
	
	public void DestroyComponent(String name) {
		gameObjectsTrash.add(name);
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
	
	public void AddListener(EventListener<World> listener) {
		event.addListener(listener);
	}
}

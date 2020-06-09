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

	public World() {
		event = new Event<World>(this);
		state = WorldState.really;
		gameObjects = new HashMap<String, GameObject>();
		gameObjectsTrash = new ArrayList<String>();
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
	
	public GameObject CreateGameObject(String name) {
		GameObject gameObject = new GameObject(name, this);
		if (!gameObjects.containsKey(name)) {
			gameObjects.put(name, gameObject);
			event.DoEvent(WorldEvent.OnGameObjectCreated,gameObject);
			return gameObject;
		}
		return null;
	}

	public GameObject GetGameObject(String name) {
		return gameObjects.get(name);
	}

	public void DestroyGameObject(String name) {
		gameObjectsTrash.add(name);
	}
	
	public void CreateComponent(String name,Class<? extends Component> component) {
		try {
			Component c = component.getDeclaredConstructor().newInstance();
			c.gameObject = gameObjects.get(name);
			if (state == WorldState.run) {
				c.Start();				
			}
			gameObjects.get(name).components.add(c);
			event.DoEvent(WorldEvent.OnComponentCreated,c);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Component GetComponent(String name,Class<? extends Component> clazz) {
		for (Component component : gameObjects.get(name).components) {
			if (component.getClass() == clazz) {
				return component;
			}
		}
		return null;
	}

	public void DestroyComponent(String name,Class<? extends Component> clazz) {
		gameObjects.get(name).componentsTrash.add(clazz);
	}
	
	public void AddListener(EventListener<World> listener) {
		event.addListener(listener);
	}
}

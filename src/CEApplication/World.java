package CEApplication;

import java.util.ArrayList;
import java.util.HashMap;

public class World {
	private WorldState state = WorldState.really;
	private HashMap<String, GameObject> gameObjects = new HashMap<String, GameObject>();
	private ArrayList<String> gameObjectsTrash = new ArrayList<String>();

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
					gameObjects.get(name).Destroyed();
					gameObjects.remove(name);
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
	
	public GameObject NewGameObject(String name) {
		GameObject gameObject = new GameObject(name, this);
		if (!gameObjects.containsKey(name)) {
			gameObjects.put(name, gameObject);
			return gameObject;
		}
		return null;
	}

	public GameObject GetGameObject(String name) {
		return gameObjects.get(name);
	}

	public void RemoveGameObject(String name) {
		gameObjectsTrash.add(name);
	}
}

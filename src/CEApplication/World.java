package CEApplication;

import java.util.ArrayList;
import java.util.HashMap;

public class World {
	private HashMap<String, GameObject> gameObjects = new HashMap<String, GameObject>();
	private ArrayList<String> gameObjectsTrash = new ArrayList<String>();

	public void Start() {
		for (GameObject gameObject : gameObjects.values()) {
			gameObject.Start();
		}
	}

	public void Update() {
		for (String name : gameObjectsTrash) {
			if (gameObjects.get(name) != null) {
				gameObjects.remove(name);
			}
		}
		for (GameObject gameObject : gameObjects.values()) {
			gameObject.Update();
		}
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

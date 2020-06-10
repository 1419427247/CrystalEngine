package CEApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Perfab {
	private GameObject gameObject;
	private ArrayList<GameObject> gameObjects;
	public Perfab(GameObject gameObject) {
		this.gameObject = gameObject;
		gameObjects = new ArrayList<GameObject>();
	}
	private GameObject Clone(GameObject gameObject,World world){
		GameObject object = new GameObject(this.gameObject.name);
		object.world = world;
		for (Component component : this.gameObject.components) {
			object.AddComponent(component.getClass());
		}
		for (GameObject child : gameObject.children) {
			object.AddChild(Clone(child,world));
		}
		gameObjects.add(object);
		return gameObject;
	}
	
	public ArrayList<GameObject> Instantiation(World world){
		gameObjects.clear();
		Clone(gameObject,world);
		return gameObjects;
	}
}

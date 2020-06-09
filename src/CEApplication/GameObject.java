package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

import CEApplication.World.WorldEvent;

public class GameObject {
	protected World world;
	protected String name;

	protected GameObject parent;
	protected ArrayList<GameObject> children = new ArrayList<GameObject>();

	protected HashSet<Component> components = new HashSet<Component>();
	protected ArrayList<Class<? extends Component>> componentsTrash = new ArrayList<Class<? extends Component>>();

	public GameObject(String name, World world) {
		this.name = name;
		this.world = world;
	}

	public String GetName() {
		return name;
	}

	public World GetWorld() {
		return world;
	}

	public boolean HasParent(GameObject gameObject) {
		GameObject value = GetParent();
		while (value != null) {
			if (value == gameObject) {
				return true;
			}
			value = value.GetParent();
		}
		return false;
	}

	public boolean HasChild(GameObject gameObject) {
		return gameObject.HasParent(this);
	}

	public void SetParent(GameObject gameObject) {
		if (gameObject != this) {
			if (gameObject == null) {
				if (parent != null) {
					parent.RemoveChild(this);
				}
				parent = null;
			} else if (parent == null) {
				gameObject.AddChild(this);
			} else {
				parent.RemoveChild(this);
				gameObject.AddChild(this);
			}
		}
	}

	public GameObject GetParent() {
		return parent;
	}

	public boolean AddChild(GameObject gameObject) {
		if (gameObject != this) {
			if (HasParent(gameObject)) {
				return false;
			}
			if (gameObject.parent != null) {
				gameObject.parent.RemoveChild(gameObject);
			}
			gameObject.parent = this;
			children.add(gameObject);
			return true;
		}
		return false;
	}

	public GameObject GetChild(int index) {
		return children.get(index);
	}

	public boolean RemoveChild(GameObject gameObject) {
		if (gameObject.parent == this) {
			gameObject.parent = null;
			return children.remove(gameObject);
		}
		return false;
	}

	public int GetChildSzie() {
		return children.size();
	}

	public void Start() {
		for (Component component : components) {
			component.Start();
		}
	}
	
	public void Update() {
		for (Class<? extends Component> clazz : componentsTrash) {
			for (Component component : components) {
				if (component.getClass() == clazz) {
					world.event.DoEvent(WorldEvent.OnComponentCreated,component);
					component.Destroyed();
					components.remove(component);
					break;
				}
			}
		}
		for (Component component : components) {
			component.Update();
		}
	}
	
	public void Destroyed() {
		for (Component component : components) {
			component.Destroyed();
		}
	}
	
	public void CreateComponent(Class<? extends Component> clazz) {
		world.CreateComponent(name, clazz);
	}

	public Component GetComponent(Class<? extends Component> clazz) {
		return world.GetComponent(name, clazz);
	}

	public void DestroyComponent(Class<? extends Component> clazz) {
		world.DestroyComponent(name,clazz);
	}

}

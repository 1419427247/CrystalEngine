package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

import CEApplication.World.WorldEvent;

public class GameObject {
	protected String name;
	protected World world;

	protected boolean isFrozen = false;
	protected boolean isDestoryed = false;
	
	protected GameObject parent;
	protected ArrayList<GameObject> children = new ArrayList<GameObject>();

	protected HashSet<Component> components = new HashSet<Component>();
	
	protected ArrayList<Class<? extends Component>> componentsNew = new ArrayList<Class<? extends Component>>();
	protected ArrayList<Class<? extends Component>> componentsTrash = new ArrayList<Class<? extends Component>>();

	public GameObject(String name) {
		this.name = name;
		this.world = null;
	}
	
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

	public boolean isFrozen() {
		return isFrozen;
	}

	public boolean isDestoryed() {
		return isDestoryed;
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
		if(gameObject==null){
			throw new NullPointerException();
		}
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
		if(gameObject==null){
			throw new NullPointerException();
		}
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
		if(gameObject==null){
			throw new NullPointerException();
		}
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
			RemoveComponent(clazz);
		}
		for (Class<? extends Component> clazz : componentsNew) {
			Component component = AddComponent(clazz);
			world.event.DoEvent(WorldEvent.OnGameObjectCreated,component);
			component.Start();
		}
		componentsTrash.clear();
		componentsNew.clear();
		for (Component component : components) {
			component.Update();
		}
	}
	
	public void Destroyed() {
		isDestoryed = true;
		for (Component component : components) {
			component.Destroyed();
		}
	}
	
	public Component AddComponent(Class<? extends Component> clazz) {
		try {
			Component component = clazz.getDeclaredConstructor().newInstance();
			component.gameObject = this;
			if(world!=null){
				component.Awake();
			}
			components.add(component);
			return component;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void RemoveComponent(Class<? extends Component> clazz) {
		for (Component component : components) {
			if (component.getClass() == clazz) {
				world.event.DoEvent(WorldEvent.OnComponentDestroyed,component);
				component.Destroyed();
				components.remove(component);
				break;
			}
		}
	}
	
	public void NewComponent(Class<? extends Component> clazz) {
		componentsNew.add(clazz);
	}

	public Component GetComponent(Class<? extends Component> clazz) {
		for (Component component : components) {
			if (component.getClass() == clazz) {
				return component;				
			}
		}
		return null;
	}

	public void DestroyComponent(Class<? extends Component> clazz) {
		componentsTrash.add(clazz);
	}

}

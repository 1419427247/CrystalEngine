package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

public class CEGameObject implements CEBehave
{
	protected String name;
	protected CEWorld world;

	protected boolean isFrozen = false;
	protected boolean isDestoryed = false;
	
	protected CEGameObject parent;
	protected ArrayList<CEGameObject> children = new ArrayList<CEGameObject>();

	protected HashSet<CEComponent> components = new HashSet<CEComponent>();
	
	protected ArrayList<Class<? extends CEComponent>> componentsNew = new ArrayList<Class<? extends CEComponent>>();
	protected ArrayList<Class<? extends CEComponent>> componentsTrash = new ArrayList<Class<? extends CEComponent>>();
	
	public CEGameObject(String name) {
		this.name = name;
		this.world = null;
	}
	
	public CEGameObject(String name, CEWorld world) {
		this.name = name;
		this.world = world;
	}

	public static void initiazlie(){
		
	}
	
	public String GetName() {
		return name;
	}

	public CEWorld GetWorld() {
		return world;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	public boolean isDestoryed() {
		return isDestoryed;
	}

	public boolean HasParent(CEGameObject gameObject) {
		CEGameObject value = GetParent();
		while (value != null) {
			if (value == gameObject) {
				return true;
			}
			value = value.GetParent();
		}
		return false;
	}

	public boolean HasChild(CEGameObject gameObject) {
		if(gameObject==null){
			throw new NullPointerException();
		}
		return gameObject.HasParent(this);
	}

	public void SetParent(CEGameObject gameObject) {
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

	public CEGameObject GetParent() {
		return parent;
	}

	public boolean AddChild(CEGameObject gameObject) {
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

	public CEGameObject GetChild(int index) {
		return children.get(index);
	}

	public boolean RemoveChild(CEGameObject gameObject) {
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
		for (CEComponent component : components) {
			component.Start();
		}
	}
	
	public void Update() {
		for (int i = componentsTrash.size() - 1;i >= 0;i--)
		{
			RemoveComponent(componentsTrash.get(i));
			componentsTrash.remove(i);
		}
		for (int i = componentsNew.size() - 1;i >= 0;i--)
		{
			AddComponent(componentsNew.get(i));
			componentsNew.remove(i);
		}
		for (CEComponent component : components) {
			component.Update();
		}
	}

	@Override
	public void Destroy()
	{
		isDestoryed = true;
		for (CEComponent component : components) {
			component.Destroy();
		}
	}
	
	public CEComponent AddComponent(Class<? extends CEComponent> clazz) {
		try {
			CEComponent component = clazz.getDeclaredConstructor().newInstance();
			component.gameObject = this;
			components.add(component);
			
			if(world!=null){
				//World.gameObjectManager.event.DoEvent(World.WorldEvent.OnComponentCreated,component);
				component.Start();
			}
			
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
	
	public void RemoveComponent(Class<? extends CEComponent> clazz) {
		for (CEComponent component : components) {
			if (component.getClass() == clazz) {
				components.remove(component);
				if(world!=null){
					//world.event.DoEvent(World.WorldEvent.OnComponentCreated,component);
					component.Destroy();
				}
				break;
			}
		}
	}
	
	public void NewComponent(Class<? extends CEComponent> clazz) {
		componentsNew.add(clazz);
	}

	public CEComponent GetComponent(Class<? extends CEComponent> clazz) {
		for (CEComponent component : components) {
			if (component.getClass() == clazz) {
				return component;				
			}
		}
		return null;
	}

	public void DestroyComponent(Class<? extends CEComponent> clazz) {
		componentsTrash.add(clazz);
	}

}

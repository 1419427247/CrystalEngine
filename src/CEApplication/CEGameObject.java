package CEApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

public class CEGameObject extends CEBehave
{
	protected String name;
	protected CEWorld world;

	protected boolean isFrozen = false;
	protected boolean isDestoryed = false;
	
	protected CEGameObject parent;
	protected ArrayList<CEGameObject> children;

	CEComponemtManager componentManager;
	
	
	public CEGameObject(String name) {
		this.name = name;
		this.world = null;
		
		children = new ArrayList<CEGameObject>();
		componentManager = new CEComponemtManager(this);
	}
	
	public CEGameObject(String name, CEWorld world) {
		this.name = name;
		this.world = world;
		
		children = new ArrayList<CEGameObject>();
		componentManager = new CEComponemtManager(this);
	}
	
	@Override
	public void Start()
	{
		componentManager.Start();
	}

	@Override
	public void Update()
	{
		componentManager.Update();
	}

	@Override
	public void Destroy()
	{
		componentManager.Destroy();
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
}

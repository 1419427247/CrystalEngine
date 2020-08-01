package pers.crystal.engine.application;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pers.crystal.engine.components.CETransform;

public class CEGameObject extends CEBehave {
	protected String name;
	protected CEWorld world;

	protected boolean isFrozen = false;
	protected boolean isDestoryed = false;

	protected CEGameObject parent;
	protected ArrayList<CEGameObject> children;

	public CETransform transform;

	public CEComponemtManager componentManager;

	public CEGameObject() {
		this.name = null;
		this.world = null;

		children = new ArrayList<CEGameObject>();
		componentManager = new CEComponemtManager(this);

		transform = new CETransform();
		componentManager.AddComponent(transform);
	}

	public CEGameObject(String name) {
		this.name = name;
		this.world = null;

		children = new ArrayList<CEGameObject>();
		componentManager = new CEComponemtManager(this);

		transform = new CETransform();
		componentManager.AddComponent(transform);
	}

	public CEGameObject(String name, CEWorld world) {
		this.name = name;
		this.world = world;

		children = new ArrayList<CEGameObject>();
		componentManager = new CEComponemtManager(this);

		transform = new CETransform();
		componentManager.AddComponent(transform);
	}

	@Override
	public void Start() {
		componentManager.Start();
	}

	@Override
	public void Update() {
		componentManager.Update();
	}

	@Override
	public void Destroy() {
		componentManager.Destroy();
		SetParent(null);
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
		if (gameObject == null) {
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
				parent = world.gameObjectManager.root;
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
		if (gameObject == null) {
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
		if (gameObject == null) {
			throw new NullPointerException();
		}
		if (gameObject.parent == this) {
			gameObject.parent = world.gameObjectManager.root;
			return children.remove(gameObject);
		}
		return false;
	}

	public int GetChildrenSize() {
		return children.size();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void convertToObject(Node root) {

		Element object = (Element) root;

		this.name = root.getNodeName();
		this.isFrozen = Boolean.parseBoolean(object.getAttribute("isFrozen"));
		this.isDestoryed = Boolean.parseBoolean(object.getAttribute("isDestoryed"));

		NodeList list = object.getChildNodes();
		NodeList children = null;
		NodeList components = null;
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				switch (list.item(i).getNodeName()) {
					case "children":
						children = list.item(i).getChildNodes();
						break;
					case "components":
						components = list.item(i).getChildNodes();
						break;
				}
			}
		}

		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
				AddChild((CEGameObject) CEApplication.xml.convertToObject(children.item(i)));
			}
		}
		for (int i = 0; i < components.getLength(); i++) {
			if (components.item(i).getNodeType() == Node.ELEMENT_NODE) {
				componentManager.AddComponent((CEComponent) CEApplication.xml.convertToObject(components.item(i)));
			}
		}
	}

	@Override
	public void convertToNode(Document document, Node root) {
		Element object = (Element) root;

		object.setAttribute("name", this.name);
		object.setAttribute("isFrozen", Boolean.toString(this.isFrozen));
		object.setAttribute("isDestoryed", Boolean.toString(this.isDestoryed));

		Element children = document.createElement("children");
		for (CEGameObject gameObject : this.children) {
			children.appendChild(CEApplication.xml.convertToNode(document, gameObject));
		}
		object.appendChild(children);

		Element components = document.createElement("components");
		for (CEBehave behave : this.componentManager.list) {
			components.appendChild(CEApplication.xml.convertToNode(document, (CEComponent) behave));
		}
		object.appendChild(components);
	}
}

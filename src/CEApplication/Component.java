package CEApplication;

public abstract class Component {
	GameObject gameObject;

	public Component() {
		this.Awake();
	}

	public abstract void Awake();

	public abstract void Start();

	public abstract void Update();
	
	public abstract void Destroyed();
}

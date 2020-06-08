package CEApplication;

public abstract class Component {
	protected GameObject gameObject;

	public Component() {
		this.Awake();
	}

	public abstract void Awake();

	public abstract void Start();

	public abstract void Update();

}

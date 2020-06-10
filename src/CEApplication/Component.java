package CEApplication;

public abstract class Component {
	GameObject gameObject;

	public abstract void Start();

	public abstract void Update();
	
	public abstract void Destroyed();
}

package CEApplication;

public abstract class CEComponent implements CEBehave{
	CEGameObject gameObject;

	public abstract void Start();

	public abstract void Update();
	
	public abstract void Destroy();
}

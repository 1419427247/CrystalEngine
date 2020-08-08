package pers.crystal.engine.application;

public abstract class CEComponent extends CEBehave {
	public CEGameObject gameObject;

	public abstract void Start();

	public abstract void Update();
	
	public abstract void Destroy();
}

package CEApplication;

import org.w3c.dom.*;

public abstract class CEComponent extends CEBehave {
	public CEGameObject gameObject;

	public abstract void Start();

	public abstract void Update();

	public abstract void Destroy();
}

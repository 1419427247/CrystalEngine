 package CEComponents;

import CEApplication.CEComponent;
import CEUtility.CEVector;

public class Transform extends CEComponent {
	public CEVector position = new CEVector();
//	public Vector l0calPosition = new Vector();
	public CEVector rotation = new CEVector();
//	public Vector l0calRotation = new Vector();
//	public Vector size = new Vector();
//	public Vector localSize = new Vector();
	@Override
	public void Start() {

	}

	@Override
	public void Update() {

	}
	
	@Override
	public void Destroy() {
		
	}
	public void Translate (float x, float y) {
		position.Add(x,y);
	}
	
	public void Translate(CEVector translation) {
		position.Add(translation);
	}
}

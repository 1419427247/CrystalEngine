package CEComponents;

import CEApplication.Component;
import CETool.Vector;

public class Transform extends Component {
	public Vector position = new Vector();
//	public Vector l0calPosition = new Vector();
	public Vector rotation = new Vector();
//	public Vector l0calRotation = new Vector();
//	public Vector size = new Vector();
//	public Vector l0calSize = new Vector();

	@Override
	public void Awake() {

	}

	@Override
	public void Start() {

	}

	@Override
	public void Update() {

	}
	
	@Override
	public void Destroyed() {
		
	}
	public void Translate (float x, float y) {
		position.Add(x,y);
	}
	
	public void Translate(Vector translation) {
		position.Add(translation);
	}
}

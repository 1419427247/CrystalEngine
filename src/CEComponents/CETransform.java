 package CEComponents;

import CEApplication.CEComponent;
import CEUtility.CEVector;

public class CETransform extends CEComponent {
	public CEVector position = new CEVector(0,0);
	public float angle = 0;
	public CEVector scale = new CEVector(1,1);
//	public Vector l0calPosition = new Vector();
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

	public void setAngle(float angle){
		this.angle = angle * (float)Math.PI / 180f;
	}
}

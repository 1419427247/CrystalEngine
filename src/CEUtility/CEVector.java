package CEUtility;

public class CEVector {
	public static final CEVector ZERO = new CEVector(0, 0);
	public static final CEVector UP = new CEVector(0, 1);
	public static final CEVector DWON = new CEVector(0, -1);
	public static final CEVector LEFT = new CEVector(-1, 0);
	public static final CEVector RIGHT = new CEVector(0, 1);

	private double x;
	private double y;

	public CEVector() {
		x = 0;
		y = 0;
	}

	public CEVector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public CEVector(CEVector vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double GetRadian() {
		return Math.atan2(y, x);
	}

	public double GetAngle() {
		return GetRadian() / Math.PI * 180;
	}

	public CEVector Clone() {
		return new CEVector(x, y);
	}

	public double GetLength() {
		return Math.sqrt(GetLengthSQ());
	}

	public double GetLengthSQ() {
		return x * x + y * y;
	}

	public CEVector Zero() {
		x = 0;
		y = 0;
		return this;
	}

	public boolean IsZero() {
		return x == 0 && y == 0;
	}

	public void SetLength(double value) {
		double angle = GetAngle();
		x = Math.cos(angle) * value;
		y = Math.sin(angle) * value;
	}

	public CEVector Normalize() {
		double length = GetLength();
		x = x / length;
		y = y / length;
		return this;
	}

	public boolean IsNormalized() {
		return GetLength() == 1.0;
	}

	public CEVector Reverse() {
		x = -x;
		y = -y;
		return this;
	}

	public double DotProduct(CEVector v) {
		return x * v.x + y * v.y;
	}

	public double CrossProduct(CEVector v) {
		return x * v.y - y * v.x;
	}


	public void Add(CEVector v1) {
		this.x = this.x + v1.x;
		this.y = this.y + v1.y;
	}
	
	public void Add(float x, float y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void Subtract(CEVector v1) {
		this.x = this.x - v1.x;
		this.y = this.y - v1.y;
	}
	
	public void Subtract(float x, float y) {
		this.x = this.x - x;
		this.y = this.y - y;
	}
	
	public void Multiply(double value) {
		this.x = this.x * value;
		this.y = this.y * value;
	}
	
	public void Divide(double value) {
		this.x = this.x / value;
		this.y = this.y / value;
	}
	
	public static double RadianBetween(CEVector v1, CEVector v2) {
		if (!v1.IsNormalized())
			v1 = v1.Clone().Normalize();
		if (!v2.IsNormalized())
			v2 = v2.Clone().Normalize();
		return Math.acos(v1.DotProduct(v2));
	}

	public static double Radian2Angle(double radian) {
		return radian / Math.PI * 180;
	}

	public static CEVector Add(CEVector v1, CEVector v2) {
		return new CEVector(v1.x + v2.x, v1.y + v2.y);
	}

	public static CEVector Subtract(CEVector v1, CEVector v2) {
		return new CEVector(v1.x - v2.x, v1.y - v2.y);
	}

	public static CEVector Multiply(CEVector v1, double value) {
		return new CEVector(v1.x * value, v1.y * value);
	}

	public static CEVector Divide(CEVector v1, double value) {
		return new CEVector(v1.x / value, v1.y / value);
	}
}

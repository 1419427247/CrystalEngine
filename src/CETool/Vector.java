package CETool;

public class Vector {
	public static final Vector ZERO = new Vector(0, 0);
	public static final Vector UP = new Vector(0, 1);
	public static final Vector DWON = new Vector(0, -1);
	public static final Vector LEFT = new Vector(-1, 0);
	public static final Vector RIGHT = new Vector(0, 1);

	private double x;
	private double y;

	public Vector() {
		x = 0;
		y = 0;
	}

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
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

	public Vector Clone() {
		return new Vector(x, y);
	}

	public double GetLength() {
		return Math.sqrt(GetLengthSQ());
	}

	public double GetLengthSQ() {
		return x * x + y * y;
	}

	public Vector Zero() {
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

	public Vector Normalize() {
		double length = GetLength();
		x = x / length;
		y = y / length;
		return this;
	}

	public boolean IsNormalized() {
		return GetLength() == 1.0;
	}

	public Vector Reverse() {
		x = -x;
		y = -y;
		return this;
	}

	public double DotProduct(Vector v) {
		return x * v.x + y * v.y;
	}

	public double CrossProduct(Vector v) {
		return x * v.y - y * v.x;
	}


	public void Add(Vector v1) {
		this.x = this.x + v1.x;
		this.y = this.y + v1.y;
	}
	
	public void Add(float x, float y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void Subtract(Vector v1) {
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
	
	public static double RadianBetween(Vector v1, Vector v2) {
		if (!v1.IsNormalized())
			v1 = v1.Clone().Normalize();
		if (!v2.IsNormalized())
			v2 = v2.Clone().Normalize();
		return Math.acos(v1.DotProduct(v2));
	}

	public static double Radian2Angle(double radian) {
		return radian / Math.PI * 180;
	}

	public static Vector Add(Vector v1, Vector v2) {
		return new Vector(v1.x + v2.x, v1.y + v2.y);
	}

	public static Vector Subtract(Vector v1, Vector v2) {
		return new Vector(v1.x - v2.x, v1.y - v2.y);
	}

	public static Vector Multiply(Vector v1, double value) {
		return new Vector(v1.x * value, v1.y * value);
	}

	public static Vector Divide(Vector v1, double value) {
		return new Vector(v1.x / value, v1.y / value);
	}
}

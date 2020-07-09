package CEWindows;

public final class CERect
{
    public float bottom=0;

    public float left=0;

    public float right=0;

    public float top=0;

    public float width() {
		return Math.abs(right-left);
	}

    public float height() {
		return Math.abs(top-bottom);
	}

    public float centerX() {
		return (left+right)/2f;
	}

    public float centerY() {
		return (top+bottom)/2f;
	}

    public void set(float left, float top, float right, float bottom) {
		this.left=left;
		this.top=top;
		this.right=right;
		this.bottom=bottom;
	}

    public void set(CERect src) {
		this.left=src.left;
		this.top=src.top;
		this.right=src.right;
		this.bottom=src.bottom;
	}

    public void offset(float dx, float dy) {
		this.left+=dx;
		this.top+=dy;
		this.right+=dx;
		this.bottom+=dy;
	}

    public void offsetTo(float newLeft, float newTop) {
		float width = width();
		float height = height();
		this.left=newLeft;
		this.top=newTop;
		this.right+=width;
		this.bottom+=height;
	}

    public void inset(float dx, float dy) {
		this.left+=dx;
		this.right-=dx;
		
		this.top+=dy;
		this.bottom-=dy;
	}

    public boolean contains(float x, float y) {
		return x>left&&x<right&&y>bottom&&y<top;
	}

    public boolean contains(float left, float top, float right, float bottom) {
		return left>this.left&&top<this.top&&bottom>this.bottom&&right<this.right;
	}

    public boolean contains(CERect r) {
		return contains(r.left,r.top,r.right,r.bottom);
	}

    public void union(float left, float top, float right, float bottom) {}

    public void union(CERect r) {}

    public void union(float x, float y) {
		
	}

    public void sort() {}

    public CERect() {
		this.left=0;
		this.top=0;
		this.right=0;
		this.bottom=0;
	}

    public CERect(float left, float top, float right, float bottom) {
		this.left=left;
		this.top=top;
		this.right=right;
		this.bottom=bottom;
	}

    public CERect(CERect r) {
		this.left=r.left;
		this.top=r.top;
		this.right=r.right;
		this.bottom=r.bottom;
	}
}

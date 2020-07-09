package CEUtility;

public class CEQuadTree
{
	private CEQuadTreeNode root;
	private int deep;
	private int maxDeep;
	public CEQuadTree(int maxDeep){
		this.deep = 0;
		this.maxDeep = maxDeep;
	}
}

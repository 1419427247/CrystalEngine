package CEUtility;

public class CEQuadTreeNode<T>
{
	T object;
	CETrigger circle;
	CEQuadTreeNode parent;
	CEQuadTreeNode[] children;
	public CEQuadTreeNode(T object,CETrigger circle){
		this.object = object;
		this.circle = circle;
		children = new CEQuadTreeNode[4];
	}
	public void insert(CEQuadTreeNode node){
		
	}
}

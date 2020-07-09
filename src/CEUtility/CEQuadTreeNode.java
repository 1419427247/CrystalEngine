package CEUtility;
import CEWindows.*;

public class CEQuadTreeNode<T>
{
	T object;
	CERect rect;
	CEQuadTreeNode parent;
	CEQuadTreeNode[] children;
	public CEQuadTreeNode(T object,CERect rect){
		this.object = object;
		this.rect = rect;
		children = new CEQuadTreeNode[4];
	}
	public void insert(CEQuadTreeNode node){
		
	}
}

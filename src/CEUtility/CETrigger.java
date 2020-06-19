package CEUtility;
import java.util.*;

public class CETrigger
{
	CEVector anchor;
	double maxDistance;
	ArrayList<CEEdge> edges;
	public CETrigger(CEVector anchor, ArrayList<CEVector> pointList)
	{
		this.anchor = anchor;
		this.edges = new ArrayList<CEEdge>();
		for (int i = 0;i < pointList.size();i++)
		{
			double distance = CEVector.Subtract(pointList.get(i), anchor).GetLength();
			if (maxDistance < distance)
				maxDistance = distance;
			if (i == 0)
			{
				edges.add(new CEEdge(pointList.get(i),pointList.get(pointList.size())));
			}else{
				edges.add(new CEEdge(pointList.get(i),pointList.get(i-1)));
			}
		}
	}
	public static CEVector[] Intersect(CETrigger trigger1, CETrigger trigger2)
	{
		for (CEEdge vector:trigger1.edges)
		{

		}

		for i,v in ipairs(a.edges) do
        local axis = perp(v)
        local a_, b_ = project(a, axis), project(b, axis)
        if notoverlap(a_, b_)then return false end
		end
		for i,v in ipairs(b.edges) do
        local axis = perp(v)
        local a_, b_ = project(a, axis), project(b, axis)
        if notoverlap(a_, b_)then return false end
		end

		return null;
	}
}

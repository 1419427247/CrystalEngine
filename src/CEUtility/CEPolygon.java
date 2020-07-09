package CEUtility;
import java.util.*;
import CEApplication.*;

public class CEPolygon
{
	public CEVector[] points;
	protected CEVector[] _points;
	public CEPolygon(CEVector ...points)
	{
		this._points = points;
		this.points = points;
	}

	public CEPolygon(final List<CEVector> points)
	{
		this._points = (CEVector[]) points.toArray();
		this.points = this._points;
	}
	
	public void Set(CEVector ...points){
		this._points = points;
		this.points = points;
	}
	
	public void SetPosition(CEVector position)
	{
		for (int i=0;i < _points.length;i++)
		{
			points[i] = new CEVector(_points[i].getX()+position.getX(),_points[i].getY()+position.getY());
		}
	}
	
	public void SetRotation(double angle)
	{
		angle=-angle*(Math.PI/180);
		for (int i=0;i < _points.length;i++)
		{
			points[i] = new CEVector(_points[i].getX()*Math.cos(angle)-_points[i].getY()*Math.sin(angle),
									 _points[i].getX()*Math.sin(angle)+_points[i].getY()*Math.cos(angle));
		}
	}
}

package pers.crystal.engine.utility;

public class CECubePolygon extends CEPolygon
{
	public double width,height;
	public CECubePolygon(double width,double height){
		super(new CEVector(-width/2,-height/2),
			  new CEVector(width/2,-height/2),
			  new CEVector(width/2,height/2),
			  new CEVector(-width/2,height/2));
		this.width = width;
		this.height = height;
	}
	public void SetWidth(double width)
	{
		this.width=width;
		Set(new CEVector(-width/2,-height/2),
			new CEVector(width/2,-height/2),
			new CEVector(width/2,height/2),
			new CEVector(-width/2,height/2));
	}
	public void SetHeight(double height){
		this.height=height;
		Set(new CEVector(-width/2,-height/2),
			new CEVector(width/2,-height/2),
			new CEVector(width/2,height/2),
			new CEVector(-width/2,height/2));
	}
}

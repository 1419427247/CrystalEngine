package CEApplication;

import CEGameObject.*;
import java.util.*;
class Print extends CEComponent
{
	@Override
	public void Update()
	{
		
	}

	@Override
	public void Start()
	{
		System.out.println("开始啦");

	}

	@Override
	public void Destroy()
	{
		
	}
}

public class Program
{
	public static void main(String[] args)
	{
		
		CEGameObject p1 = new Camera("QWQ");
		p1.AddComponent(Print.class);
		CEPerfab perfab = new CEPerfab(p1);

		CEWorld world = new CEWorld();
		
		world.gameObjectManager.AddGameObject(perfab.Instantiation());
		
		while (true)
		{
			world.Update();
		}
	}
}

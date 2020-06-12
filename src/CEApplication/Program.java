package CEApplication;

import CEGameObject.*;
import java.util.*;
class Print extends CEComponent
{
	@Override
	public void Update()
	{
		gameObject.world.gameObjectManager.DestroyGameObject(this.gameObject);
		
		System.out.println("我是"+gameObject.GetName());
	}

	@Override
	public void Start()
	{
		System.out.println(gameObject.GetName()+"开始啦");

	}

	@Override
	public void Destroy()
	{
		System.out.println("我被摧毁啦");
	}
}

public class Program
{
	public static void main(String[] args)
	{
		CEGameObject p1 = new Camera("QWQ");
		p1.componentManager.AddComponent(Print.class);
		CEPerfab perfab = new CEPerfab(p1);

		CEWorld world = new CEWorld();
		
		world.gameObjectManager.AddGameObject(perfab.Instantiation());
		
		world.Update();
		world.Update();
		world.Update();
		world.Update();
		world.Update();
	}
}

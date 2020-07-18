package CEApplication;

import CEUtility.*;
import java.util.*;
import java.nio.channels.*;
class Print extends CEComponent
{
	public int x;
	@Override
	public void Update()
	{		
		System.out.println("我是" + gameObject.GetName());
		
		System.out.println("我有"+gameObject.GetChildrenSize());
	}

	@Override
	public void Start()
	{
		System.out.println(gameObject.GetName() + "开始啦");
		

	}

	@Override
	public void Destroy()
	{
		System.out.println("我被摧毁啦");
	}
}

public class Program
{
	public static void main(String[] args) throws InterruptedException
	{

		System.out.println("我的");
		
		// 	CEWorld world = new CEWorld();
		// 	world.gameObjectManager.AddGameObject(new CEGameObject("123"));
		// 	world.gameObjectManager.AddGameObject(new CEGameObject("1234")).SetParent(world.gameObjectManager.GetGameObject("123"));
		// 	world.gameObjectManager.GetGameObject("1234").componentManager.AddComponent(Print.class);
		// 	world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
			
		// 	CEWorldManager.LoadWorld(world);
			
		// 	Thread.sleep(200);
			
			
		// CEWorld world2 = new CEWorld();
		// world2.gameObjectManager.AddGameObject(new CEGameObject("a"));
		// world2.gameObjectManager.AddGameObject(new CEGameObject("b")).SetParent(world2.gameObjectManager.GetGameObject("a"));
		// world2.gameObjectManager.GetGameObject("a").componentManager.AddComponent(Print.class);
		// world2.gameObjectManager.GetGameObject("b").componentManager.AddComponent(Print.class);
		
			
		// 	System.out.println("价值");

			//world.gameObjectManager.AddGameObject(perfab.Instantiation()
	}
}

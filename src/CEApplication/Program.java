package CEApplication;

import CEUtility.*;
import java.sql.*;
import java.util.*;
import java.nio.channels.*;
class Print extends CEComponent
{
	public int x;
	@Override
	public void Update()
	{		
		System.out.println("我是" + gameObject.GetName());
		if(gameObject.world.gameObjectManager.GetGameObject("123")!=null){
		gameObject.world.gameObjectManager.DestroyGameObject("123");
		}
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
	public static void main(String[] args)
	{
		try
		{
			CEWorld world = new CEWorld();
			world.gameObjectManager.AddGameObject(new CEGameObject("123"));
			world.gameObjectManager.AddGameObject(new CEGameObject("1234")).SetParent(world.gameObjectManager.GetGameObject("123"));
			world.gameObjectManager.GetGameObject("123").componentManager.AddComponent(Print.class);
			world.Start();
			world.Update();
			world.Update();
			world.Destroy();
		}
		catch(Exception e){
			System.err.println(e);
		}
		
			//world.gameObjectManager.AddGameObject(perfab.Instantiation());
		System.out.println();
	}
}

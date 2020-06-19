package CEApplication;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.util.*;
import java.lang.reflect.*;
class Print extends CEComponent
{
	public int x;
	@Override
	public void Update()
	{		
		System.out.println("我是" + gameObject.GetName());
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
			CEComponentPerfab perfab = new CEComponentPerfab(new FileInputStream("/storage/emulated/0/AppProjects/CrystalEngine/Component.xml"));
			
			//CEGameObjectPerfab per=new CEGameObjectPerfab(new FileInputStream("/storage/emulated/0/AppProjects/CrystalEngine/Cube.Perfab"));			
			//CEWorld world = new CEWorld();
			//world.gameObjectManager.AddGameObject(per);
//			world.Start();
//			world.Update();
//			world.Update();
//			world.Update();
//			world.Destroy();
		}
		catch(Exception e){
			System.err.println(e);
		}
		
			//world.gameObjectManager.AddGameObject(perfab.Instantiation());
		System.out.println();
	}
}

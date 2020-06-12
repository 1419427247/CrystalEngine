package CEApplication;

import CEGameObject.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.util.*;
import java.lang.reflect.*;
class Print extends CEComponent
{
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
	public static ArrayList<CEComponent> NewComponentsByNode(Node node)
	{
		ArrayList<CEComponent> list=new ArrayList<CEComponent>();
		NodeList components = node.getChildNodes();
		for (int i = 0;i < components.getLength();i++)
		{
			if (components.item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				try
				{
					Class<? extends CEComponent> clazz =(Class<? extends CEComponent>) Class.forName(
						components.item(i).getChildNodes().item(0).getNodeValue()
					);
					CEComponent component = clazz.getDeclaredConstructor().newInstance();
					list.add(component);
				}
				catch (DOMException e)
				{}
				catch (ClassNotFoundException e)
				{}
				catch (InstantiationException e)
				{}
				catch (NoSuchMethodException e)
				{}
				catch (IllegalArgumentException e)
				{}
				catch (InvocationTargetException e)
				{}
				catch (IllegalAccessException e)
				{}
			}
		}
		return list;
	}

	public static CEGameObject NewGameObjectByNode(Node node)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
			NamedNodeMap nodeMap = node.getAttributes();
			CEGameObject gameObject = new CEGameObject(nodeMap.getNamedItem("name").getNodeValue());
			NodeList list = node.getChildNodes();

			for (int i = 0;i < list.getLength();i++)
			{
				switch (list.item(i).getNodeName())
				{
					case "Children":
						{
							NodeList children = list.item(i).getChildNodes();
							for (int j = 0;j < children.getLength();j++)
							{
								CEGameObject obj = NewGameObjectByNode(children.item(j));
								if (obj != null)
									gameObject.AddChild(obj);
							}
						}
						break;
					case "CEComponents":
						{
							for (CEComponent component:NewComponentsByNode(list.item(i)))
							{
								gameObject.componentManager.AddComponent(component);
							}
						}
						break;
				}
			}
			return gameObject;
		}

		return null;

	}
	public static void main(String[] args)
	{

		try
		{
			DocumentBuilder build = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream input = new FileInputStream("/storage/emulated/0/AppProjects/CrystalEngine/File.xml");
			Document doc= build.parse(input);
			CEGameObject g=(NewGameObjectByNode(doc.getDocumentElement()));
			
			CEWorld world = new CEWorld();

			//world.gameObjectManager.AddGameObject(perfab.Instantiation());

			world.gameObjectManager.AddGameObject(g);
			
			world.Start();
			world.Update();
			world.Update();
			world.Update();
			world.Destroy();


		}
		catch (FileNotFoundException e)
		{
		}
		catch (ParserConfigurationException e)
		{
		}
		catch (SAXException e)
		{

		}
		catch (IOException e)
		{

		}



		System.out.println();



	}
}

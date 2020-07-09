package CEApplication;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class CEGameObjectPerfab extends CEPerfab<CEGameObject>
{	
	
	public CEGameObjectPerfab(Element documentElement){
		super(documentElement);
	}

	public CEGameObjectPerfab(InputStream input){
		super(input);
	}
	
	@Override
	public CEGameObject NewPerfabByElement(Element documentElement)
	{
		if (documentElement.getNodeType() == Node.ELEMENT_NODE)
		{
			NamedNodeMap nodeMap = documentElement.getAttributes();
			CEGameObject gameObject = new CEGameObject(nodeMap.getNamedItem("name").getNodeValue());
			NodeList list = documentElement.getChildNodes();

			for (int i = 0;i < list.getLength();i++)
			{
				switch (list.item(i).getNodeName())
				{
					case "Children":
						{
							NodeList children = list.item(i).getChildNodes();
							for (int j = 0;j < children.getLength();j++)
							{
								CEGameObject obj = NewPerfabByElement((Element)children.item(j));
								if (obj != null)
									gameObject.AddChild(obj);
							}
						}
						break;
					case "CEComponents":
						{
							for(int j = 0;j<list.getLength();j++)
							{
								CEComponentPerfab componentPerfab = new CEComponentPerfab((Element)list.item(j));
								gameObject.componentManager.AddComponent(componentPerfab.Instantiation());
							}
						}
						break;
				}
			}
			return gameObject;
		}

		return null;
	}

	@Override
	public CEGameObject Clone()
	{
		// TODO: Implement this method
		return null;
	}
	
	@Override
	public CEGameObject Instantiation()
	{
		return null;
	}
	
//	public CEGameObjectPerfab(CEGameObject gameObject)
//	{
//		if (gameObject == null)
//		{
//			throw new NullPointerException();
//		}
//		this.gameObject = Clone(gameObject);
//	}
//
//	public CEGameObjectPerfab(InputStream input)
//	{
//		try
//		{
//			DocumentBuilder build = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			Document document= build.parse(input);
//			this.gameObject = NewGameObjectByNode(document.getDocumentElement());
//		}
//		catch (FileNotFoundException e)
//		{
//			System.err.println(e);
//		}
//		catch (ParserConfigurationException e)
//		{
//			System.err.println(e);
//		}
//		catch (SAXException e)
//		{
//			System.err.println(e);
//		}
//		catch (IOException e)
//		{
//			System.err.println(e);
//		}
//		catch(Exception e){
//			System.err.println(e);
//		}
//	}
//
//	private ArrayList<CEComponent> NewComponentsByNode(Node node)
//	{
//		ArrayList<CEComponent> list=new ArrayList<CEComponent>();
//		NodeList components = node.getChildNodes();
//		for (int i = 0;i < components.getLength();i++)
//		{
//			if (components.item(i).getNodeType() == Node.ELEMENT_NODE)
//			{
//				try
//				{
//					Class<? extends CEComponent> clazz =(Class<? extends CEComponent>) Class.forName(
//						components.item(i).getChildNodes().item(0).getNodeValue()
//					);
//					CEComponent component = clazz.getDeclaredConstructor().newInstance();
//					list.add(component);
//				}
//				catch (DOMException e)
//				{
//					System.err.println(e);
//				}
//				catch (ClassNotFoundException e)
//				{
//					System.err.println(e);
//				}
//				catch (InstantiationException e)
//				{
//					System.err.println(e);
//				}
//				catch (NoSuchMethodException e)
//				{
//					System.err.println(e);
//				}
//				catch (IllegalArgumentException e)
//				{
//					System.err.println(e);
//				}
//				catch (InvocationTargetException e)
//				{
//					System.err.println(e);
//				}
//				catch (IllegalAccessException e)
//				{
//					System.err.println(e);
//				}
//			}
//		}
//		return list;
//	}
//
//
//	}

//
//	private CEGameObject Clone(CEGameObject gameObject)
//	{
//		CEGameObject object = new CEGameObject(gameObject.name);
//		for (CEBehave behave : gameObject.componentManager.list)
//		{
//			object.componentManager.AddComponent(((CEComponent)behave).getClass());
//		}
//		for (CEGameObject child : gameObject.children)
//		{
//			object.AddChild(Clone(child));
//		}
//		return object;
//	}
//
//	public CEGameObject Instantiation()
//	{
//		return Clone(gameObject);
//	}
}

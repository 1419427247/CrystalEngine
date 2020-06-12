package CEApplication;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class CEPerfab implements Serializable
{
	private CEGameObject gameObject;
	public CEPerfab(CEGameObject gameObject)
	{
		if(gameObject==null){
			throw new NullPointerException();
		}
		this.gameObject = gameObject;
	}
	
	private CEGameObject CreateByNode(Node node){
		if(node.getNodeType() == Node.ELEMENT_NODE){
			System.out.println((node.getAttributes().getNamedItem("name")));
//			CEGameObject gameObject = new CEGameObject();
			
		}
		
		return null;
		
	}
	
	public CEPerfab(String path){
		try
		{
			DocumentBuilder build = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream input = new FileInputStream("/storage/emulated/0/AppProjects/CrystalEngine/File.xml");
			Document doc= build.parse(input);

			this.gameObject=CreateByNode(doc.getDocumentElement());
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
	}
	
	
	private CEGameObject Clone(CEGameObject gameObject)
	{
		CEGameObject object = new CEGameObject(gameObject.name);
		for (CEBehave behave : gameObject.componentManager.list)
		{
			object.componentManager.AddComponent(((CEComponent)behave).getClass());
		}
		for (CEGameObject child : gameObject.children)
		{
			object.AddChild(Clone(child));
		}
		return gameObject;
	}

	public CEGameObject Instantiation()
	{
		return Clone(gameObject);
	}
}

package CEApplication;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public abstract class CEPerfab<T>
{
	T perfab;
	
	public CEPerfab(Element documentElement){
		if(documentElement.getNodeType() != Node.ELEMENT_NODE){
			throw new RuntimeException();
		}
		this.perfab = NewPerfabByElement(documentElement);
	}
	
	public CEPerfab(InputStream input)
	{
		try
		{
			DocumentBuilder build = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document= build.parse(input);
			this.perfab = NewPerfabByElement(document.getDocumentElement());
		}
		catch (FileNotFoundException e)
		{
			System.err.println(e);
		}
		catch (ParserConfigurationException e)
		{
			System.err.println(e);
		}
		catch (SAXException e)
		{
			System.err.println(e);
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}

	public abstract T NewPerfabByElement(Element documentElement);
	
	public abstract T Clone();
	
	public abstract T Instantiation();
}

package CEApplication;
import org.w3c.dom.*;
import java.io.*;
import java.lang.reflect.*;

public class CEComponentPerfab extends CEPerfab<CEComponent>
{

	public CEComponentPerfab(Element documentElement)
	{
		super(documentElement);
	}

	public CEComponentPerfab(InputStream input)
	{
		super(input);
	}

	@Override
	public CEComponent NewPerfabByElement(Element documentElement)
	{
		try
		{
			Class<CEComponent> clazz = (Class<CEComponent>) Class.forName(documentElement.getAttribute("name"));
			CEComponent component = clazz.getDeclaredConstructor().newInstance();
			NodeList fields = documentElement.getChildNodes();
			for (int i = 0;i < fields.getLength();i++)
			{
				if (fields.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					Element fieldInfo = (Element)fields.item(i);
					String name = fieldInfo.getAttribute("name");
					String type = fieldInfo.getAttribute("type");
					String value = fieldInfo .getChildNodes().item(0).getNodeValue();
					System.out.println(name + type + value);

					Field field = clazz.getField(name);

					switch (type)
					{
						case "int":
							field.setInt(component,Integer.parseInt(value));
							break;
						case "boolean":
							field.setBoolean(component,Boolean.parseBoolean(value));
							break;
						case "float":
							field.setFloat(component,Float.parseFloat(value));
							break;
						case "double":
							field.setDouble(component,Double.parseDouble(value));
							break;
						case "byte":
							field.setByte(component,Byte.parseByte(value));
							break;
						case "long":
							field.setLong(component,Long.parseLong(value));
							break;
						case "short":
							field.setShort(component,Short.parseShort(value));
							break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public CEComponent Clone()
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public CEComponent Instantiation()
	{
		// TODO: Implement this method
		return null;
	}
}

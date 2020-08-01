package pers.crystal.engine.utility;
import java.util.*;

public class CESyncValue<T>
{
	private String key;
	private T value;
	private CESyncValue(String key,T value){
		this.key=key;
		this.value=value;
	}
	
	public static HashMap<String,CESyncValue<?>> values=new HashMap<String,CESyncValue<?>>();

	public String getKey()
	{
		return key;
	}

	public void setValue(T value)
	{
		this.value = value;
	}

	public T getValue()
	{
		return value;
	}
	
	public static<T> CESyncValue Create(String key,T value){
		if(values.containsKey(key))
		{
			return values.get(key);
		}
		CESyncValue<T> v=new CESyncValue<T>(key,value);
		values.put(key,v);
		return v;
	}
}

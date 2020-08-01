package pers.crystal.engine.application;

import java.lang.reflect.*;

public class CEComponemtManager extends CEBehaviorContainer
{
	CEGameObject gameObject;
	
	CEComponemtManager(CEGameObject gameObject){
		this.gameObject=gameObject;
	}

	public CEComponent AddComponent(CEComponent component){
		component.gameObject = this.gameObject;
		return (CEComponent)super.Add(component);
	}
	
	public CEComponent AddComponent(Class<? extends CEComponent> clazz) {
		try {
			CEComponent component = clazz.getDeclaredConstructor().newInstance();
			AddComponent(component);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void NewComponent(CEComponent component) {
		component.gameObject = gameObject;
		super.New(component);
	}
	
	public void NewComponent(Class<? extends CEComponent> clazz) {
		try
		{
			CEComponent component = clazz.getDeclaredConstructor().newInstance();
			component.gameObject = gameObject;
			super.New(component);
		}
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

	public CEComponent GetComponent(CEComponent component) {
		for (CEBehave behave : list) {
			if (behave == component) {
				return (CEComponent)behave;				
			}
		}
		return null;
	}
	
	public CEComponent GetComponent(Class<? extends CEComponent> clazz) {
		for (CEBehave behave : list) {
			if (behave.getClass() == clazz) {
				return (CEComponent)behave;				
			}
		}
		return null;
	}
	
	public void RemoveComponent(CEComponent component) {
		for (CEBehave behave : list) {
			if (behave == component) {
				super.Remove(component);
			}
		}
	}
	
	public void RemoveComponent(Class<? extends CEComponent> clazz) {
		for (CEBehave behave : list) {
			if (behave.getClass() == clazz) {
				super.Remove(behave);
			}
		}
	}

	public void DestroyComponent(CEComponent component) {
		super.Destroy(component);
	}
	
	public void DestroyComponent(Class<? extends CEComponent> clazz) {
		DestroyComponent(GetComponent(clazz));
	}
}

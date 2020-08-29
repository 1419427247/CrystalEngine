package pers.crystal.engine.application;

import java.util.ArrayList;

import pers.crystal.engine.utility.CEEvent;

public class CEBehaviorContainer extends CEBehave
{
	public static final int NONE = 1;
	public static final int START = 2;
	public static final int CREATE = 3;
	public static final int REMOVE = 4;
	public static final int UPDATE = 5;
	public static final int DESTORY = 6;

	int state = CEBehaviorContainer.NONE;
	ArrayList<CEBehave> list=new ArrayList<CEBehave>();
	
	ArrayList<CEBehave> listTrash=new ArrayList<CEBehave>();
	ArrayList<CEBehave> listNew=new ArrayList<CEBehave>();

	CEEvent<CEBehaviorContainer> event=new CEEvent<CEBehaviorContainer>();

	@Override
	public void Start()
	{
		state = CEBehaviorContainer.START;
		for (CEBehave behave : list)
		{
			behave.Start();
		}
	}

	@Override
	public void Update()
	{
		state = CEBehaviorContainer.REMOVE;
		for (int i = listTrash.size() - 1;i >= 0;i--)
		{
			Remove(listTrash.get(i));
		}
		listTrash.clear();
		state = CEBehaviorContainer.CREATE;
		for (int i = listNew.size() - 1;i >= 0;i--)
		{
			Add(listNew.get(i));
		}
		listNew.clear();
		state = CEBehaviorContainer.UPDATE;
		
		for (CEBehave behave : list)
		{
			behave.Update();
		}
		state = CEBehaviorContainer.NONE;
	}

	@Override
	public void Destroy()
	{
		state = CEBehaviorContainer.DESTORY;
		for (int i = list.size() - 1;i >= 0;i--)
		{
			Remove(list.get(i));
		}
		state = CEBehaviorContainer.NONE;
		list.clear();
		listTrash.clear();
		listNew.clear();
	}

	public CEBehave Add(CEBehave behave)
	{
		if (state == CEBehaviorContainer.START ||
			state == CEBehaviorContainer.UPDATE || 
			state == CEBehaviorContainer.DESTORY)
		{
			throw new RuntimeException();
		}
		list.add(behave);
		if (state == CEBehaviorContainer.CREATE)
		{
			behave.Start();
		}
		return behave;
	}

	public void New(CEBehave behave)
	{
		
		listNew.add(behave);
	}

	public CEBehave Remove(CEBehave behave)
	{
		if (state == CEBehaviorContainer.START ||
			state == CEBehaviorContainer.UPDATE)
		{
			throw new RuntimeException();
		}
		list.remove(behave);
		if (state == CEBehaviorContainer.REMOVE ||
			state == CEBehaviorContainer.DESTORY)
		{
			behave.Destroy();
		}
		return behave;
	}

	public void Destroy(CEBehave behave)
	{
		listTrash.add(behave);
	}
}

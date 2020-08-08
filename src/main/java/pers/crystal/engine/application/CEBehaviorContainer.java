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
	public synchronized void Start()
	{
		state = CEBehaviorContainer.START;
		for (CEBehave behave : list)
		{
			behave.Start();
		}
	}

	@Override
	public synchronized void Update()
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
	public synchronized void Destroy()
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

	public synchronized CEBehave Add(CEBehave behave)
	{
		if (state == CEBehaviorContainer.START ||
			state == CEBehaviorContainer.UPDATE)
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

	public synchronized void New(CEBehave behave)
	{
		listNew.add(behave);
	}

	public synchronized CEBehave Remove(CEBehave behave)
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

	public synchronized void Destroy(CEBehave behave)
	{
		listTrash.add(behave);
	}
}

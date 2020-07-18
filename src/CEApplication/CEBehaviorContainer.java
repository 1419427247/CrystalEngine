package CEApplication;
import java.util.*;
import CEUtility.*;

public class CEBehaviorContainer extends CEBehave
{

	CEBehaviorState state=CEBehaviorState.none;
	ArrayList<CEBehave> list=new ArrayList<CEBehave>();
	
	ArrayList<CEBehave> listTrash=new ArrayList<CEBehave>();
	ArrayList<CEBehave> listNew=new ArrayList<CEBehave>();

	CEEvent<CEBehaviorContainer> event=new CEEvent<CEBehaviorContainer>();

	@Override
	public void Start()
	{
		state = CEBehaviorState.start;
		for (CEBehave behave : list)
		{
			behave.Start();
		}
	}

	@Override
	public void Update()
	{
		state = CEBehaviorState.remove;
		for (int i = listTrash.size() - 1;i >= 0;i--)
		{
			Remove(listTrash.get(i));
		}
		listTrash.clear();
		state = CEBehaviorState.create;
		for (int i = listNew.size() - 1;i >= 0;i--)
		{
			Add(listNew.get(i));
		}
		listNew.clear();
		state = CEBehaviorState.update;
		for (CEBehave behave : list)
		{
			behave.Update();
		}
		state = CEBehaviorState.none;
	}

	@Override
	public void Destroy()
	{
		state = CEBehaviorState.destory;
		for (int i = list.size() - 1;i >= 0;i--)
		{
			Remove(list.get(i));
		}
		state = CEBehaviorState.none;
	}

	public CEBehave Add(CEBehave behave)
	{
		if (state == CEBehaviorState.start ||
			state == CEBehaviorState.update)
		{
			throw new RuntimeException();
		}
		list.add(behave);
		if (state == CEBehaviorState.create)
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
		if (state == CEBehaviorState.start ||
			state == CEBehaviorState.update)
		{
			throw new RuntimeException();
		}
		list.remove(behave);
		if (state == CEBehaviorState.remove ||
			state == CEBehaviorState.destory)
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

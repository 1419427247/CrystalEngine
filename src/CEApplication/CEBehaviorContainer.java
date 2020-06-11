package CEApplication;
import java.util.*;
import CEUtility.*;

public class CEBehaviorContainer implements CEBehave
{
	CEBehaviorState state=CEBehaviorState.none;
	ArrayList<CEBehave> list=new ArrayList<CEBehave>();

	ArrayList<CEBehave> listTrash=new ArrayList<CEBehave>();
	ArrayList<CEBehave> listNew=new ArrayList<CEBehave>();

	CEEvent<CEBehaviorContainer> event=new CEEvent<CEBehaviorContainer>();
	
	@Override
	public void Start()
	{
		state=CEBehaviorState.start;
		for (CEBehave behave : list)
		{
			behave.Start();
		}
	}

	@Override
	public void Update()
	{
		for (int i = listTrash.size() - 1;i >= 0;i--)
		{
			Remove(listTrash.get(i));
		}
		for (int i = listNew.size() - 1;i >= 0;i--)
		{
			Add(listNew.get(i));
		}
		state=CEBehaviorState.update;
		for (CEBehave behave : list)
		{
			behave.Update();
		}
		state=CEBehaviorState.none;
	}

	@Override
	public void Destroy()
	{
		state=CEBehaviorState.destory;
		for (CEBehave behave : list)
		{
			behave.Destroy();
		}
		state=CEBehaviorState.none;
	}
	
	public void Add(CEBehave behave){
		if(state!=CEBehaviorState.none){
			throw new RuntimeException();
		}
		list.add(behave);
	}
	
	public void New(CEBehave behave){
		listNew.add(behave);
	}
	
	public void Remove(CEBehave behave){
		if(state!=CEBehaviorState.none){
			throw new RuntimeException();
		}
		list.remove(behave);
	}
	
	public void Destroy(CEBehave behave){
		listTrash.remove(behave);
	}
}

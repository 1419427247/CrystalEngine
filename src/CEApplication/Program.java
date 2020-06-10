package CEApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import CETool.EventListener;
import java.util.*;

class Print extends Component {
	@Override
	public void Update() {
		System.out.println(gameObject.name + "Update");
	}
	
	@Override
	public void Start() {
		System.out.println(gameObject.name + "Start");
		gameObject.NewComponent(Print.class);
		gameObject.RemoveComponent(Print.class);
	}
	
	@Override
	public void Destroyed() {
		
	}
}

public class Program {
	public static void main(String[] args) {
		GameObject p1 = new GameObject("QWQ");
		p1.AddComponent(Print.class);
		
		GameObject p2 = new GameObject("QAQ");
		p2.SetParent(p1);
		
		Perfab perfab = new Perfab(p1);
		
		World world = new World();
		world.AddListener(new EventListener<World>(){
				@Override
				public void DoEvent(World sender, int type, Object[] args)
				{
					switch(type){
						case World.WorldEvent.OnGameObjectCreated:
							System.out.println(((GameObject)args[0]).GetName() + " Created");
						break;

						case World.WorldEvent.OnGameObjectDestroyed:
							System.out.println(((GameObject)args[0]).GetName() + " Destroyed");
							break;

						case World.WorldEvent.OnComponentCreated:
							System.out.println(((Component)args[0]).toString() + " Created");
							break;
					}
					// TODO: Implement this method
				}
		});
		
		
		world.AddGameObject(perfab.Instantiation());
		world.Update();
		world.Update();
		
		world.Update();
		world.Update();
		world.Update();
		world.Update();
		world.Update();
		}
}

package CEApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import CETool.EventListener;

class Print extends Component {
	@Override
	public void Update() {
		gameObject.world.AddGameObject("A2");
		System.out.println("Update");
	}

	@Override
	public void Start() {
		System.out.println("Start");
		gameObject.world.AddListener(new EventListener<World>() {
			@Override
			public void DoEvent(World sender, int type, Object[] args) {
				switch (type) {
				case World.WorldEvent.OnGameObjectCreated:
					System.out.println("QWQ");
					break;
				case World.WorldEvent.OnGameObjectDestroyed:
					System.out.println("QAQ");
					break;
				default:
					break;
				}
			}
		});
//	
	}

	@Override
	public void Awake() {
		System.out.println("Awake");
	}

	@Override
	public void Destroyed() {
		
	}
}

public class Program {
	public static void main(String[] args) {
		GameObject p1 = new GameObject("CP");
		p1.AddComponent(Print.class);
		
		Perfab perfab = new Perfab(p1);
		
		World world = new World();
		
		world.AddGameObject(perfab);
		
		world.Update();
		world.Update();
	}
}

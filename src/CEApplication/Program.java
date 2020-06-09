package CEApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import CETool.EventListener;

class Print extends Component {
	@Override
	public void Update() {
		System.out.println("Update");
		GameObject A2 = gameObject.world.CreateGameObject("A2");
		gameObject.SetParent(A2);
		gameObject.world.DestroyGameObject("A2");
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
		World world = new World();
		GameObject A1 = world.CreateGameObject("A1");
		A1.CreateComponent(Print.class);
		world.Update();
		world.Update();

	}
}
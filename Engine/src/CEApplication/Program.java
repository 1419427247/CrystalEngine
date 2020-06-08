package CEApplication;

class Print extends Component {
	@Override
	public void Update() {
		System.out.println("Tick");
	}

	@Override
	public void Start() {
		System.out.println("Start");
	}

	@Override
	public void Awake() {
		System.out.println("Awake");
	}
}

public class Program {
	public static void main(String[] args) {
		World world = new World();
		GameObject A1 = world.NewGameObject("A1");
		GameObject B1 = world.NewGameObject("B1");
		GameObject B2 = world.NewGameObject("B2");

		world.Update();
	}
}
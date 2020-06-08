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

	@Override
	public void Destroyed() {
		
	}
}

public class Program {
	public static void main(String[] args) {
		World world = new World();
		GameObject A1 = world.NewGameObject("A1");
		A1.NewComponent(Print.class);
		A1.NewComponent(Print.class);
		world.Update();
	}
}
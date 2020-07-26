package CEApplication;

import CEWindows.CEInput;

public class CEWorld extends CEBehave
{
	public enum CEWorldState{
		none,
		starting,
		running,
		ending,
	}
	public CEGameObjectManager gameObjectManager;

	private CEWorldState state = CEWorldState.none;
	public CEWorld()
	{
		gameObjectManager=new CEGameObjectManager(this);
		state=CEWorldState.starting;
	}
	
	@Override
	public void Start()
	{
		state = CEWorldState.starting;
		gameObjectManager.Start();
		state = CEWorldState.none;
	}

	@Override
	public void Update()
	{
		state = CEWorldState.running;
		gameObjectManager.Update();
		state = CEWorldState.none;
	}
	
	@Override
	public void Destroy()
	{
		state = CEWorldState.ending;
		gameObjectManager.Destroy();
		state = CEWorldState.none;
	}
	

	//	public GameObject CreateGameObject(Perfab name) {
//		if (state == WorldState.really) {
//			
//		}
//	}
//	
//	public GameObject CreateGameObject(String name) {
//		if (state == WorldState.run) {
//			GameObject gameObject = new GameObject(name, this);
//			if (!gameObjects.containsKey(name)) {
//				gameObjects.put(name, gameObject);
//				event.DoEvent(WorldEvent.OnGameObjectCreated,gameObject);
//				return gameObject;
//			}
//			return null;
//		}
//	}
//
//	public GameObject GetGameObject(String name) {
//		return gameObjects.get(name);
//	}
//
//	public void DestroyGameObject(String name) {
//		gameObjectsTrash.add(name);
//	}
//	
//	public void CreateComponent(String name,Class<? extends Component> component) {
//		Component c;
//		try {
//			c = component.getDeclaredConstructor().newInstance();
//			c.gameObject = gameObjects.get(name);
//			if (state == WorldState.run) {
//				c.Start();				
//			}
//			gameObjects.get(name).components.add(c);
//			event.DoEvent(WorldEvent.OnComponentCreated,c);
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public Component GetComponent(String name,Class<? extends Component> clazz) {
//		for (Component component : gameObjects.get(name).components) {
//			if (component.getClass() == clazz) {
//				return component;
//			}
//		}
//		return null;
//	}
//
//	public void DestroyComponent(String name,Class<? extends Component> clazz) {
//		gameObjects.get(name).componentsTrash.add(clazz);
//	}

}

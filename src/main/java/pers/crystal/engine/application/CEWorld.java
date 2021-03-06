package pers.crystal.engine.application;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class CEWorld extends CEBehave
{
	public static final int NONE = 1;
	public static final int STARTING = 2;
	public static final int RUNNING = 3;
	public static final int ENDING = 4;

	public static CEGameObjectManager gameObjectManager;
	public static CEPhysicalManage physicalManage;
	public static CEInputManager inputManager;

	private int state = CEWorld.NONE;
	public CEWorld()
	{
		gameObjectManager=new CEGameObjectManager(this);
		physicalManage = new CEPhysicalManage();
		inputManager = new CEInputManager();
	}
	
	public int getState() {
		return state;
	}

	@Override
	public synchronized void Start()
	{
		state = CEWorld.STARTING;
		inputManager.Start();
		physicalManage.Start();
		gameObjectManager.Start();
		state = CEWorld.NONE;
	}

	@Override
	public synchronized void Update()
	{
		state = CEWorld.RUNNING;
		gameObjectManager.Update();
		physicalManage.Update();
		inputManager.Update();
		state = CEWorld.NONE;
	}

	@Override
	public synchronized void Destroy()
	{
		state = CEWorld.ENDING;
		gameObjectManager.Destroy();
		physicalManage.Destroy();
		inputManager.Destroy();
		state = CEWorld.NONE;
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

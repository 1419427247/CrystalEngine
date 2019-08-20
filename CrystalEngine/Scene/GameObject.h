#ifndef GAMEOBJECT_H
#define GAMEOBJECT_H
#include<list>
#include<vector>
#include<string>
namespace CrystalEngine
{
	class Component;
	class Scene;

	class GameObject
	{
		friend class Scene;
		friend class Component;
	private:
		//物体当前所在的的场景
		Scene* scene;
		//在游戏下一次更新时要新增的组件
		std::vector<Component*>* newComponents;
		//在游戏下一次更新时要移除的组件
		std::vector<std::string>* deleteComponents;
		//游戏物体的唯一名字
		std::string name;
		//游戏物体的组件容器
		std::list<Component*>* components;
		//父物体
		GameObject* parent;
		//子物体
		std::list<GameObject*>* child;
	public:
		

		GameObject(std::string _name);
		~GameObject();

		void start();
		void update();

		std::string getGameObjectName();

		bool setParten(GameObject* _gameObject);
		bool addChild(GameObject* _gameObject);

		bool removeChild(GameObject* _gameObject);
		bool cleanChild();
		

		bool newGameObject(std::string _gameObjectName);
		bool creatGameObject(std::string _gameObjectName);
		GameObject* getGameObject(std::string _gameObjectName);
		void destoryGameObject(std::string _name);

		bool creatComponent(Component* _component);
		bool newComponent(Component* _component);
		Component* getComponent(std::string _name);
		void destoryComponent(std::string _name);
	};
}

#endif
#ifndef GAMEOBJECT_H
#define GAMEOBJECT_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"
#include <list>
#include <vector>
#include <string>

namespace CrystalEngine
{
class Component;
class Scene;
class Transform;
class RigidBody;
class Collision;

class GameObject : public Object
{
	friend class Scene;
	friend class Component;
	friend class RigidBody;
	friend class Collision;

private:
	//物体当前所在的的场景
	Scene *scene;
	//在游戏下一次更新时要新增的组件
	std::vector<Component *> *newComponents;
	//在游戏下一次更新时要移除的组件
	std::vector<std::string> *deleteComponents;
	//游戏物体的唯一名字
	std::string name;
	//游戏物体的组件容器
	std::list<Component *> *components;
	//父物体
	GameObject *parent;
	//子物体
	std::list<GameObject *> *children;

public:
	OBJECT(GameObject)

	Transform *transform;

	GameObject();
	GameObject(std::string _name);
	~GameObject();

	void start();
	void update();
	void destory();

	std::string getName() const;

	bool setParten(GameObject *_gameObject);
	GameObject *getParten() const;

	bool addChild(GameObject *_gameObject);
	const std::list<GameObject *>& getChildren() const;
	int getChildrenCount() const;
	bool removeChild(GameObject *_gameObject);
	void cleanChildren();

	bool creatGameObject(std::string _gameObjectName);
	bool newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	bool destoryGameObject(std::string _name);

	bool creatComponent(Component *_component);
	bool newComponent(Component *_component);
	Component *getComponent(std::string _name) const;
	bool destoryComponent(std::string _name);
};

class TestGameObject : public CrystalEngine::Test
{
public:
	OBJECT(TestGameObject)
	TestGameObject();
	~TestGameObject();
	void run() override;
};

} // namespace CrystalEngine

#endif
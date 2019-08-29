#ifndef SCENE_H
#define SCENE_H

#include "CrystalEngine/Tool/Test.h"
#include <unordered_map>
#include <vector>

namespace CrystalEngine
{
class GameObject;
class Component;
class RigidBody;
class Collision;
class PhysicalManager;
class Scene
{
	friend class TestScene;
	friend class GameObject;
	friend class RigidBody;
	friend class Collision;
private:
	bool isAlive;
	std::vector<std::string> *newGameObjects;
	std::vector<std::string> *deleteGameObjects;

	std::unordered_map<std::string, GameObject *> *gameObjects;
	PhysicalManager* physicalManager; 
	
public:
	Scene(PhysicalManager* _physicalManager);
	~Scene();


	void start();
	bool update();
	void destory();

	bool newGameObject(std::string _gameObjectName);
	bool creatGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	bool destoryGameObject(std::string _name);

	bool newComponent(std::string _gameObjectName, Component *_component);
	bool creatComponent(std::string _gameObjectName, Component *_component);
	Component *getComponent(std::string _gameObjectName, std::string _componentGame) const;
	bool destoryComponent(std::string _gameObjectName, std::string _name);
};


class TestScene : public CrystalEngine::Test
{
public:
	TestScene();
	~TestScene();
	void run() override;
};

} // namespace CrystalEngine
#endif
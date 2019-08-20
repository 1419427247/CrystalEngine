#ifndef SCENE_H
#define SCENE_H

#include <unordered_map>
#include <vector>

namespace CrystalEngine
{
class GameObject;
class Component;

class Scene
{
	friend class GameObject;

private:
	bool isAlive;
	std::vector<std::string> *newGameObjects;
	std::vector<std::string> *deleteGameObjects;
	std::unordered_map<std::string, GameObject *> *gameObjects;

public:
	Scene();
	~Scene();

	void start();
	void finish();

	bool newGameObject(std::string _gameObjectName);
	bool creatGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName);
	void destoryGameObject(std::string _name);

	bool newComponent(std::string _gameObjectName, Component *_component);
	bool creatComponent(std::string _gameObjectName, Component *_component);
	Component *getComponent(std::string _gameObjectName, std::string _componentGame);
	void destoryComponent(std::string _gameObjectName, std::string _name);
};
} // namespace CrystalEngine
#endif
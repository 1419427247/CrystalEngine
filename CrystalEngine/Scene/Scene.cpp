#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Component.h"

namespace CrystalEngine
{
Scene::Scene()
{
	isAlive = false;
	newGameObjects = new std::vector<std::string>();
	deleteGameObjects = new std::vector<std::string>();
	gameObjects = new std::unordered_map<std::string, GameObject *>();
	physicalManager = nullptr;
}
Scene::Scene(PhysicalManager *_physicalManager)
{
	isAlive = false;
	newGameObjects = new std::vector<std::string>();
	deleteGameObjects = new std::vector<std::string>();
	gameObjects = new std::unordered_map<std::string, GameObject *>();
	physicalManager = _physicalManager;
}

Scene::~Scene()
{
	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		delete var.second;
	}
	delete gameObjects;
	delete newGameObjects;
	delete deleteGameObjects;
	if (physicalManager != nullptr)
		delete physicalManager;
}

bool Scene::newGameObject(std::string _gameObjectName)
{
	if (!gameObjects->count(_gameObjectName))
	{
		for (std::string var : *newGameObjects)
		{
			if (var == _gameObjectName)
				return false;
		}
		newGameObjects->push_back(_gameObjectName);
		return true;
	}
	return false;
}

bool Scene::creatGameObject(std::string _gameObjectName)
{
	if (!gameObjects->count(_gameObjectName))
	{
		(*gameObjects)[_gameObjectName] = new GameObject(_gameObjectName);
		(*gameObjects)[_gameObjectName]->scene = this;
		return true;
	}
	return false;
}

GameObject *Scene::getGameObject(std::string _gameObjectName) const
{
	if (gameObjects->count(_gameObjectName))
		return (*gameObjects)[_gameObjectName];
	return nullptr;
}

bool Scene::destoryGameObject(std::string _name)
{
	if (gameObjects->count(_name))
	{
		for (std::string var : *deleteGameObjects)
		{
			if (var == _name)
				return false;
		}
		deleteGameObjects->push_back(_name);
		return true;
	}
	return false;
}

bool Scene::newComponent(std::string _gameObjectName, Component *_component)
{
	if (!gameObjects->count(_gameObjectName))
		return false;
	return (*gameObjects)[_gameObjectName]->newComponent(_component);
}

bool Scene::creatComponent(std::string _gameObjectName, Component *_component)
{
	if (!gameObjects->count(_gameObjectName))
		return false;
	return (*gameObjects)[_gameObjectName]->creatComponent(_component);
}

Component *Scene::getComponent(std::string _gameObjectName, std::string _componentGame) const
{
	if (!gameObjects->count(_gameObjectName))
		return nullptr;
	return (*gameObjects)[_gameObjectName]->getComponent(_componentGame);
}

bool Scene::destoryComponent(std::string _gameObjectName, std::string _name)
{
	if (!gameObjects->count(_gameObjectName))
		return false;
	return (*gameObjects)[_gameObjectName]->destoryComponent(_name);
}

void Scene::run()
{
	isAlive = true;

	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		var.second->start();
	}

	while (isAlive)
	{
		for (std::string var : *deleteGameObjects)
		{
			if (gameObjects->count(var))
			{
				delete (*gameObjects)[var];
				gameObjects->erase(var);
			}
		}
		deleteGameObjects->clear();

		for (std::string var : *newGameObjects)
		{
			if (!gameObjects->count(var))
			{
				(*gameObjects)[var] = new GameObject(var);
				(*gameObjects)[var]->scene = this;
				(*gameObjects)[var]->start();
			}
		}
		newGameObjects->clear();

		for (std::pair<std::string, GameObject *> var : *gameObjects)
		{
			var.second->update();
		}
	}
}
void Scene::finish()
{
	isAlive = false;
}

TestScene::TestScene() : Test("TestScene")
{
}
TestScene::~TestScene()
{
}
void TestScene::run()
{
	Scene *s1 = new Scene();
	Comparison(s1->creatGameObject("g1"), true);
	Comparison(s1->creatGameObject("g2"), true);

	Comparison(s1->creatGameObject("g1"), false);

	Comparison(s1->getGameObject("g1")->getName(),"g1");

	Comparison(s1->creatComponent("g1",nullptr),false);

	Comparison(s1->destoryGameObject("g2"),true);
	Comparison(s1->destoryGameObject("g2"),false);

	Comparison(s1->deleteGameObjects->at(0),"g2");

	delete s1;
}

} // namespace CrystalEngine
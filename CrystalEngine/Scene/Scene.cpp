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
}
Scene::Scene(PhysicalManager* _physicalManager)
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
}

bool Scene::newGameObject(std::string _gameObjectName)
{
	if (!gameObjects->count(_gameObjectName))
	{
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
	}
	return false;
}

GameObject *Scene::getGameObject(std::string _gameObjectName)
{
	if (gameObjects->count(_gameObjectName))
		return (*gameObjects)[_gameObjectName];
	return nullptr;
}

void Scene::destoryGameObject(std::string _name)
{
	deleteGameObjects->push_back(_name);
}

bool Scene::newComponent(std::string _gameObjectName, Component *_component)
{
	if (!gameObjects->count(_gameObjectName))
		return false;
	(*gameObjects)[_gameObjectName]->newComponent(_component);
	return true;
}

bool Scene::creatComponent(std::string _gameObjectName, Component *_component)
{
	if (!gameObjects->count(_gameObjectName))
		return false;
	(*gameObjects)[_gameObjectName]->creatComponent(_component);
	return true;
}

Component *Scene::getComponent(std::string _gameObjectName, std::string _componentGame)
{
	if (!gameObjects->count(_gameObjectName))
		return nullptr;
	return (*gameObjects)[_gameObjectName]->getComponent(_componentGame);
}

void Scene::destoryComponent(std::string _gameObjectName, std::string _name)
{
	if (!gameObjects->count(_gameObjectName))
		return;
	(*gameObjects)[_gameObjectName]->destoryComponent(_name);
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
} // namespace CrystalEngine
/**
 * @file Scene.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */



#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Component.h"

#include "CrystalEngine/Scene/Physical.h"

#include "CrystalEngine/Tool/Timer.h"
namespace CrystalEngine
{
Scene::Scene()
{
	isAlive = false;
	newGameObjects = new std::vector<std::string>();
	deleteGameObjects = new std::vector<std::string>();
	gameObjects = new std::unordered_map<std::string, GameObject *>();
	physical = new Physical();
	physical->scene = this;
}

Scene::Scene(Physical *_physical)
{
	isAlive = false;
	newGameObjects = new std::vector<std::string>();
	deleteGameObjects = new std::vector<std::string>();
	gameObjects = new std::unordered_map<std::string, GameObject *>();
	physical = _physical;
	physical->scene = this;
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
	delete physical;
}

void Scene::start()
{
	isAlive = true;

	physical->start();

	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		var.second->start();
	}
}
bool Scene::update()
{
	for (std::string var : *deleteGameObjects)
	{
		if (gameObjects->count(var))
		{
			(*gameObjects)[var]->destory();
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

	physical->update();
	return isAlive;
}
void Scene::destory()
{
	physical->destory();
}

bool Scene::newGameObject(std::string _gameObjectName)
{
	try
	{
		if (gameObjects->count(_gameObjectName))
		{
			throw std::runtime_error("Object name already exists");
		}
		for (std::string var : *newGameObjects)
		{
			if (var == _gameObjectName)
				throw std::runtime_error("Object name already exists");
		}
	}
	catch (const std::runtime_error &e)
	{
		return false;
		std::cerr << e.what() << std::endl;
	}
	newGameObjects->push_back(_gameObjectName);
	return true;
}

bool Scene::creatGameObject(std::string _gameObjectName)
{
	try
	{
		if (gameObjects->count(_gameObjectName))
		{
			throw std::runtime_error("Object name already exists");
		}
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}

	(*gameObjects)[_gameObjectName] = new GameObject(_gameObjectName);
	(*gameObjects)[_gameObjectName]->scene = this;
	return true;
}

GameObject *Scene::getGameObject(std::string _gameObjectName) const
{
	try
	{
		if (!gameObjects->count(_gameObjectName))
		{
			throw std::runtime_error("Object not found");
		}
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return nullptr;
	}

	return (*gameObjects)[_gameObjectName];
}

bool Scene::destoryGameObject(std::string _name)
{
	try
	{
		if (!gameObjects->count(_name))
		{
			throw std::runtime_error("Object not found");
		}
		for (std::string var : *deleteGameObjects)
		{
			if (var == _name)
				throw std::runtime_error("Object not found");
		}
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	deleteGameObjects->push_back(_name);
	return true;
}

bool Scene::newComponent(std::string _gameObjectName, Component *_component)
{
	try
	{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object not found");
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	return (*gameObjects)[_gameObjectName]->newComponent(_component);
}

bool Scene::creatComponent(std::string _gameObjectName, Component *_component)
{
	try
	{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object not found");
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	return (*gameObjects)[_gameObjectName]->creatComponent(_component);
}

Component *Scene::getComponent(std::string _gameObjectName, std::string _componentGame) const
{
	try
	{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object not found");
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return nullptr;
	}
	return (*gameObjects)[_gameObjectName]->getComponent(_componentGame);
}

bool Scene::destoryComponent(std::string _gameObjectName, std::string _name)
{
	try
	{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object not found");
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	return (*gameObjects)[_gameObjectName]->destoryComponent(_name);
}

TestScene::TestScene()
{
}
TestScene::~TestScene()
{
}
void TestScene::run()
{
	// Scene *s1 = new Scene();
	// Comparison(s1->creatGameObject("g1"), true);
	// Comparison(s1->creatGameObject("g2"), true);

	// Comparison(s1->creatGameObject("g1"), false);

	// Comparison(s1->getGameObject("g1")->getName(), "g1");

	// Comparison(s1->creatComponent("g1", nullptr), false);

	// Comparison(s1->destoryGameObject("g2"), true);
	// Comparison(s1->destoryGameObject("g2"), false);

	// Comparison(s1->deleteGameObjects->at(0), "g2");

	// delete s1;
}

} // namespace CrystalEngine
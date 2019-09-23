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

Scene::Scene(Physical *_physical):Scene()
{
	delete physical;
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
		try{
			var.second->start();
		}
		catch(const std::exception& e)
		{
			std::cerr << e.what() << '\n';
		}

	}
}
bool Scene::update()
{
	for (std::string var : *deleteGameObjects)
	{
		if (gameObjects->count(var))
		{
			try
			{
				(*gameObjects)[var]->destory();
			}
			catch(const std::exception& e)
			{
				std::cerr << e.what() << '\n';
			}
			
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
			try
			{
				(*gameObjects)[var]->start();
			}
			catch(const std::exception& e)
			{
				std::cerr << e.what() << '\n';
			}
		}
	}
	newGameObjects->clear();

	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		try{
			var.second->update();
		}
		catch(const std::exception& e)
		{
			std::cerr << e.what() << '\n';
		}
	}

	physical->update();
	return isAlive;
}
void Scene::destory()
{
	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		
		try{
			var.second->destory();
		}
		catch(const std::exception& e)
		{
			std::cerr << e.what() << '\n';
		}
	}
	physical->destory();
}

void Scene::newGameObject(std::string _gameObjectName)
{
	if (gameObjects->count(_gameObjectName))
	{
		throw std::runtime_error("Object name : \""+ _gameObjectName +"\" already exists");
	}
	for (std::string var : *newGameObjects)
	{
		if (var == _gameObjectName)
			throw std::runtime_error("Object name : \""+ _gameObjectName +"\" already exists");
	}
	newGameObjects->push_back(_gameObjectName);
}

void Scene::creatGameObject(std::string _gameObjectName)
{
		if (gameObjects->count(_gameObjectName))
		{
			throw std::runtime_error("Object name : \""+ _gameObjectName +"\" already exists");
		}

	(*gameObjects)[_gameObjectName] = new GameObject(_gameObjectName);
	(*gameObjects)[_gameObjectName]->scene = this;
}

GameObject *Scene::getGameObject(std::string _gameObjectName) const
{
	if (!gameObjects->count(_gameObjectName))
		throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
	return (*gameObjects)[_gameObjectName];
}

void Scene::destoryGameObject(std::string _gameObjectName)
{
		if (!gameObjects->count(_gameObjectName))
		{
			throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
		}
		for (std::string var : *deleteGameObjects)
		{
			if (var == _gameObjectName)
				throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
		}
	deleteGameObjects->push_back(_gameObjectName);
}

void Scene::newComponent(std::string _gameObjectName, Component *_component)
{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
	return (*gameObjects)[_gameObjectName]->newComponent(_component);
}

void Scene::creatComponent(std::string _gameObjectName, Component *_component)
{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
	return (*gameObjects)[_gameObjectName]->creatComponent(_component);
}

Component *Scene::getComponent(std::string _gameObjectName, std::string _componentGame) const
{
		if (!gameObjects->count(_gameObjectName))
			throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
	return (*gameObjects)[_gameObjectName]->getComponent(_componentGame);
}

void Scene::destoryComponent(std::string _gameObjectName, std::string _componentName)
{
	if (!gameObjects->count(_gameObjectName))
		throw std::runtime_error("Object : \""+ _gameObjectName + "\" not found");
	(*gameObjects)[_gameObjectName]->destoryComponent(_componentName);
}

void Scene::finish(){
	isAlive = false;
}

TestScene::TestScene()
{
}
TestScene::~TestScene()
{
}
void TestScene::run()
{
	Scene *s1 = new Scene();

	s1->creatGameObject("g1");
	s1->creatGameObject("g2");

	Comparison(s1->getGameObject("g1")->getName(), "g1");
	Comparison(s1->getGameObject("g2")->getName(), "g2");
	
	s1->getGameObject("g2")->setParten(s1->getGameObject("g1"));

	Comparison(s1->getGameObject("g1")->getChildrenCount(),1);
	Comparison(s1->getGameObject("g2")->getParten()->getName(),"g1");

	s1->getGameObject("g1")->cleanChildren();

	Comparison(s1->getGameObject("g2")->getParten(),nullptr);

	delete s1;
}

} // namespace CrystalEngine
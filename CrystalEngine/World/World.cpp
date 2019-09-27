/**
 * @file World.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */



#include "CrystalEngine/World/World.h"

#include "CrystalEngine/GameObject/GameObject.h"

#include "CrystalEngine/Component/Component.h"

#include "CrystalEngine/Tool/Timer.h"
namespace CrystalEngine
{
World::World()
{
	gameObjects = new std::unordered_map<std::string, GameObject *>();
}


World::~World()
{
	for (std::pair<std::string, GameObject *> var : *gameObjects)
	{
		delete var.second;
	}
	delete gameObjects;
}

void World::start()
{
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
void World::update()
{
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
}
void World::destory()
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
}

} // namespace CrystalEngine
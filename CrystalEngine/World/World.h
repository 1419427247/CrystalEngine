/**
 * @file World.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef WORLD_H
#define WORLD_H

#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{

class GameObject;

class World : public Runnable
{
private:
	std::unordered_map<std::string, GameObject *> *gameObjects;
	
public:
	OBJECT(World)

	World();
	~World();

	void start();

	void update();

	void destory();

};

} // namespace CrystalEngine
#endif
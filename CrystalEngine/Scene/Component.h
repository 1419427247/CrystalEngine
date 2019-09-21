/**
 * @file Component.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef COMPONENT_H
#define COMPONENT_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
class GameObject;
class RigidBody;
class Component : public Object
{
	friend class GameObject;
	friend class RigidBody;
public:
	OBJECT(Component)

	GameObject *gameObject;

	Component();
	
	virtual ~Component();

	virtual void start();
	virtual void update();
	virtual void destory();

	bool newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	bool destoryGameObject(std::string _name);

	bool newComponent(Component *_component);
	Component *getComponent(std::string _name) const;
	bool destoryComponent(std::string _name);
};
} // namespace CrystalEngine
#endif
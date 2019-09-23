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
	
	Component(GameObject* _gameObject);

	virtual ~Component();

	virtual void start();
	virtual void update();
	virtual void destory();

	GameObject& getGameObject();

	void newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	void destoryGameObject(std::string _name);

	void newComponent(Component *_component);
	Component *getComponent(std::string _name) const;
	void destoryComponent(std::string _name);
};
} // namespace CrystalEngine
#endif
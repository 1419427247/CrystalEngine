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

namespace CrystalEngine
{
class GameObject;

class Component : public Object
{
public:
	OBJECT(Component)

	GameObject *gameObject;
	
	Component(GameObject* _gameObject);

	virtual ~Component();

	virtual void start();
	virtual void update();
	virtual void destory();

	GameObject& getGameObject();

};
} // namespace CrystalEngine
#endif
/**
 * @file Component.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"

namespace CrystalEngine
{
Component::Component()
{
	gameObject = nullptr;
}

Component::Component(GameObject* _gameObject)
{
	gameObject = _gameObject;
}

Component::~Component()
{
}

void Component::start()
{
}

void Component::update()
{
}

void Component::destory()
{
}

GameObject& Component::getGameObject(){
	return *(gameObject);
}

void Component::newGameObject(std::string _gameObjectName)
{
	 gameObject->newGameObject(_gameObjectName);
}

GameObject *Component::getGameObject(std::string _gameObjectName) const
{
	return gameObject->getGameObject(_gameObjectName);
}

void Component::destoryGameObject(std::string _name)
{
	 gameObject->destoryGameObject(_name);
}

void Component::newComponent(Component *_component)
{
	 gameObject->newComponent(_component);
}

Component *Component::getComponent(std::string _name) const
{
	return gameObject->getComponent(_name);
}

void Component::destoryComponent(std::string _name)
{
	 gameObject->destoryComponent(_name);
}

} // namespace CrystalEngine
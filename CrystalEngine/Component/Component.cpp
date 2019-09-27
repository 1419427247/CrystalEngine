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

#include "CrystalEngine/Component/Component.h"

#include "CrystalEngine/GameObject/GameObject.h"

#include "CrystalEngine/World/World.h"

namespace CrystalEngine
{
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

} // namespace CrystalEngine
/**
 * @file RigidBody.cpp
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

#include "CrystalEngine/Component/RigidBody.h"

#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{

RigidBody::RigidBody(GameObject* _gameObject):Component(_gameObject)
{
}
RigidBody::~RigidBody()
{
}

} // namespace CrystalEngine
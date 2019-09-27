/**
 * @file Collision.cpp
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

#include "CrystalEngine/Component/Collision.h"


namespace CrystalEngine
{
Collision::Collision(GameObject* _gameObject):Component(_gameObject)
{
}
Collision::~Collision()
{
}

void Collision::start()
{
    //Physical::__physical.newCollision(this);
}
void Collision::update()
{
}
void Collision::destory()
{
    //Physical::__physical.destoryCollision(this);
}

} // namespace CrystalEngine
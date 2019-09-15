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
#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Physical.h"

#include "CrystalEngine/Component/Collision.h"
namespace CrystalEngine
{
Collision::Collision()
{
}
Collision::~Collision()
{
}

void Collision::start()
{
    if (gameObject->scene->physical)
        gameObject->scene->physical->newCollision(this);
}
void Collision::update()
{
}
void Collision::destory()
{
    if (gameObject->scene->physical)
        gameObject->scene->physical->destoryCollision(this);
}

} // namespace CrystalEngine
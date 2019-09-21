/**
 * @file Physical.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#include "CrystalEngine/Tool/Vector.h"

#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Transform.h"

#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Physical.h"

namespace CrystalEngine
{
Physical::Physical()
{
}
Physical::~Physical()
{
}

void Physical::newRigidBody(RigidBody *_rigidBody)
{
}
void Physical::destoryRigidBody(RigidBody *_rigidBody)
{
}

const Vector &Physical::getPosition(RigidBody *_rigidBody)
{
    return _rigidBody->gameObject->transform->getPosition();
}
const Vector &Physical::getRotate(RigidBody *_rigidBody)
{
    return _rigidBody->gameObject->transform->getRotate();
}
Vector Physical::getLinearVelocity(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double Physical::getAngularVelocity(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double Physical::getLinearDamping(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double Physical::getAngularDamping(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double Physical::getGravityScale(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool Physical::isSleepingAllowed(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool Physical::isAwake(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool Physical::isFixedRotation(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool Physical::isBullet(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
BodyType Physical::getType(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool Physical::isActive(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}

void Physical::setTransform(RigidBody *_rigidBody, const Vector &_vector, const Vector &_angle)
{
}
void Physical::setLinearVelocity(RigidBody *_rigidBody, const Vector &_linearVelocity)
{
}
void Physical::setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity)
{
}
void Physical::setLinearDamping(RigidBody *_rigidBody, double _linearDamping)
{
}
void Physical::setAngularDamping(RigidBody *_rigidBody, double _angularDamping)
{
}
void Physical::setGravityScale(RigidBody *_rigidBody, double _gravityScale)
{
}
void Physical::setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep)
{
}
void Physical::setAwake(RigidBody *_rigidBody, bool _awake)
{
}
void Physical::setFixedRotation(RigidBody *_rigidBody, float _fixedRotation)
{
}
void Physical::setBullet(RigidBody *_rigidBody, bool _bullet)
{
}
void Physical::setType(RigidBody *_rigidBody, BodyType _bodyType)
{
}
void Physical::setActive(RigidBody *_rigidBody, bool _active)
{
}

void Physical::newCollision(Collision *_collision)
{
}
void Physical::destoryCollision(Collision *_collision)
{
}

void Physical::start() {}

void Physical::update() {}

void Physical::destory() {}
} // namespace CrystalEngine
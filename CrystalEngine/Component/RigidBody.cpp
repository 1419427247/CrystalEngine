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

#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Physical.h"

#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{
RigidBody::RigidBody()
{
}
RigidBody::~RigidBody()
{
}

const Vector& RigidBody::getPosition()
{
    return gameObject->scene->physical->getPosition(this);
}
const Vector& RigidBody::getRotate()
{
    return gameObject->scene->physical->getRotate(this);
}

Vector RigidBody::getLinearVelocity()
{
    return gameObject->scene->physical->getLinearVelocity(this);
}
double RigidBody::getAngularVelocity()
{
    return gameObject->scene->physical->getAngularVelocity(this);
}

double RigidBody::getLinearDamping()
{
    return gameObject->scene->physical->getLinearDamping(this);
}
double RigidBody::getAngularDamping()
{
    return gameObject->scene->physical->getAngularDamping(this);
}
double RigidBody::getGravityScale()
{
    return gameObject->scene->physical->getGravityScale(this);
}

bool RigidBody::isSleepingAllowed()
{
    return gameObject->scene->physical->isSleepingAllowed(this);
}
bool RigidBody::isAwake()
{
    return gameObject->scene->physical->isAwake(this);
}
bool RigidBody::isFixedRotation()
{
    return gameObject->scene->physical->isFixedRotation(this);
}
bool RigidBody::isBullet()
{
    return gameObject->scene->physical->isBullet(this);
}
BodyType RigidBody::getType()
{
    return gameObject->scene->physical->getType(this);
}
bool RigidBody::isActive()
{
    return gameObject->scene->physical->isActive(this);
}

void RigidBody::setTransform(const Vector&  _vector, const Vector&  _angle)
{
    gameObject->scene->physical->setTransform(this, _vector, _angle);
}

void RigidBody::setLinearVelocity(const Vector&  _linearVelocity)
{
    gameObject->scene->physical->setLinearVelocity(this, _linearVelocity);
}
void RigidBody::setAngularVelocity(double _angularVelocity)
{
    gameObject->scene->physical->setAngularVelocity(this, _angularVelocity);
}

void RigidBody::setLinearDamping(double _linearDamping)
{
    gameObject->scene->physical->setLinearDamping(this, _linearDamping);
}
void RigidBody::setAngularDamping(double _angularDamping)
{
    gameObject->scene->physical->setAngularDamping(this, _angularDamping);
}
void RigidBody::setGravityScale(double _gravityScale)
{
    gameObject->scene->physical->setGravityScale(this, _gravityScale);
}

void RigidBody::setSleepingAllowed(bool _allowSleep)
{
    gameObject->scene->physical->setSleepingAllowed(this, _allowSleep);
}
void RigidBody::setAwake(bool _awake)
{
    gameObject->scene->physical->setAwake(this, _awake);
}
void RigidBody::setFixedRotation(float _fixedRotation)
{
    gameObject->scene->physical->setFixedRotation(this, _fixedRotation);
}
void RigidBody::setBullet(bool _bullet)
{
    gameObject->scene->physical->setBullet(this, _bullet);
}
void RigidBody::setType(BodyType _bodyType)
{
    gameObject->scene->physical->setType(this, _bodyType);
}
void RigidBody::setActive(bool _active)
{
    gameObject->scene->physical->setActive(this, _active);
}

void RigidBody::start()
{
    gameObject->scene->physical->newRigidBody(this);
}
void RigidBody::update()
{
}
void RigidBody::destory()
{
    gameObject->scene->physical->destoryRigidBody(this);
}
} // namespace CrystalEngine
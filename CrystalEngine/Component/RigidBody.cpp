#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{
RigidBody::RigidBody() : Component("RigidBody")
{
}
RigidBody::~RigidBody()
{
}

Vector RigidBody::getPosition()
{
    return gameObject->scene->physicalManager->getPosition(this);
}
double RigidBody::getRotate()
{
    return gameObject->scene->physicalManager->getRotate(this);
}

Vector RigidBody::getLinearVelocity()
{
    return gameObject->scene->physicalManager->getLinearVelocity(this);
}
double RigidBody::getAngularVelocity()
{
    return gameObject->scene->physicalManager->getAngularVelocity(this);
}

double RigidBody::getLinearDamping()
{
    return gameObject->scene->physicalManager->getLinearDamping(this);
}
double RigidBody::getAngularDamping()
{
    return gameObject->scene->physicalManager->getAngularDamping(this);
}
double RigidBody::getGravityScale()
{
    return gameObject->scene->physicalManager->getGravityScale(this);
}

bool RigidBody::isSleepingAllowed()
{
    return gameObject->scene->physicalManager->isSleepingAllowed(this);
}
bool RigidBody::isAwake()
{
    return gameObject->scene->physicalManager->isAwake(this);
}
bool RigidBody::isFixedRotation()
{
    return gameObject->scene->physicalManager->isFixedRotation(this);
}
bool RigidBody::isBullet()
{
    return gameObject->scene->physicalManager->isBullet(this);
}
BodyType RigidBody::getType()
{
    return gameObject->scene->physicalManager->getType(this);
}
bool RigidBody::isActive()
{
    return gameObject->scene->physicalManager->isActive(this);
}

void RigidBody::setTransform(Vector _vector, double _angle)
{
    gameObject->scene->physicalManager->setTransform(this, _vector, _angle);
}

void RigidBody::setLinearVelocity(Vector _linearVelocity)
{
    gameObject->scene->physicalManager->setLinearVelocity(this, _linearVelocity);
}
void RigidBody::setAngularVelocity(double _angularVelocity)
{
    gameObject->scene->physicalManager->setAngularVelocity(this, _angularVelocity);
}

void RigidBody::setLinearDamping(double _linearDamping)
{
    gameObject->scene->physicalManager->setLinearDamping(this, _linearDamping);
}
void RigidBody::setAngularDamping(double _angularDamping)
{
    gameObject->scene->physicalManager->setAngularDamping(this, _angularDamping);
}
void RigidBody::setGravityScale(double _gravityScale)
{
    gameObject->scene->physicalManager->setGravityScale(this, _gravityScale);
}

void RigidBody::setSleepingAllowed(bool _allowSleep)
{
    gameObject->scene->physicalManager->setSleepingAllowed(this, _allowSleep);
}
void RigidBody::setAwake(bool _awake)
{
    gameObject->scene->physicalManager->setAwake(this, _awake);
}
void RigidBody::setFixedRotation(float _fixedRotation)
{
    gameObject->scene->physicalManager->setFixedRotation(this, _fixedRotation);
}
void RigidBody::setBullet(bool _bullet)
{
    gameObject->scene->physicalManager->setBullet(this, _bullet);
}
void RigidBody::setType(BodyType _bodyType)
{
    gameObject->scene->physicalManager->setType(this, _bodyType);
}
void RigidBody::setActive(bool _active)
{
    gameObject->scene->physicalManager->setActive(this, _active);
}

void RigidBody::start()
{
    gameObject->scene->physicalManager->newRigidBody(this);
}
void RigidBody::update()
{
}
void RigidBody::destory()
{
    gameObject->scene->physicalManager->destoryRigidBody(this);
}
} // namespace CrystalEngine
#include<stdexcept>

#include "CrystalEngine/Tool/Vector.h"

#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Transform.h"

#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

namespace CrystalEngine
{
PhysicalManager::PhysicalManager()
{
}
PhysicalManager::~PhysicalManager()
{
}

void PhysicalManager::newRigidBody(RigidBody *_rigidBody) {

}
void PhysicalManager::destoryRigidBody(RigidBody *_rigidBody) {
    
}

Vector PhysicalManager::getPosition(RigidBody *_rigidBody)
{
    return *_rigidBody->gameObject->transform->position;
}
double PhysicalManager::getRotate(RigidBody *_rigidBody)
{
    return _rigidBody->gameObject->transform->rotate;
}
Vector PhysicalManager::getLinearVelocity(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double PhysicalManager::getAngularVelocity(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double PhysicalManager::getLinearDamping(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double PhysicalManager::getAngularDamping(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
double PhysicalManager::getGravityScale(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool PhysicalManager::isSleepingAllowed(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool PhysicalManager::isAwake(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool PhysicalManager::isFixedRotation(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool PhysicalManager::isBullet(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
BodyType PhysicalManager::getType(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}
bool PhysicalManager::isActive(RigidBody *_rigidBody)
{
    throw std::runtime_error("Unimplemented method");
}

void PhysicalManager::setTransform(RigidBody *_rigidBody, Vector _vector, double _angle) {

}
void PhysicalManager::setLinearVelocity(RigidBody *_rigidBody, Vector _linearVelocity) {

}
void PhysicalManager::setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity) {

}
void PhysicalManager::setLinearDamping(RigidBody *_rigidBody, double _linearDamping) {

}
void PhysicalManager::setAngularDamping(RigidBody *_rigidBody, double _angularDamping) {

}
void PhysicalManager::setGravityScale(RigidBody *_rigidBody, double _gravityScale) {

}
void PhysicalManager::setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep) {

}
void PhysicalManager::setAwake(RigidBody *_rigidBody, bool _awake) {

}
void PhysicalManager::setFixedRotation(RigidBody *_rigidBody, float _fixedRotation) {

}
void PhysicalManager::setBullet(RigidBody *_rigidBody, bool _bullet) {

}
void PhysicalManager::setType(RigidBody *_rigidBody, BodyType _bodyType) {

}
void PhysicalManager::setActive(RigidBody *_rigidBody, bool _active) {
    
}

void PhysicalManager::newCollision(Collision *_collision) {

}
void PhysicalManager::destoryCollision(Collision *_collision) {

}

void PhysicalManager::start() {}

void PhysicalManager::update() {}

void PhysicalManager::destory() {}
} // namespace CrystalEngine
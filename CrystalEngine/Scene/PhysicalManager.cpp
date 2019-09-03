#include "CrystalEngine/Tool/Vector.h"
#include "CrystalEngine/Component/RigidBody.h"
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

void PhysicalManager::newRigidBody(RigidBody *_rigidBody) {}
void PhysicalManager::destoryRigidBody(RigidBody *_rigidBody) {}

Vector PhysicalManager::getPosition(RigidBody *_rigidBody) {}
double PhysicalManager::getRotate(RigidBody *_rigidBody) {}
Vector PhysicalManager::getLinearVelocity(RigidBody *_rigidBody) {}
double PhysicalManager::getAngularVelocity(RigidBody *_rigidBody) {}
double PhysicalManager::getLinearDamping(RigidBody *_rigidBody) {}
double PhysicalManager::getAngularDamping(RigidBody *_rigidBody) {}
double PhysicalManager::getGravityScale(RigidBody *_rigidBody) {}
bool PhysicalManager::isSleepingAllowed(RigidBody *_rigidBody) {}
bool PhysicalManager::isAwake(RigidBody *_rigidBody) {}
bool PhysicalManager::isFixedRotation(RigidBody *_rigidBody) {}
bool PhysicalManager::isBullet(RigidBody *_rigidBody) {}
BodyType PhysicalManager::getType(RigidBody *_rigidBody) {}
bool PhysicalManager::isActive(RigidBody *_rigidBody) {}

void PhysicalManager::setTransform(RigidBody *_rigidBody, Vector _vector, double _angle) {}
void PhysicalManager::setLinearVelocity(RigidBody *_rigidBody, Vector _linearVelocity) {}
void PhysicalManager::setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity) {}
void PhysicalManager::setLinearDamping(RigidBody *_rigidBody, double _linearDamping) {}
void PhysicalManager::setAngularDamping(RigidBody *_rigidBody, double _angularDamping) {}
void PhysicalManager::setGravityScale(RigidBody *_rigidBody, double _gravityScale) {}
void PhysicalManager::setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep) {}
void PhysicalManager::setAwake(RigidBody *_rigidBody, bool _awake) {}
void PhysicalManager::setFixedRotation(RigidBody *_rigidBody, float _fixedRotation) {}
void PhysicalManager::setBullet(RigidBody *_rigidBody, bool _bullet) {}
void PhysicalManager::setType(RigidBody *_rigidBody, BodyType _bodyType) {}
void PhysicalManager::setActive(RigidBody *_rigidBody, bool _active) {}

void PhysicalManager::newCollision(Collision *_collision) {}
void PhysicalManager::destoryCollision(Collision *_collision) {}

void PhysicalManager::start() {}

void PhysicalManager::update() {}

void PhysicalManager::destory() {}
} // namespace CrystalEngine
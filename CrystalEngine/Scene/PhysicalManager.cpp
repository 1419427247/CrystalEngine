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

void PhysicalManager::newRigidBody(RigidBody *_rigidBody)
{
}
void PhysicalManager::destoryRigidBody(RigidBody *_rigidBody)
{
}

void PhysicalManager::newCollision(Collision *_collision)
{
}
void PhysicalManager::destoryCollision(Collision *_collision)
{
}

void PhysicalManager::start()
{
}

void PhysicalManager::update()
{
}

void PhysicalManager::destory()
{
}

} // namespace CrystalEngine
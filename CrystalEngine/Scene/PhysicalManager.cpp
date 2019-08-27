#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

namespace CrystalEngine
{
PhysicalManager::PhysicalManager(Scene *_scene)
{
    scene = _scene;
}
PhysicalManager::~PhysicalManager()
{
}
void PhysicalManager::run()
{
}
void PhysicalManager::finish()
{
}

void PhysicalManager::newRigidBody(GameObject *_gameObject)
{
}
void PhysicalManager::destoryRigidBody(GameObject *_gameObject)
{
}

void PhysicalManager::newCollision(GameObject *_gameObject)
{
}
void PhysicalManager::destoryCollision(GameObject *_gameObject)
{
}

} // namespace CrystalEngine
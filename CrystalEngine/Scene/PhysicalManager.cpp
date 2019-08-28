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

} // namespace CrystalEngine
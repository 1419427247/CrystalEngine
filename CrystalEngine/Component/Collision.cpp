#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

#include "CrystalEngine/Component/Collision.h"
namespace CrystalEngine
{
Collision::Collision() : Component("Collision")
{
}
Collision::~Collision()
{
}

void Collision::start()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->newRigidBody(this);
}
void Collision::update()
{
}
void Collision::destory()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->destoryRigidBody(this);
}

} // namespace CrystalEngine
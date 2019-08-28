#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"
#include "CrystalEngine/Component/RigidBody.h"

namespace CrystalEngine
{
RigidBody::RigidBody() : Component("RigidBody")
{
}
RigidBody::~RigidBody()
{
}
void RigidBody::start()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->newRigidBody(this);
}
void RigidBody::update()
{
}
void RigidBody::destory()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->destoryRigidBody(this);
}
} // namespace CrystalEngine
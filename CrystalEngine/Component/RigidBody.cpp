#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"
#include "CrystalEngine/Component/RigidBody.h"

namespace CrystalEngine
{
RigidBody::RigidBody() : Component("RigidBody")
{
    linearVelocity = new Vector();
    angularVelocity = new Vector(0,1);
    linearDamping = 0.0f;
    angularDamping = 0.0f;
    allowSleep = true;
    awake = true;
    fixedRotation = false;
    bullet = false;
    type = BodyType::dynamicBody;
    active = true;
    gravityScale = 1.0f;
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
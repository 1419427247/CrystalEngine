#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

#include "CrystalEngine/Component/Collision.h"
namespace CrystalEngine
{
Collision::Collision()
{
}
Collision::~Collision()
{
}

void Collision::start()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->newCollision(this);
}
void Collision::update()
{
}
void Collision::destory()
{
    if (gameObject->scene->physicalManager)
        gameObject->scene->physicalManager->destoryCollision(this);
}

} // namespace CrystalEngine
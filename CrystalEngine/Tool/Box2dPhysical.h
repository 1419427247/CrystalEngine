#ifndef BOX2DPHYSICAL_H
#define BOX2DPHYSICAL_H
#include "CrystalEngine/Scene/PhysicalManager.h"

class b2World;
namespace CrystalEngine
{
class GameObject;
class Vector;
class RigidBody;
class Collision;
class Box2dPhysical : public PhysicalManager
{
    b2World* world;
    Vector* gravity;
public:
    Box2dPhysical();
    ~Box2dPhysical();
    void newRigidBody(RigidBody *_rigidBody);
    void destoryRigidBody(RigidBody *_rigidBody);

    void newCollision(Collision *_collision);
    void destoryCollision(Collision *_collision);

    

    void start();

    void update();

    void destory();
};
} // namespace CrystalEngine

#endif
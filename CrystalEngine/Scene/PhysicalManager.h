#ifndef PHYSICALMANAGER_H
#define PHYSICALMANAGER_H

namespace CrystalEngine
{
class Scene;
class RigidBody;
class Collision;

class PhysicalManager
{
    friend class Scene;
protected:
    Scene* scene;
public:
    PhysicalManager();
    virtual ~PhysicalManager();

    virtual void newRigidBody(RigidBody* _rigidBody);
    virtual void destoryRigidBody(RigidBody* _rigidBody);

    virtual void newCollision(Collision* _collision);
    virtual void destoryCollision(Collision* _collision);

    virtual void start();

    virtual void update();

    virtual void destory();
    
};
} // namespace CrystalEngine
#endif
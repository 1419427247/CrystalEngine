#ifndef PHYSICALMANAGER_H
#define PHYSICALMANAGER_H

namespace CrystalEngine
{
class Scene;
class GameObjct;
class PhysicalManager
{
    Scene* scene;
public:
    PhysicalManager(Scene* _scene);
    virtual ~PhysicalManager();

    virtual void newRigidBody(RigidBody* _rigidBody);
    virtual void destoryRigidBody(RigidBody* _rigidBody);

    virtual void newCollision(Collision* _collision);
    virtual void destoryCollision(Collision* _collision);

    virtual void run();
	virtual void finish();
};
} // namespace CrystalEngine
#endif
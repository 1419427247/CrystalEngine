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

    virtual void newRigidBody(GameObject* _gameObject);
    virtual void destoryRigidBody(GameObject* _gameObject);

    virtual void newCollision(GameObject* _gameObject);
    virtual void destoryCollision(GameObject* _gameObject);

    virtual void run();
	virtual void finish();
};
} // namespace CrystalEngine
#endif
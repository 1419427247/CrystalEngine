#ifndef PHYSICALMANAGER_H
#define PHYSICALMANAGER_H

namespace CrystalEngine
{
class Scene;
class PhysicalManager
{
    Scene* scene;
public:
    PhysicalManager(Scene* _scene);
    virtual ~PhysicalManager();

    virtual void run();
	virtual void finish();
};
} // namespace CrystalEngine
#endif
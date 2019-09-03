#ifndef APPLICATION_H
#define APPLICATION_H

#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Camera.h"
#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Collision.h"

#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Tool/Box2dPhysical.h"
#include "CrystalEngine/Tool/Runnable.h"
#include "CrystalEngine/Tool/Timer.h"
#include "CrystalEngine/Tool/Vector.h"
#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Application : public Object
{
private:
	Scene *scene;
public:
	OBJECT(Application)

	Application();
	Application(Scene *_scene);
	~Application();

	void run();
};
} // namespace CrystalEngine

#endif
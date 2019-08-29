#ifndef APPLICATION_H
#define APPLICATION_H

#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/PhysicalManager.h"

#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Vector.h"
#include "CrystalEngine/Component/Camera.h"
#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Collision.h"

#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Tool/Runnable.h"
#include "CrystalEngine/Tool/Timer.h"

namespace CrystalEngine
{
class Application
{
private:
	Scene *scene;
public:
	Application(Scene *_scene);
	~Application();

	void run();
};
} // namespace CrystalEngine

#endif
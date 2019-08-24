#ifndef APPPLICATION_H
#define APPPLICATION_H

#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/Time.h"

#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Vector.h"
#include "CrystalEngine/Component/Camera.h"

#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
class Application
{
public:
	Application();
	~Application();
};
} // namespace CrystalEngine

#endif
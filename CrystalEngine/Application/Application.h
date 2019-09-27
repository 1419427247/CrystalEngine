/**
 * @file Application.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef APPLICATION_H
#define APPLICATION_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Tool/Runnable.h"
#include "CrystalEngine/Tool/Timer.h"
#include "CrystalEngine/Tool/Vector.h"
#include "CrystalEngine/Tool/Command.h"
#include "CrystalEngine/Tool/Time.h"

#include "CrystalEngine/World/World.h"

#include "CrystalEngine/GameObject/GameObject.h"

#include "CrystalEngine/Component/Component.h"
#include "CrystalEngine/Component/Camera.h"
#include "CrystalEngine/Component/Collision.h"
#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Transform.h"


namespace CrystalEngine
{

class Application : public Object
{
private:

	World* world;
public:
	OBJECT(Application)

	Application();
	Application(World* _world);
	~Application();

	void run(int _millisecond);
};
} // namespace CrystalEngine

#endif
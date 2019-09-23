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

#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"

#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Camera.h"
#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Collision.h"

#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Tool/Box2dPhysical.h"
#include "CrystalEngine/Tool/Runnable.h"
#include "CrystalEngine/Tool/Timer.h"
#include "CrystalEngine/Tool/Vector.h"
/**
 * @brief 
 * 
 */
namespace CrystalEngine
{
/**
 * @brief 
 * 
 */
class Application : public Object
{
private:
/**
 * @brief 
 * 
 */
	Scene* scene;
public:
	OBJECT(Application)
	/**
	 * @brief Construct a new Application object
	 * 
	 */
	Application();
	/**
	 * @brief Construct a new Application object
	 * 
	 * @param _scene 
	 */
	Application(Scene& _scene);
	/**
	 * @brief Destroy the Application object
	 * 
	 */
	~Application();
	/**
	 * @brief 
	 * 
	 */
	void run(int _millisecond);
};
} // namespace CrystalEngine

#endif
/**
 * @file RigidBody.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef RIGIDBODY_H
#define RIGIDBODY_H

#include "CrystalEngine/Component/Component.h"



namespace CrystalEngine
{
class Vector;
class Physical;
/**
 * @brief 
 * 
 */
enum class BodyType
{
	staticBody,
	kinematicBody,
	dynamicBody,
};


class RigidBody : public Component
{
public:

	OBJECT(RigidBody)
	/**
	 * @brief Construct a new Rigid Body object
	 * 
	 */
	RigidBody(GameObject* _gameObject);
	/**
	 * @brief Destroy the Rigid Body object
	 * 
	 */
	~RigidBody();
};

} // namespace CrystalEngine
#endif
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

#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
class Vector;
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
	RigidBody();
	/**
	 * @brief Destroy the Rigid Body object
	 * 
	 */
	~RigidBody();
	/**
	 * @brief Get the Body Data object
	 * 
	 * @return void* 
	 */
	void* getBodyData();
	/**
	 * @brief Get the Position object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getPosition() ;
	/**
	 * @brief Get the Rotate object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getRotate();
	/**
	 * @brief Get the Linear Velocity object
	 * 
	 * @return Vector 
	 */
	Vector getLinearVelocity() ;
	/**
	 * @brief Get the Angular Velocity object
	 * 
	 * @return double 
	 */
	double getAngularVelocity();
	/**
	 * @brief Get the Linear Damping object
	 * 
	 * @return double 
	 */
	double getLinearDamping();
	/**
	 * @brief Get the Angular Damping object
	 * 
	 * @return double 
	 */
	double getAngularDamping();
	/**
	 * @brief Get the Gravity Scale object
	 * 
	 * @return double 
	 */
	double getGravityScale();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool isSleepingAllowed();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool isAwake();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool isFixedRotation();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool isBullet();
	/**
	 * @brief Get the Type object
	 * 
	 * @return BodyType 
	 */
	BodyType getType();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool isActive();
	/**
	 * @brief Set the Body Data object
	 * 
	 * @param _bodyData 
	 */
	void setBodyData(void* _bodyData);
	/**
	 * @brief Set the Transform object
	 * 
	 * @param _vector 
	 * @param _angle 
	 */
    void setTransform(const Vector&  _vector,const Vector&  _angle);
	/**
	 * @brief Set the Linear Velocity object
	 * 
	 * @param _linearVelocity 
	 */
	void setLinearVelocity(const Vector&  _linearVelocity);
	/**
	 * @brief Set the Angular Velocity object
	 * 
	 * @param _angularVelocity 
	 */
	void setAngularVelocity(double _angularVelocity);
	/**
	 * @brief Set the Linear Damping object
	 * 
	 * @param _linearDamping 
	 */
	void setLinearDamping(double _linearDamping);
	/**
	 * @brief Set the Angular Damping object
	 * 
	 * @param _angularDamping 
	 */
	void setAngularDamping(double _angularDamping);
	/**
	 * @brief Set the Gravity Scale object
	 * 
	 * @param _gravityScale 
	 */
	void setGravityScale(double _gravityScale);
	/**
	 * @brief Set the Sleeping Allowed object
	 * 
	 * @param _allowSleep 
	 */
	void setSleepingAllowed(bool _allowSleep);
	/**
	 * @brief Set the Awake object
	 * 
	 * @param _awake 
	 */
	void setAwake(bool _awake);
	/**
	 * @brief Set the Fixed Rotation object
	 * 
	 * @param _fixedRotation 
	 */
	void setFixedRotation(float _fixedRotation);
	/**
	 * @brief Set the Bullet object
	 * 
	 * @param _bullet 
	 */
	void setBullet(bool _bullet);
	/**
	 * @brief Set the Type object
	 * 
	 * @param _bodyType 
	 */
	void setType(BodyType _bodyType);
	/**
	 * @brief Set the Active object
	 * 
	 * @param _active 
	 */
	void setActive(bool _active);
	/**
	 * @brief 
	 * 
	 */
	void start() override;
	/**
	 * @brief 
	 * 
	 */
	void update() override;
	/**
	 * @brief 
	 * 
	 */
	void destory() override;
};
} // namespace CrystalEngine
#endif
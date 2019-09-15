/**
 * @file Physical.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef PHYSICAL_H
#define PHYSICAL_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Scene;
class Vector;
class RigidBody;
class Collision;
enum class BodyType; 
/**
 * @brief 
 * 
 */
class Physical : public Object
{
	friend class Scene;

protected:
	/**
	 * @brief 
	 * 
	 */
	Scene *scene;

public:
	OBJECT(Physical)
	/**
	 * @brief Construct a new Physical Manager object
	 * 
	 */
	Physical();
	/**
	 * @brief Destroy the Physical Manager object
	 * 
	 */
	virtual ~Physical();
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 */
	virtual void newRigidBody(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 */
	virtual void destoryRigidBody(RigidBody *_rigidBody);
	/**
	 * @brief Get the Position object
	 * 
	 * @param _rigidBody 
	 * @return const Vector& 
	 */
	virtual const Vector& getPosition(RigidBody *_rigidBody);
	/**
	 * @brief Get the Rotate object
	 * 
	 * @param _rigidBody 
	 * @return const Vector& 
	 */
	virtual const Vector& getRotate(RigidBody *_rigidBody);
	/**
	 * @brief Get the Linear Velocity object
	 * 
	 * @param _rigidBody 
	 * @return Vector 
	 */
	virtual Vector getLinearVelocity(RigidBody *_rigidBody);
	/**
	 * @brief Get the Angular Velocity object
	 * 
	 * @param _rigidBody 
	 * @return double 
	 */
	virtual double getAngularVelocity(RigidBody *_rigidBody);
	/**
	 * @brief Get the Linear Damping object
	 * 
	 * @param _rigidBody 
	 * @return double 
	 */
	virtual double getLinearDamping(RigidBody *_rigidBody);
	/**
	 * @brief Get the Angular Damping object
	 * 
	 * @param _rigidBody 
	 * @return double 
	 */
	virtual double getAngularDamping(RigidBody *_rigidBody);
	/**
	 * @brief Get the Gravity Scale object
	 * 
	 * @param _rigidBody 
	 * @return double 
	 */
	virtual double getGravityScale(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 * @return true 
	 * @return false 
	 */
	virtual bool isSleepingAllowed(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 * @return true 
	 * @return false 
	 */
	virtual bool isAwake(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 * @return true 
	 * @return false 
	 */
	virtual bool isFixedRotation(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 * @return true 
	 * @return false 
	 */
	virtual bool isBullet(RigidBody *_rigidBody);
	/**
	 * @brief Get the Type object
	 * 
	 * @param _rigidBody 
	 * @return BodyType 
	 */
	virtual BodyType getType(RigidBody *_rigidBody);
	/**
	 * @brief 
	 * 
	 * @param _rigidBody 
	 * @return true 
	 * @return false 
	 */
	virtual bool isActive(RigidBody *_rigidBody);
	/**
	 * @brief Set the Transform object
	 * 
	 * @param _rigidBody 
	 * @param _vector 
	 * @param _angle 
	 */
    virtual void setTransform(RigidBody *_rigidBody,const Vector& _vector,const Vector& _angle);
	/**
	 * @brief Set the Linear Velocity object
	 * 
	 * @param _rigidBody 
	 * @param _linearVelocity 
	 */
	virtual void setLinearVelocity(RigidBody *_rigidBody,const Vector& _linearVelocity);
	/**
	 * @brief Set the Angular Velocity object
	 * 
	 * @param _rigidBody 
	 * @param _angularVelocity 
	 */
	virtual void setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity);
	/**
	 * @brief Set the Linear Damping object
	 * 
	 * @param _rigidBody 
	 * @param _linearDamping 
	 */
	virtual void setLinearDamping(RigidBody *_rigidBody, double _linearDamping);
	/**
	 * @brief Set the Angular Damping object
	 * 
	 * @param _rigidBody 
	 * @param _angularDamping 
	 */
	virtual void setAngularDamping(RigidBody *_rigidBody, double _angularDamping);
	/**
	 * @brief Set the Gravity Scale object
	 * 
	 * @param _rigidBody 
	 * @param _gravityScale 
	 */
	virtual void setGravityScale(RigidBody *_rigidBody, double _gravityScale);
	/**
	 * @brief Set the Sleeping Allowed object
	 * 
	 * @param _rigidBody 
	 * @param _allowSleep 
	 */
	virtual void setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep);
	/**
	 * @brief Set the Awake object
	 * 
	 * @param _rigidBody 
	 * @param _awake 
	 */
	virtual void setAwake(RigidBody *_rigidBody, bool _awake);
	/**
	 * @brief Set the Fixed Rotation object
	 * 
	 * @param _rigidBody 
	 * @param _fixedRotation 
	 */
	virtual void setFixedRotation(RigidBody *_rigidBody, float _fixedRotation);
	/**
	 * @brief Set the Bullet object
	 * 
	 * @param _rigidBody 
	 * @param _bullet 
	 */
	virtual void setBullet(RigidBody *_rigidBody, bool _bullet);
	/**
	 * @brief Set the Type object
	 * 
	 * @param _rigidBody 
	 * @param _bodyType 
	 */
	virtual void setType(RigidBody *_rigidBody, BodyType _bodyType);
	/**
	 * @brief Set the Active object
	 * 
	 * @param _rigidBody 
	 * @param _active 
	 */
	virtual void setActive(RigidBody *_rigidBody, bool _active);

	/**
	 * @brief 
	 * 
	 * @param _collision 
	 */
	virtual void newCollision(Collision *_collision);
	/**
	 * @brief 
	 * 
	 * @param _collision 
	 */
	virtual void destoryCollision(Collision *_collision);
	/**
	 * @brief 
	 * 
	 */
	virtual void start();
	/**
	 * @brief 
	 * 
	 */
	virtual void update();
	/**
	 * @brief 
	 * 
	 */
	virtual void destory();
};
} // namespace CrystalEngine
#endif
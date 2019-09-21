/**
 * @file Box2dPhysical.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef BOX2DPHYSICAL_H
#define BOX2DPHYSICAL_H

#include "CrystalEngine/Scene/Physical.h"

class b2World;
class b2Body;
namespace CrystalEngine
{
class GameObject;
class Vector;
class RigidBody;
class Collision;
/**
 * @brief 
 * 
 */
class Box2dPhysical : public Physical
{	
	/**
	 * @brief 
	 * 
	 */
    std::unordered_map<std::string,b2Body*>* bodies;
	/**
	 * @brief 
	 * 
	 */
    b2World* world;
	/**
	 * @brief 
	 * 
	 */
    Vector* gravity;
public:
    Box2dPhysical();
    ~Box2dPhysical();
    void newRigidBody(RigidBody *_rigidBody);
    void destoryRigidBody(RigidBody *_rigidBody);

    const Vector& getPosition( RigidBody *_rigidBody);
	const Vector& getRotate(RigidBody *_rigidBody);
	Vector getLinearVelocity( RigidBody *_rigidBody);
	double getAngularVelocity(RigidBody *_rigidBody);
	double getLinearDamping(RigidBody *_rigidBody);
	double getAngularDamping(RigidBody *_rigidBody);
	double getGravityScale(RigidBody *_rigidBody);
	bool isSleepingAllowed(RigidBody *_rigidBody);
	bool isAwake(RigidBody *_rigidBody);
	bool isFixedRotation(RigidBody *_rigidBody);
	bool isBullet(RigidBody *_rigidBody);
	BodyType getType(RigidBody *_rigidBody);
	bool isActive(RigidBody *_rigidBody);

    void setTransform(RigidBody *_rigidBody,const Vector& _vector,const Vector&  _angle);
	void setLinearVelocity(RigidBody *_rigidBody, Vector _linearVelocity);
	void setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity);
	void setLinearDamping(RigidBody *_rigidBody, double _linearDamping);
	void setAngularDamping(RigidBody *_rigidBody, double _angularDamping);
	void setGravityScale(RigidBody *_rigidBody, double _gravityScale);
	void setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep);
	void setAwake(RigidBody *_rigidBody, bool _awake);
	void setFixedRotation(RigidBody *_rigidBody, float _fixedRotation);
	void setBullet(RigidBody *_rigidBody, bool _bullet);
	void setType(RigidBody *_rigidBody, BodyType _bodyType);
	void setActive(RigidBody *_rigidBody, bool _active);

    void newCollision(Collision *_collision);
    void destoryCollision(Collision *_collision);

    void start();

    void update();

    void destory();
};
} // namespace CrystalEngine

#endif
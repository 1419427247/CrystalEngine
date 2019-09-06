#ifndef PHYSICALMANAGER_H
#define PHYSICALMANAGER_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Scene;
class Vector;
class RigidBody;
class Collision;
enum class BodyType; 
class PhysicalManager : public Object
{
	friend class Scene;

protected:
	Scene *scene;

public:
	OBJECT(PhysicalManager)

	PhysicalManager();
	virtual ~PhysicalManager();

	virtual void newRigidBody(RigidBody *_rigidBody);
	virtual void destoryRigidBody(RigidBody *_rigidBody);

	virtual const Vector& getPosition(RigidBody *_rigidBody);
	virtual const Vector& getRotate(RigidBody *_rigidBody);
	virtual Vector getLinearVelocity(RigidBody *_rigidBody);
	virtual double getAngularVelocity(RigidBody *_rigidBody);
	virtual double getLinearDamping(RigidBody *_rigidBody);
	virtual double getAngularDamping(RigidBody *_rigidBody);
	virtual double getGravityScale(RigidBody *_rigidBody);
	virtual bool isSleepingAllowed(RigidBody *_rigidBody);
	virtual bool isAwake(RigidBody *_rigidBody);
	virtual bool isFixedRotation(RigidBody *_rigidBody);
	virtual bool isBullet(RigidBody *_rigidBody);
	virtual BodyType getType(RigidBody *_rigidBody);
	virtual bool isActive(RigidBody *_rigidBody);

    virtual void setTransform(RigidBody *_rigidBody,const Vector& _vector,const Vector& _angle);
	virtual void setLinearVelocity(RigidBody *_rigidBody,const Vector& _linearVelocity);
	virtual void setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity);
	virtual void setLinearDamping(RigidBody *_rigidBody, double _linearDamping);
	virtual void setAngularDamping(RigidBody *_rigidBody, double _angularDamping);
	virtual void setGravityScale(RigidBody *_rigidBody, double _gravityScale);
	virtual void setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep);
	virtual void setAwake(RigidBody *_rigidBody, bool _awake);
	virtual void setFixedRotation(RigidBody *_rigidBody, float _fixedRotation);
	virtual void setBullet(RigidBody *_rigidBody, bool _bullet);
	virtual void setType(RigidBody *_rigidBody, BodyType _bodyType);
	virtual void setActive(RigidBody *_rigidBody, bool _active);

	virtual void newCollision(Collision *_collision);
	virtual void destoryCollision(Collision *_collision);

	virtual void start();

	virtual void update();

	virtual void destory();
};
} // namespace CrystalEngine
#endif
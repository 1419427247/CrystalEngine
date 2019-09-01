#ifndef PHYSICALMANAGER_H
#define PHYSICALMANAGER_H

namespace CrystalEngine
{
class Scene;
class Vector;
class RigidBody;
class Collision;
enum class BodyType; 
class PhysicalManager
{
	friend class Scene;

protected:
	Scene *scene;

public:
	PhysicalManager();
	virtual ~PhysicalManager();

	virtual void newRigidBody(RigidBody *_rigidBody) = 0;
	virtual void destoryRigidBody(RigidBody *_rigidBody) = 0;

	virtual Vector getPosition(RigidBody *_rigidBody) = 0;
	virtual double getRotate(RigidBody *_rigidBody) = 0;
	virtual Vector getLinearVelocity(RigidBody *_rigidBody) = 0;
	virtual double getAngularVelocity(RigidBody *_rigidBody) = 0;
	virtual double getLinearDamping(RigidBody *_rigidBody) = 0;
	virtual double getAngularDamping(RigidBody *_rigidBody) = 0;
	virtual double getGravityScale(RigidBody *_rigidBody) = 0;
	virtual bool isSleepingAllowed(RigidBody *_rigidBody) = 0;
	virtual bool isAwake(RigidBody *_rigidBody) = 0;
	virtual bool isFixedRotation(RigidBody *_rigidBody) = 0;
	virtual bool isBullet(RigidBody *_rigidBody) = 0;
	virtual BodyType getType(RigidBody *_rigidBody) = 0;
	virtual bool isActive(RigidBody *_rigidBody) = 0;

    virtual void setTransform(RigidBody *_rigidBody, Vector _vector,double _angle) = 0;
	virtual void setLinearVelocity(RigidBody *_rigidBody, Vector _linearVelocity) = 0;
	virtual void setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity) = 0;
	virtual void setLinearDamping(RigidBody *_rigidBody, double _linearDamping) = 0;
	virtual void setAngularDamping(RigidBody *_rigidBody, double _angularDamping) = 0;
	virtual void setGravityScale(RigidBody *_rigidBody, double _gravityScale) = 0;
	virtual void setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep) = 0;
	virtual void setAwake(RigidBody *_rigidBody, bool _awake) = 0;
	virtual void setFixedRotation(RigidBody *_rigidBody, float _fixedRotation) = 0;
	virtual void setBullet(RigidBody *_rigidBody, bool _bullet) = 0;
	virtual void setType(RigidBody *_rigidBody, BodyType _bodyType) = 0;
	virtual void setActive(RigidBody *_rigidBody, bool _active) = 0;

	virtual void newCollision(Collision *_collision) = 0;
	virtual void destoryCollision(Collision *_collision) = 0;

	virtual void start() = 0;

	virtual void update() = 0;

	virtual void destory() = 0;
};
} // namespace CrystalEngine
#endif
#ifndef RIGIDBODY_H
#define RIGIDBODY_H

#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{

class Vector;
enum class BodyType
{
	staticBody,
	kinematicBody,
	dynamicBody,
};

class RigidBody : public Component
{
public:
	RigidBody();
	~RigidBody();

	void* getBodyData();

	Vector getPosition() ;
	double getRotate();

	Vector getLinearVelocity() ;
	double getAngularVelocity();

	double getLinearDamping();
	double getAngularDamping();
	double getGravityScale();

	bool isSleepingAllowed();
	bool isAwake();
	bool isFixedRotation();
	bool isBullet();
	BodyType getType();
	bool isActive();

	void setBodyData(void* _bodyData);

    void setTransform(Vector _vector,double _angle);

	void setLinearVelocity(Vector _linearVelocity);
	void setAngularVelocity(double _angularVelocity);

	void setLinearDamping(double _linearDamping);
	void setAngularDamping(double _angularDamping);
	void setGravityScale(double _gravityScale);

	void setSleepingAllowed(bool _allowSleep);
	void setAwake(bool _awake);
	void setFixedRotation(float _fixedRotation);
	void setBullet(bool _bullet);
	void setType(BodyType _bodyType);
	void setActive(bool _active);

	void start() override;
	void update() override;
	void destory() override;
};
} // namespace CrystalEngine
#endif
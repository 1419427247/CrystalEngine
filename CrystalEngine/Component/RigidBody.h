#ifndef RIGIDBODY_H
#define RIGIDBODY_H
#include"CrystalEngine/Component/Vector.h"
#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
enum BodyType
{
	staticBody,
	kinematicBody,
	dynamicBody,
};

class RigidBody : public Component
{
	Vector linearVelocity;
	Vector angularVelocity;

	double linearDamping;
	double angularDamping;
    double gravityScale;

	bool allowSleep;
	bool awake;
	bool fixedRotation;
	bool bullet;
	bool type;
	bool active;
public:
    RigidBody();
    ~RigidBody();
    
    void update();
};
} // namespace
#endif
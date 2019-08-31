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
public:
	Vector* linearVelocity;
	Vector* angularVelocity;

	double linearDamping;
	double angularDamping;
    double gravityScale;

	bool allowSleep;
	bool awake;
	bool fixedRotation;
	bool bullet;
	BodyType type;
	bool active;

    RigidBody();
    ~RigidBody();
    
	void setPosition();
	void setRotate();

	void start() override;
    void update() override;
	void destory() override;

};
} // namespace
#endif
#ifndef BOX2DPHYSICAL_H
#define BOX2DPHYSICAL_H
#include "CrystalEngine/Scene/PhysicalManager.h"

#include <unordered_map>

class b2World;
class b2Body;
namespace CrystalEngine
{
class GameObject;
class Vector;
class RigidBody;
class Collision;
class Box2dPhysical : public PhysicalManager
{
    std::unordered_map<std::string,b2Body*>* bodies;

    b2World* world;
    Vector* gravity;
public:
    Box2dPhysical();
    ~Box2dPhysical();
    void newRigidBody(RigidBody *_rigidBody);
    void destoryRigidBody(RigidBody *_rigidBody);

    Vector getPosition( RigidBody *_rigidBody);
	double getRotate(RigidBody *_rigidBody);
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

    void setTransform(RigidBody *_rigidBody, Vector _vector,double _angle);
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
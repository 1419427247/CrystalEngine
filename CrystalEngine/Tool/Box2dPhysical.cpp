#include "CrystalEngine/Tool/Box2dPhysical.h"

#include "CrystalEngine/Scene/GameObject.h"

#include "CrystalEngine/Component/RigidBody.h"
#include "CrystalEngine/Component/Collision.h"
#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Vector.h"

#include "Box2D/Box2D.h"

namespace CrystalEngine
{

Box2dPhysical::Box2dPhysical()
{
	gravity = new Vector(0, -9.8f);
	world = new b2World(b2Vec2(gravity->getX(), gravity->getY()));

	bodies = new std::unordered_map<std::string,b2Body*>();
}
Box2dPhysical::~Box2dPhysical()
{
}
void Box2dPhysical::newRigidBody(RigidBody *_rigidBody)
{
	b2BodyDef _b2BodyDef;
	_b2BodyDef.userData = _rigidBody->gameObject;
	_b2BodyDef.position.Set(_rigidBody->gameObject->transform->position->getX(), _rigidBody->gameObject->transform->position->getY());
	_b2BodyDef.angle = _rigidBody->gameObject->transform->rotate;
	
	(*bodies)[_rigidBody->gameObject->getName()] = world->CreateBody(&_b2BodyDef);
}
void Box2dPhysical::destoryRigidBody(RigidBody *_rigidBody)
{
	world->DestroyBody((*bodies)[_rigidBody->gameObject->getName()]);
}

// Vector* Box2dPhysical::getPosition(const RigidBody *_rigidBody)const
// {
// 	return _rigidBody->gameObject->transform->position;
// }
double Box2dPhysical::getRotate(RigidBody *_rigidBody)
{
	float t = (*bodies)[_rigidBody->gameObject->getName()]->GetAngle();
	return t;
}
// Vector* Box2dPhysical::getLinearVelocity(const RigidBody *_rigidBody) const
// {
// 	b2Vec2 t = (*bodies)[_rigidBody->gameObject->getName()]->GetLinearVelocity();
// 	Vector _v(t.x, t.y);
// 	return &_v;
// }
double Box2dPhysical::getAngularVelocity(RigidBody *_rigidBody)
{
	double t = (*bodies)[_rigidBody->gameObject->getName()]->GetAngularVelocity();
	return t;
}
double Box2dPhysical::getLinearDamping(RigidBody *_rigidBody)
{
	float t = (*bodies)[_rigidBody->gameObject->getName()]->GetLinearDamping();
	return t;
}
double Box2dPhysical::getAngularDamping(RigidBody *_rigidBody)
{
	float t = (*bodies)[_rigidBody->gameObject->getName()]->GetAngularDamping();
	return t;
}
double Box2dPhysical::getGravityScale(RigidBody *_rigidBody)
{
	float t = (*bodies)[_rigidBody->gameObject->getName()]->GetGravityScale();
	return t;
}
bool Box2dPhysical::isSleepingAllowed(RigidBody *_rigidBody)
{
	bool t = (*bodies)[_rigidBody->gameObject->getName()]->IsSleepingAllowed();
	return t;
}
bool Box2dPhysical::isAwake(RigidBody *_rigidBody)
{
	bool t = (*bodies)[_rigidBody->gameObject->getName()]->IsAwake();
	return t;
}
bool Box2dPhysical::isFixedRotation(RigidBody *_rigidBody)
{
	bool t = (*bodies)[_rigidBody->gameObject->getName()]->IsFixedRotation();
	return t;
}
bool Box2dPhysical::isBullet(RigidBody *_rigidBody)
{
	bool t = (*bodies)[_rigidBody->gameObject->getName()]->IsBullet();
	return t;
}
BodyType Box2dPhysical::getType(RigidBody *_rigidBody)
{
	BodyType t = (BodyType)(*bodies)[_rigidBody->gameObject->getName()]->GetType();
	return t;
}
bool Box2dPhysical::isActive(RigidBody *_rigidBody)
{
	bool t = (*bodies)[_rigidBody->gameObject->getName()]->IsActive();
	return t;
}
void Box2dPhysical::setTransform(RigidBody *_rigidBody, Vector _vector, double _angle)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetTransform(b2Vec2(_vector.getX(), _vector.getY()), _angle);
}

void Box2dPhysical::setLinearVelocity(RigidBody *_rigidBody, Vector _linearVelocity)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetLinearVelocity(b2Vec2(_linearVelocity.getX(), _linearVelocity.getY()));
}

void Box2dPhysical::setAngularVelocity(RigidBody *_rigidBody, double _angularVelocity)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetAngularVelocity(_angularVelocity);
}

void Box2dPhysical::setLinearDamping(RigidBody *_rigidBody, double _linearDamping)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetLinearDamping(_linearDamping);
}

void Box2dPhysical::setAngularDamping(RigidBody *_rigidBody, double _angularDamping)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetAngularDamping(_angularDamping);
}

void Box2dPhysical::setGravityScale(RigidBody *_rigidBody, double _gravityScale)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetGravityScale(_gravityScale);
}

void Box2dPhysical::setSleepingAllowed(RigidBody *_rigidBody, bool _allowSleep)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetSleepingAllowed(_allowSleep);
}

void Box2dPhysical::setAwake(RigidBody *_rigidBody, bool _awake)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetAwake(_awake);
}

void Box2dPhysical::setFixedRotation(RigidBody *_rigidBody, float _fixedRotation)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetFixedRotation(_fixedRotation);
}

void Box2dPhysical::setBullet(RigidBody *_rigidBody, bool _bullet)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetBullet(_bullet);
}

void Box2dPhysical::setType(RigidBody *_rigidBody, BodyType _bodyType)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetType((b2BodyType)_bodyType);
}

void Box2dPhysical::setActive(RigidBody *_rigidBody, bool _active)
{
	(*bodies)[_rigidBody->gameObject->getName()]->SetActive(_active);
}

void Box2dPhysical::newCollision(Collision *_collision)
{
}
void Box2dPhysical::destoryCollision(Collision *_collision)
{
}

void Box2dPhysical::start()
{
}

void Box2dPhysical::update()
{
	world->Step(0.02f, 30, 30);

	b2Body *list = world->GetBodyList();

	for (int i = 0; i < world->GetBodyCount(); i++)
	{
		GameObject *g = (GameObject *)list[i].GetUserData();
		g->transform->position->set(list[i].GetPosition().x, list[i].GetPosition().y);
		g->transform->rotate = list[i].GetAngle();
	}
}

void Box2dPhysical::destory()
{
}

} // namespace CrystalEngine
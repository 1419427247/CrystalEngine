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
}
Box2dPhysical::~Box2dPhysical()
{
}
void Box2dPhysical::newRigidBody(RigidBody *_rigidBody)
{
	b2BodyDef _b2BodyDef;
	_b2BodyDef.userData = _rigidBody->gameObject;
	_b2BodyDef.position.Set(0.0f, 0.0f);
	_b2BodyDef.angle = 1.0f;
	_b2BodyDef.linearVelocity.Set(_rigidBody->linearVelocity->getX(), _rigidBody->linearVelocity->getY());
	_b2BodyDef.angularVelocity = atan(_rigidBody->angularVelocity->getY() / _rigidBody->angularVelocity->getX());
	_b2BodyDef.linearDamping = _rigidBody->linearDamping;
	_b2BodyDef.angularDamping = _rigidBody->angularDamping;
	_b2BodyDef.allowSleep = _rigidBody->allowSleep;
	_b2BodyDef.awake = _rigidBody->awake;
	_b2BodyDef.fixedRotation = _rigidBody->fixedRotation;
	_b2BodyDef.bullet = _rigidBody->bullet;
	_b2BodyDef.type = (b2BodyType)_rigidBody->type;
	_b2BodyDef.active = _rigidBody->active;
	_b2BodyDef.gravityScale = _rigidBody->gravityScale;

	world->CreateBody(&_b2BodyDef);
}
void Box2dPhysical::destoryRigidBody(RigidBody *_rigidBody)
{
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

	for (size_t i = 0; i < world->GetBodyCount(); i++)
	{
		GameObject *g = (GameObject *)list[i].GetUserData();
		g->transform->position->set(list[i].GetPosition().x, list[i].GetPosition().y);
	}
}

void Box2dPhysical::destory()
{
	
}

} // namespace CrystalEngine
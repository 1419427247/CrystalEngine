#ifndef COMPONENT_H
#define COMPONENT_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"
#include <vector>
#include <string>

namespace CrystalEngine
{
class GameObject;
class RigidBody;
class Component : public Object
{
	friend class GameObject;
	friend class RigidBody;
public:
	OBJECT(Component)

	GameObject *gameObject;

	Component();
	
	virtual ~Component();

	virtual void start();
	virtual void update();
	virtual void destory();

	bool newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	bool destoryGameObject(std::string _name);

	bool newComponent(Component *_component);
	Component *getComponent(std::string _name) const;
	bool destoryComponent(std::string _name);
};
} // namespace CrystalEngine
#endif
#ifndef COMPONENT_H
#define COMPONENT_H

#include "CrystalEngine/Tool/Test.h"
#include <vector>
#include <string>

namespace CrystalEngine
{
class GameObject;
class RigidBody;
class Component
{
	friend class GameObject;
	friend class RigidBody;
protected:
	std::string name;
public:
	GameObject *gameObject;
	Component(std::string _name);
	virtual ~Component();

	virtual void start()=0;
	virtual void update()=0;
	virtual void destory()=0;

	bool newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName) const;
	bool destoryGameObject(std::string _name);

	bool newComponent(Component *_component);
	Component *getComponent(std::string _name) const;
	bool destoryComponent(std::string _name);
};
} // namespace CrystalEngine
#endif
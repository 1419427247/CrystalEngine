#ifndef COMPONENT_H
#define COMPONENT_H

#include <vector>
#include <string>
namespace CrystalEngine
{
class GameObject;
class Component
{
	friend class GameObject;
	std::string name;
public:
	GameObject *gameObject;
	Component(std::string _name);
	~Component();

	virtual void start();
	virtual void update();

	void finish();

	bool newGameObject(std::string _gameObjectName);
	GameObject *getGameObject(std::string _gameObjectName);
	void destoryGameObject(std::string _name);

	void newComponent(Component *_component);
	Component *getComponent(std::string _name);
	void destoryComponent(std::string _name);
};
} // namespace CrystalEngine
#endif
#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Scene.h"
namespace CrystalEngine
{
Component::Component(std::string _name)
{
	name = _name;
	gameObject = nullptr;
}

Component::~Component()
{
}

void Component::start()
{
}

void Component::update()
{
}

void Component::destory()
{
}

void Component::finish()
{
	gameObject->scene->finish();
}

bool Component::newGameObject(std::string _gameObjectName)
{
	return gameObject->newGameObject(_gameObjectName);
}

GameObject *Component::getGameObject(std::string _gameObjectName) const
{
	return gameObject->getGameObject(_gameObjectName);
}

bool Component::destoryGameObject(std::string _name)
{
	return gameObject->destoryGameObject(_name);
}

bool Component::newComponent(Component *_component)
{
	return gameObject->newComponent(_component);
}

Component *Component::getComponent(std::string _name) const
{
	return gameObject->getComponent(_name);
}

bool Component::destoryComponent(std::string _name)
{
	return gameObject->destoryComponent(_name);
}

} // namespace CrystalEngine
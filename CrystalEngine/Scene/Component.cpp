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

void Component::finish()
{
	gameObject->scene->finish();
}

bool Component::newGameObject(std::string _gameObjectName)
{
	return gameObject->newGameObject(_gameObjectName);
}

GameObject *Component::getGameObject(std::string _gameObjectName)
{
	return gameObject->getGameObject(_gameObjectName);
}

void Component::newComponent(Component *_component)
{
	gameObject->newComponent(_component);
}

Component *Component::getComponent(std::string _name)
{
	return gameObject->getComponent(_name);
}

void Component::destoryComponent(std::string _name)
{
	gameObject->deleteComponents->push_back(_name);
}

void Component::destoryGameObject(std::string _name)
{
	gameObject->destoryGameObject(_name);
}

} // namespace CrystalEngine
#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
GameObject::GameObject(std::string _name)
{
	name = _name;
	newComponents = new std::vector<Component *>();
	deleteComponents = new std::vector<std::string>();
	components = new std::list<Component *>();
	scene = nullptr;
	parent = nullptr;
	child = new std::list<GameObject *>();
}

GameObject::~GameObject()
{
	while (!components->empty())
	{
		delete components->back();
		components->pop_back();
	}
	delete components;
	delete child;
}

void GameObject::start()
{
	for (Component *var : *components)
	{
		var->start();
	}
}

void GameObject::update()
{
	for (std::string var : *deleteComponents)
	{
		for (Component *component : *components)
		{
			if (component->name == var)
			{
				components->remove(component);
				delete component;
				break;
			}
		}
	}
	deleteComponents->clear();

	for (Component *var : *newComponents)
	{
		components->push_back(var);
		var->gameObject = this;
		var->start();
	}
	newComponents->clear();

	for (Component *var : *components)
	{
		var->update();
	}
}

std::string GameObject::getGameObjectName()
{
	return name;
}

bool GameObject::setParten(GameObject *_gameObject)
{
	if(_gameObject == NULL)
	{
		parent=NULL;
	}
	if (_gameObject == this)
		return false;
	for (GameObject *var : *(_gameObject->child))
	{
		if (var->name == name)
			return false;
	}
	if (parent != NULL)
		parent->child->remove(this);
	_gameObject->child->push_back(this);
	parent = _gameObject;
	return true;
}

bool GameObject::addChild(GameObject *_gameObject)
{
	if (_gameObject == this)
		return false;
	for (GameObject *var : *child)
		if (var->name == name)
			return false;
	if (_gameObject->parent != NULL)
		_gameObject->parent->child->remove(_gameObject);
	child->push_back(_gameObject);
	_gameObject->parent = this;
	return true;
}

bool GameObject::removeChild(GameObject* _gameObject){
	for (GameObject *var : *child)
		if (var->name == name){
			var->parent = NULL;
			child->remove(var);
			return true;
		}
	return false;
}
bool GameObject::cleanChild(){
	for (GameObject *var : *child){
		var->parent=NULL;
	}
	child->clear();
	return true;
}

bool GameObject::newGameObject(std::string _gameObjectName)
{
	return scene->newGameObject(_gameObjectName);
}

bool GameObject::creatGameObject(std::string _gameObjectName)
{
	return scene->creatGameObject(_gameObjectName);
}

GameObject *GameObject::getGameObject(std::string _gameObjectName)
{
	return scene->getGameObject(_gameObjectName);
	;
}

void GameObject::destoryGameObject(std::string _name)
{
	scene->destoryGameObject(_name);
}

bool GameObject::creatComponent(Component *_component)
{
	if (_component == nullptr)
		return false;
	components->push_back(_component);
	_component->gameObject = this;
	return true;
}

bool GameObject::newComponent(Component *_component)
{
	if (_component == nullptr)
		return false;
	newComponents->push_back(_component);
	return true;
}

Component *GameObject::getComponent(std::string _name)
{
	for (Component *var : *components)
	{
		if (var->name == _name)
		{
			return var;
		}
	}
	return nullptr;
}

void GameObject::destoryComponent(std::string _name)
{
	deleteComponents->push_back(_name);
}
} // namespace CrystalEngine
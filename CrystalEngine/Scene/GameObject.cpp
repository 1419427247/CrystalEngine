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
	children = new std::list<GameObject *>();
}

GameObject::~GameObject()
{
	while (!components->empty())
	{
		delete components->back();
		components->pop_back();
	}
	while (!newComponents->empty())
	{
		delete newComponents->back();
		newComponents->pop_back();
	}
	delete newComponents;
	delete deleteComponents;
	delete components;
	delete children;
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

std::string GameObject::getName()
{
	return name;
}

bool GameObject::setParten(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
	{
		parent->removeChild(this);
		parent = NULL;
	}
	if (_gameObject == this)
		return false;
	for (GameObject *var : *(_gameObject->children))
	{
		if (var->name == _gameObject->name)
			return false;
	}
	if (parent != NULL)
		parent->children->remove(this);
	_gameObject->children->push_back(this);
	parent = _gameObject;
	return true;
}

GameObject *GameObject::getParten()
{
	return parent;
}

bool GameObject::addChild(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
		return false;
	if (_gameObject == this)
		return false;
	for (GameObject *var : *children)
		if (var->name == _gameObject->name)
			return false;
	if (_gameObject->parent != NULL)
		_gameObject->parent->children->remove(_gameObject);
	children->push_back(_gameObject);
	_gameObject->parent = this;
	return true;
}

std::vector<GameObject *> GameObject::getChildren()
{
	std::vector<GameObject *> result;
	for (GameObject *var : *children)
		result.push_back(var);
	return result;
}
int GameObject::getChildrenCount()
{
	return children->size();
}

bool GameObject::removeChild(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
		return false;
	for (GameObject *var : *children)
		if (var->name == _gameObject->name)
		{
			var->parent = NULL;
			children->remove(var);
			return true;
		}
	return false;
}
bool GameObject::cleanChildren()
{
	for (GameObject *var : *children)
	{
		var->parent = NULL;
	}
	children->clear();
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





TestGameObject::TestGameObject() : Test("")
{
}

TestGameObject::~TestGameObject()
{
}

void TestGameObject::run()
{
	CrystalEngine::GameObject *obj1 = new CrystalEngine::GameObject("G1");
	CrystalEngine::GameObject *obj2 = new CrystalEngine::GameObject("G2");
	CrystalEngine::GameObject *obj3 = new CrystalEngine::GameObject("G3");

	Comparison(obj1->addChild(obj2), true);
	Comparison(obj1->addChild(obj3), true);

	Comparison(obj1->addChild(obj2), false);
	Comparison(obj1->addChild(obj3), false);

	Comparison(obj2->getParten(), obj1);
	Comparison(obj3->getParten(), obj1);

	Comparison(obj1->getChildrenCount(), 2);
	Comparison(obj1->getChildren().size(), 2);

	delete obj1;
	delete obj2;
	delete obj3;
}

} // namespace CrystalEngine
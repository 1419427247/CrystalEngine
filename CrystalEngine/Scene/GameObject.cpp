/**
 * @file GameObject.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Component.h"

#include "CrystalEngine/Component/Transform.h"
namespace CrystalEngine
{
GameObject::GameObject()
{
	scene = nullptr;
	parent = nullptr;

	newComponents = new std::vector<Component *>();
	deleteComponents = new std::vector<std::string>();
	components = new std::vector<Component *>();

	children = new std::vector<GameObject *>();
	transform = new Transform();
	creatComponent(transform);
}
GameObject::GameObject(std::string _name) : GameObject()
{
	name = _name;
}

GameObject::GameObject(std::string _name, Scene *_scene) : GameObject(_name)
{
	scene = _scene;
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
		try
		{
			var->start();
		}
		catch (const std::exception &e)
		{
			std::cerr << e.what() << '\n';
		}
	}
}

void GameObject::update()
{
	for (std::string var : *deleteComponents)
	{
		for (Component *component : *components)
		{
			if (component->__getClassName() == var)
			{
				try
				{
					component->destory();
				}
				catch (const std::exception &e)
				{
					std::cerr << e.what() << '\n';
				}

				//components->erase(std::find(components->begin(),components->end(), component));
				std::swap(*std::find(components->begin(), components->end(), component), *components->end());
				components->pop_back();

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

		try
		{
			var->start();
		}
		catch (const std::exception &e)
		{
			std::cerr << e.what() << '\n';
		}
	}
	newComponents->clear();

	for (Component *var : *components)
	{
		try
		{
			var->update();
		}
		catch (const std::exception &e)
		{
			std::cerr << e.what() << '\n';
		}
	}
}

void GameObject::destory()
{
	for (Component *var : *components)
	{
		try
		{
			var->destory();
		}
		catch (const std::exception &e)
		{
			std::cerr << e.what() << '\n';
		}
	}
}

std::string GameObject::getName() const
{
	return name;
}

Scene &GameObject::getScene()
{
	return *scene;
}

std::vector<Component *> &GameObject::getComponents()
{
	return *components;
}

void GameObject::setParten(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
	{
		if (parent != nullptr)
		{
			parent->removeChild(this);
		}
		parent = nullptr;
		return;
	}

	if (_gameObject == this)
	{
		throw std::logic_error("Parent object can't be yourself");
	}
	if (parent == _gameObject)
	{
		throw std::logic_error("The object is already your parten");
	}

	if (_gameObject->parent != nullptr)
	{
		// _gameObject->parent->children->erase(
		// 	std::find(_gameObject->parent->children->begin(),
		// 			  _gameObject->parent->children->end(),
		// 			  this));
		std::swap(
			*std::find(
				_gameObject->parent->children->begin(),
				_gameObject->parent->children->end(), this),
			*_gameObject->parent->children->end());

		_gameObject->parent->children->pop_back();

		_gameObject->parent = nullptr;
	}
	if (parent != nullptr)
	{

		// parent->children->erase(
		// 	std::find(parent->children->begin(),
		// 			  parent->children->end(),
		// 			  this));

		std::swap(
			*std::find(
				parent->children->begin(),
				parent->children->end(), this),
			*parent->children->end());
		parent->children->pop_back();

		_gameObject->parent = this->parent;
		_gameObject->parent->children->push_back(_gameObject);
	}
	parent = _gameObject;
	parent->children->push_back(this);
}

GameObject *GameObject::getParten() const
{
	return parent == nullptr ? nullptr : parent;
}

void GameObject::addChild(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
	{
		throw std::invalid_argument("Parameter cannot be empty");
	}
	if (_gameObject == this)
	{
		throw std::logic_error("Child object can't be yourself");
	}
	if (_gameObject->parent == this)
	{
		throw std::logic_error("The object is already your child");
	}
	GameObject *temp = _gameObject->parent;
	while (temp)
	{
		if (temp == _gameObject)
		{
			throw std::logic_error("Cannot operate on parent objects");
		}
		else
		{
			temp = temp->parent;
		}
	}
	if (_gameObject->parent != nullptr)
	{

		// _gameObject->parent->children->erase(
		// 	std::find(
		// 		_gameObject->parent->children->begin(),
		// 		_gameObject->parent->children->end(),
		// 		_gameObject));
		std::swap(
			*std::find(
				_gameObject->parent->children->begin(),
				_gameObject->parent->children->end(), this),
			*_gameObject->parent->children->end());
		parent->children->pop_back();
	}
	this->children->push_back(_gameObject);
	_gameObject->parent = this;
}

const std::vector<GameObject *> &GameObject::getChildren() const
{
	return *(this->children);
}
int GameObject::getChildrenCount() const
{
	return children->size();
}

void GameObject::removeChild(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
		throw std::invalid_argument("Parameter cannot be empty");
	for (GameObject *var : *children)
	{
		if (var == _gameObject)
		{
			var->parent = NULL;
			//children->erase(std::find(children->begin(),children->end(),var));
			std::swap(
				*std::find(
					children->begin(),
					children->end(), this),
				*children->end());

			children->pop_back();

			return;
		}
		throw std::runtime_error("Did not find the object");
	}
}
void GameObject::cleanChildren()
{
	for (GameObject *var : *children)
	{
		var->parent = nullptr;
	}
	children->clear();
}

void GameObject::newGameObject(std::string _gameObjectName)
{
	scene->newGameObject(_gameObjectName);
}

void GameObject::creatGameObject(std::string _gameObjectName)
{
	scene->creatGameObject(_gameObjectName);
}

GameObject *GameObject::getGameObject(std::string _gameObjectName) const
{
	return scene->getGameObject(_gameObjectName);
}

void GameObject::destoryGameObject(std::string _name)
{
	scene->destoryGameObject(_name);
}

void GameObject::creatComponent(Component *_component)
{
	if (_component == nullptr)
		throw std::invalid_argument("Parameter cannot be empty");
	components->push_back(_component);
	_component->gameObject = this;
}

void GameObject::newComponent(Component *_component)
{
	if (_component == nullptr)
		throw std::invalid_argument("Parameter cannot be empty");
	for (Component *var : *components)
	{
		if (var->__getClassName() == _component->__getClassName())
			throw std::runtime_error("Component : " + _component->__getClassName() + "already exists");
	}
	for (Component *var : *newComponents)
	{
		if (var->__getClassName() == _component->__getClassName())
			throw std::runtime_error("Component : " + _component->__getClassName() + "already exists");
	}
	newComponents->push_back(_component);
}

Component *GameObject::getComponent(std::string _name) const
{
	for (Component *var : *components)
	{
		if (var->__getClassName() == _name)
		{
			return var;
		}
	}
	throw std::runtime_error("Component : \"" + _name + "\" not found");
}

void GameObject::destoryComponent(std::string _name)
{
	for (Component *var : *components)
	{
		if (var->__getClassName() == _name)
		{
			for (std::string var : *deleteComponents)
			{
				if (var == _name)
					throw std::runtime_error("Component : \"" + _name + "\" not found");
			}
			deleteComponents->push_back(_name);
			return;
		}
	}
	throw std::runtime_error("Component : \"" + _name + "\" not found");
}

std::string GameObject::toString()
{
	return name;
}

TestGameObject::TestGameObject()
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

	// Comparison(obj1->addChild(obj2), true);
	// Comparison(obj1->addChild(obj3), false);

	// Comparison(obj1->addChild(obj2), false);
	// Comparison(obj1->addChild(obj3), false);

	// Comparison(obj2->getParten(), obj1);
	// Comparison(obj3->getParten(), obj1);

	// Comparison(obj1->getChildrenCount(), 2);
	// Comparison(obj1->getChildren().size(), 2);

	delete obj1;
	delete obj2;
	delete obj3;
}

} // namespace CrystalEngine
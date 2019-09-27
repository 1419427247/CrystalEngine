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

#include "CrystalEngine/World/World.h"

#include "CrystalEngine/GameObject/GameObject.h"

#include "CrystalEngine/Component/Component.h"
#include "CrystalEngine/Component/Transform.h"

namespace CrystalEngine
{

GameObject::GameObject(std::string _name,World* _world)
{
	name = _name;
	world = _world;

	components = new std::vector<Component *>();
	children = new std::vector<GameObject *>();

	transform = new Transform(this);
}

GameObject::~GameObject()
{
	while (!components->empty())
	{
		delete components->back();
		components->pop_back();
	}
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

World &GameObject::getWorld()
{
	return *world;
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

} // namespace CrystalEngine
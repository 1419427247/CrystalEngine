#include<iostream>
#include <stdexcept>

#include "CrystalEngine/Scene/Scene.h"
#include "CrystalEngine/Scene/GameObject.h"
#include "CrystalEngine/Scene/Component.h"

#include "CrystalEngine/Component/Transform.h"
namespace CrystalEngine
{
GameObject::GameObject()
{
	newComponents = new std::vector<Component *>();
	deleteComponents = new std::vector<std::string>();
	components = new std::list<Component *>();
	scene = nullptr;
	parent = nullptr;
	children = new std::list<GameObject *>();
	transform = new Transform();
}
GameObject::GameObject(std::string _name)
{
	name = _name;
	newComponents = new std::vector<Component *>();
	deleteComponents = new std::vector<std::string>();
	components = new std::list<Component *>();
	scene = nullptr;
	parent = nullptr;
	children = new std::list<GameObject *>();
	transform = new Transform();
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
	components->push_front(transform);
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
			if (component->getClassName() == var)
			{
				component->destory();
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

void GameObject::destory()
{
	for (Component *var : *components)
	{
		var->destory();
	}
}

std::string GameObject::getName() const
{
	return name;
}

Scene& GameObject::getScene(){
	return *scene;
}

std::list<Component *>& GameObject::getComponents(){
	return *components;
}

bool GameObject::setParten(GameObject *_gameObject)
{
	if (_gameObject == nullptr)
	{
		if (parent != nullptr)
		{
			parent->removeChild(this);
		}
		parent = nullptr;
		return true;
	}
	try
	{
		if (_gameObject == this)
		{
			throw std::logic_error("Parent object can't be yourself");
		}
		if (parent == _gameObject)
		{
			throw std::logic_error("The object is already your parten");
		}
	}
	catch(const std::logic_error& e){
		std::cerr<<e.what()<<std::endl;
		return false;
	}

	if(_gameObject->parent!=nullptr){
		_gameObject->parent->children->remove(_gameObject);
		_gameObject->parent = nullptr;
	}
	if (parent != nullptr){
		parent->children->remove(this);
		_gameObject->parent = this->parent;
		_gameObject->parent->children->push_back(_gameObject);
	}
	parent = _gameObject;
	parent ->children->push_back(this);
	return true;
}

GameObject* GameObject::getParten() const
{
	return parent;
}

bool GameObject::addChild(GameObject *_gameObject)
{
	try
	{
		if (_gameObject == nullptr)
		{
			throw std::invalid_argument("Parameter cannot be empty");
		}
		if (_gameObject == this)
		{
			throw std::logic_error("Child object can't be yourself");
		}
		if (_gameObject->parent == this){
			throw std::logic_error("The object is already your child");
		}
		GameObject* temp = _gameObject->parent;
		while (temp)
		{
			if(temp == _gameObject){
				throw std::logic_error("Cannot operate on parent objects");
			}
			else{
				temp=temp->parent;
			}
		}
	}
	catch (const std::invalid_argument &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	catch (const std::logic_error &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	if(_gameObject->parent != nullptr){
		_gameObject->parent->children->remove(_gameObject);
	}
	this->children->push_back(_gameObject);
	_gameObject->parent = this;

	return true;
}

const std::list<GameObject *>& GameObject::getChildren() const
{
	return *(this->children);
}
int GameObject::getChildrenCount() const
{
	return children->size();
}

bool GameObject::removeChild(GameObject *_gameObject)
{
	try{
	if (_gameObject == nullptr)
		throw std::invalid_argument("Parameter cannot be empty");
	for (GameObject *var : *children)
		if (var == _gameObject)
		{
			var->parent = NULL;
			children->remove(var);
			return true;
		}
		throw std::runtime_error("Did not find the object");
	}
	catch(const std::invalid_argument& e){
		std::cerr << e.what() << std::endl;
		return false;
	}
	catch(const std::runtime_error& e){
		std::cerr << e.what() << std::endl;
		return false;
	}
	return true;
}
void GameObject::cleanChildren()
{
	for (GameObject *var : *children)
	{
		var->parent = NULL;
	}
	children->clear();
}

bool GameObject::newGameObject(std::string _gameObjectName)
{
	return scene->newGameObject(_gameObjectName);
}

bool GameObject::creatGameObject(std::string _gameObjectName)
{
	return scene->creatGameObject(_gameObjectName);
}

GameObject *GameObject::getGameObject(std::string _gameObjectName) const
{
	return scene->getGameObject(_gameObjectName);
	;
}

bool GameObject::destoryGameObject(std::string _name)
{
	return scene->destoryGameObject(_name);
}

bool GameObject::creatComponent(Component *_component)
{
	try{
		if (_component == nullptr)
			throw std::invalid_argument("Parameter cannot be empty");
	}
	catch(const std::invalid_argument& e){
		std::cerr << e.what() << std::endl;
		return false;
	}
	components->push_back(_component);
	_component->gameObject = this;
	return true;
}

bool GameObject::newComponent(Component *_component)
{
	try
	{
		if (_component == nullptr)
			throw std::invalid_argument("Parameter cannot be empty");
		for (Component *var : *components)
		{
			if (var->getClassName() == _component->getClassName())
				throw std::runtime_error("Component already exists");
		}
		for (Component *var : *newComponents)
		{
			if (var->getClassName() == _component->getClassName())
				throw std::runtime_error("Component already exists");
		}
	}
	catch (const std::invalid_argument &e)
	{
		std::cerr << e.what() << std::endl;
		return false;
	}
	catch (const std::runtime_error &e)
	{
		std::cerr << e.what() << ": class" << _component->getClassName() << std::endl;
		return false;
	}
	newComponents->push_back(_component);
	return true;
}

Component *GameObject::getComponent(std::string _name) const
{
	for (Component *var : *components)
	{
		if (var->getClassName() == _name)
		{
			return var;
		}
	}
	try
	{
		throw std::runtime_error("Component not found");
	}
	catch(const std::runtime_error& e)
	{
		std::cerr << e.what() << std::endl;
		return nullptr;
	}
}

bool GameObject::destoryComponent(std::string _name)
{
	try{
		for (Component *var : *components)
		{
			if (var->getClassName() == _name)
			{
				for (std::string var : *deleteComponents)
				{
					if (var == _name)
						throw std::runtime_error("Component not found");
				}
				deleteComponents->push_back(_name);
				return true;
			}
		}
		throw std::runtime_error("Component not found");
	}
	catch(const std::runtime_error& e){
		std::cerr << e.what() << std::endl;
		return false;
	}
}

std::string GameObject::toString(){
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
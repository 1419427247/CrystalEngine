/**
 * @file GameObject.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef GAMEOBJECT_H
#define GAMEOBJECT_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Component;
class Transform;
class World;

class GameObject : public Object
{

private:
	World* world;

	std::string name;
	std::vector<Component *> *components;

	GameObject *parent;
	std::vector<GameObject *> *children;

public:
	Transform* transform;

	OBJECT(GameObject)

	GameObject(std::string _name,World* _world);
	~GameObject();

	void start();
	void update();
	void destory();

	std::string getName() const;
	World& getWorld();
	std::vector<Component *>& getComponents();
	GameObject *getParten() const;

	void setParten(GameObject *_gameObject);
	void addChild(GameObject *_gameObject);

	const std::vector<GameObject *>& getChildren() const;
	int getChildrenCount() const;
	void removeChild(GameObject *_gameObject);
	void cleanChildren();

};

} // namespace CrystalEngine

#endif
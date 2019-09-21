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
#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
class Component;
class Scene;
class Transform;
class RigidBody;
class Collision;

class GameObject : public Object
{
	friend class Scene;
	friend class Component;
	friend class RigidBody;
	friend class Collision;

private:
	/**
	 * @brief 指向游戏场景
	 * 
	 */
	Scene *scene;
	/**
	 * @brief 在游戏下一次更新时要新增的组件
	 * 
	 */
	std::vector<Component *> *newComponents;
	/**
	 * @brief 在游戏下一次更新时要移除的组件
	 * 
	 */
	std::vector<std::string> *deleteComponents;
	/**
	 * @brief 游戏物体的唯一名字
	 * 
	 */
	std::string name;
	/**
	 * @brief 游戏物体组件容器
	 * 
	 */
	std::list<Component *> *components;
	/**
	 * @brief 父物体
	 * 
	 */
	GameObject *parent;
	/**
	 * @brief 子物体
	 * 
	 */
	std::list<GameObject *> *children;

public:
	OBJECT(GameObject)
	/**
	 * @brief 
	 * 
	 */
	Transform *transform;
	/**
	 * @brief Construct a new Game Object object
	 * 
	 */
	GameObject();
	/**
	 * @brief Construct a new Game Object object
	 * 
	 * @param _name 
	 */
	GameObject(std::string _name);
	/**
	 * @brief Destroy the Game Object object
	 * 
	 */
	~GameObject();
	/**
	 * @brief 
	 * 
	 */
	void start();
	/**
	 * @brief 
	 * 
	 */
	void update();
	/**
	 * @brief 
	 * 
	 */
	void destory();
	/**
	 * @brief Get the Name object
	 * 
	 * @return std::string 
	 */
	std::string getName() const;
	/**
	 * @brief Get the Scene object
	 * 
	 * @return Scene& 
	 */
	Scene& getScene();
	/**
	 * @brief Get the Components object
	 * 
	 * @return std::list<Component *>& 
	 */
	std::list<Component *>& getComponents();

	/**
	 * @brief Set the Parten object
	 * 
	 * @param _gameObject 
	 * @return true 
	 * @return false 
	 */
	bool setParten(GameObject *_gameObject);
	/**
	 * @brief Get the Parten object
	 * 
	 * @return GameObject* 
	 */
	GameObject *getParten() const;
	/**
	 * @brief 
	 * 
	 * @param _gameObject 
	 * @return true 
	 * @return false 
	 */
	bool addChild(GameObject *_gameObject);
	/**
	 * @brief Get the Children object
	 * 
	 * @return const std::list<GameObject *>& 
	 */
	const std::list<GameObject *>& getChildren() const;
	/**
	 * @brief Get the Children Count object
	 * 
	 * @return int 
	 */
	int getChildrenCount() const;
	/**
	 * @brief 
	 * 
	 * @param _gameObject 
	 * @return true 
	 * @return false 
	 */
	bool removeChild(GameObject *_gameObject);
	/**
	 * @brief 
	 * 
	 */
	void cleanChildren();

	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @return true 
	 * @return false 
	 */
	bool creatGameObject(std::string _gameObjectName);
	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @return true 
	 * @return false 
	 */
	bool newGameObject(std::string _gameObjectName);
	/**
	 * @brief Get the Game Object object
	 * 
	 * @param _gameObjectName 
	 * @return GameObject* 
	 */
	GameObject *getGameObject(std::string _gameObjectName) const;
	/**
	 * @brief 
	 * 
	 * @param _name 
	 * @return true 
	 * @return false 
	 */
	bool destoryGameObject(std::string _name);
	/**
	 * @brief 
	 * 
	 * @param _component 
	 * @return true 
	 * @return false 
	 */
	bool creatComponent(Component *_component);
	/**
	 * @brief 
	 * 
	 * @param _component 
	 * @return true 
	 * @return false 
	 */
	bool newComponent(Component *_component);

	/**
	 * @brief Get the Component object
	 * 
	 * @param _name 
	 * @return Component* 
	 */
	Component *getComponent(std::string _name) const;
	/**
	 * @brief 
	 * 
	 * @param _name 
	 * @return true 
	 * @return false 
	 */
	bool destoryComponent(std::string _name);
	/**
	 * @brief 
	 * 
	 * @return std::string 
	 */
	std::string toString();
};

class TestGameObject : public CrystalEngine::Test
{
public:
	OBJECT(TestGameObject)
	TestGameObject();
	~TestGameObject();
	void run() override;
};

} // namespace CrystalEngine

#endif
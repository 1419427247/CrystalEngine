/**
 * @file Scene.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef SCENE_H
#define SCENE_H

#include "CrystalEngine/Scene/Physical.h"
#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"
#include <unordered_map>
#include <vector>

namespace CrystalEngine
{
class GameObject;
class Component;
class RigidBody;
class Collision;

class Scene : public Object
{
	friend class TestScene;
	friend class GameObject;
	friend class RigidBody;
	friend class Collision;
private:
	bool isAlive;
	std::vector<std::string> *newGameObjects;
	std::vector<std::string> *deleteGameObjects;

	std::unordered_map<std::string, GameObject *> *gameObjects;
	Physical* physical; 
	
public:
	OBJECT(Scene)
	/**
	 * @brief Construct a new Scene object
	 * 
	 */
	Scene();
	/**
	 * @brief Construct a new Scene object
	 * 
	 * @param _Physical 
	 */
	Scene(Physical* _physical);
	/**
	 * @brief Destroy the Scene object
	 * 
	 */
	~Scene();

	/**
	 * @brief 
	 * 
	 */
	void start();
	/**
	 * @brief 
	 * 
	 * @return true 
	 * @return false 
	 */
	bool update();
	/**
	 * @brief 
	 * 
	 */
	void destory();

	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @return true 
	 * @return false 
	 */
	bool newGameObject(std::string _gameObjectName);
	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @return true 
	 * @return false 
	 */
	bool creatGameObject(std::string _gameObjectName);
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
	 * @param _gameObjectName 
	 * @param _component 
	 * @return true 
	 * @return false 
	 */
	bool newComponent(std::string _gameObjectName, Component *_component);
	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @param _component 
	 * @return true 
	 * @return false 
	 */
	bool creatComponent(std::string _gameObjectName, Component *_component);
	/**
	 * @brief Get the Component object
	 * 
	 * @param _gameObjectName 
	 * @param _componentGame 
	 * @return Component* 
	 */
	Component *getComponent(std::string _gameObjectName, std::string _componentGame) const;
	/**
	 * @brief 
	 * 
	 * @param _gameObjectName 
	 * @param _name 
	 * @return true 
	 * @return false 
	 */
	bool destoryComponent(std::string _gameObjectName, std::string _name);
};


class TestScene : public CrystalEngine::Test
{
public:
	OBJECT(TestScene)
	TestScene();
	~TestScene();
	void run() override;
};

} // namespace CrystalEngine
#endif
/**
 * @file Transform.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef TRANSFORM_H
#define TRANSFORM_H

#include "CrystalEngine/Component/Component.h"

namespace CrystalEngine
{
class Vector;
/**
 * @brief 
 * 
 */
class Transform : public Component
{
private:
	/**
	 * @brief 
	 * 
	 */
	Vector *worldPosition;
	/**
	 * @brief 
	 * 
	 */
	Vector *loaclPosition;
	/**
	 * @brief 
	 * 
	 */
	Vector *worldRotate;
	/**
	 * @brief 
	 * 
	 */
	Vector *loaclRotate;
public:
	OBJECT(Transform)
	/**
	 * @brief Construct a new Transform object
	 * 
	 */
	Transform(GameObject* _gameObject);
	/**
	 * @brief Destroy the Transform object
	 * 
	 */
	~Transform();
	/**
	 * @brief Get the Position object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getPosition();
	/**
	 * @brief Get the Rotate object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getRotate();
	/**
	 * @brief Get the Local Position object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getLocalPosition();
	/**
	 * @brief Get the Local Rotate object
	 * 
	 * @return const Vector& 
	 */
	const Vector& getLocalRotate();
	/**
	 * @brief Set the Position object
	 * 
	 * @param _x 
	 * @param _y 
	 */
	void setPosition(double _x,double _y);
	/**
	 * @brief Set the Rotate object
	 * 
	 * @param _x 
	 * @param _y 
	 */
	void setRotate(double _x,double _y);
	/**
	 * @brief Set the Position object
	 * 
	 * @param _v 
	 */
	void setPosition( Vector& _v);
	/**
	 * @brief Set the Rotate object
	 * 
	 * @param _v 
	 */
	void setRotate( Vector& _v);
	/**
	 * @brief 
	 * 
	 * @return std::string 
	 */
	std::string toString();
};
} // namespace CrystalEngine
#endif
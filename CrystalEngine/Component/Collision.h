/**
 * @file Collision.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */
#ifndef COLLISHION_H
#define COLLISHION_H
#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
/**
 * @brief 
 * 
 */
class Collision : public Component
{
public:
    OBJECT(Collision)
    /**
     * @brief Construct a new Collision object
     * 
     */
    Collision();
	/**
	 * @brief Destroy the Collision object
	 * 
	 */
    ~Collision();
	/**
	 * @brief 
	 * 
	 */
    void start() override;
	/**
	 * @brief 
	 * 
	 */
    void update() override;
	/**
	 * @brief 
	 * 
	 */
	void destory() override;
};
} // namespace CrystalEngine
#endif
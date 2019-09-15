/**
 * @file Camera.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */
#ifndef CAMERA_H
#define CAMERA_H

#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Scene/Component.h"

namespace CrystalEngine
{
/**
 * @brief 
 * 
 */
class Camera : public Component
{
private:
    /**
     * @brief 
     * 
     */
    float size;

public:
    OBJECT(Camera)
	/**
	 * @brief Construct a new Camera object
	 * 
	 */
    Camera();
	/**
	 * @brief Destroy the Camera object
	 * 
	 */
    ~Camera();
};
} // namespace CrystalEngine
#endif
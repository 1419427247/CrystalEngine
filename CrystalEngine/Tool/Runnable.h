/**
 * @file Runnable.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef RUNNABLE_H
#define RUNNABLE_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Timer;
/**
 * @brief 
 * 
 */
class Runnable : public Object
{   
    friend class Timer;
    /**
     * @brief 
     * 
     */
    bool alive;
public:
    OBJECT(Runnable)
    /**
     * @brief Construct a new Runnable object
     * 
     */
    Runnable();
    /**
     * @brief Destroy the Runnable object
     * 
     */
    virtual ~Runnable();
    /**
     * @brief 
     * 
     */
    virtual void run();

    /**
     * @brief 
     * 
     * @return true 
     * @return false 
     */
    bool isAlive();
    /**
     * @brief 
     * 
     */
    void exit();
    
};
} // namespace CrystalEngine

#endif

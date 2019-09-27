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

class Runnable : public Object
{   
    bool alive;
public:
    OBJECT(Runnable)

    Runnable();

    virtual ~Runnable();

    void start();

    virtual void update();

    void destory();

    bool isAlive();
    
};
} // namespace CrystalEngine

#endif

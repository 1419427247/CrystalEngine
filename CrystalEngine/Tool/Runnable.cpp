/**
 * @file Runnable.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{
Runnable::Runnable()
{
    alive = false;
}
Runnable::~Runnable()
{
}

void Runnable::start(){
     alive = true;
}

void Runnable::update()
{
}

void Runnable::destory(){
     alive = false;
}

bool Runnable::isAlive()
{
    return alive;
}

} // namespace CrystalEngine

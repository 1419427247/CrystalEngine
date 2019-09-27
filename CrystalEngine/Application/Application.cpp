/**
 * @file Application.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */



#include "CrystalEngine/Application/Application.h"
namespace CrystalEngine
{
Application::Application()
{
}

Application::Application(World* _world)
{
    world = _world;
}

Application::~Application()
{
}
void Application::run(int _millisecond)
{
    world->start();
    Timer::runLoop(world,_millisecond);
    world->destory();
}  
} // namespace CrystalEngine
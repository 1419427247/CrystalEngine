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

#include "CrystalEngine/Application.h"

namespace CrystalEngine
{
Application::Application()
{
}

Application::Application(Scene *_scene)
{
    scene = _scene;
}

Application::~Application()
{
}
void Application::run()
{
    scene->start();
    Timer::runLoop<Scene>(scene, &Scene::update, 20);
}
} // namespace CrystalEngine
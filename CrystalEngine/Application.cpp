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
#include "CrystalEngine/Application.h"

namespace CrystalEngine
{
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
    // while (scene->update())
    // {
    //     std::this_thread::sleep_for(std::chrono::milliseconds(20));
    // }
    //Timer::runLoop<Scene>(scene->update,20);
}
} // namespace CrystalEngine
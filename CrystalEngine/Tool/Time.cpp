

#include "CrystalEngine/Tool/Time.h"
#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{

void Time::run(Runnable *_runable, int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    _runable->run();
}

void Time::start(Runnable *_runable, int _millisecond)
{
    std::thread thread = std::thread([_runable, _millisecond]() {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        _runable->run();
    });
    thread.detach();
}

void Time::runLoop(Runnable *_runable, int _millisecond)
{
    while (_runable->alive)
    {
        _runable->run();
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    }
}

void Time::startLoop(Runnable *_runable, int _millisecond)
{
    std::thread thread = std::thread([_runable, _millisecond]() {
        while (_runable->alive)
        {
            _runable->run();
            std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        }
    });
    thread.detach();
}

void Time::sleep(int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
}
} // namespace CrystalEngine
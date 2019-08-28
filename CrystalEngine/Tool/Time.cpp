#include <thread>
#include <ctime>
#include <chrono>

#include "CrystalEngine/Tool/Time.h"
#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{


Date Time::now(){
    time_t _t = time(NULL);
    tm* _tm = localtime(&_t);
    return Date{
        _tm->tm_year + 1900,
        _tm->tm_mon + 1,
        _tm->tm_mday,
        _tm->tm_hour,
        _tm->tm_min,
        _tm->tm_sec,
    };
}

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
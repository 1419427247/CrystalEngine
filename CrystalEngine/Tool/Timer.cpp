#include <thread>
#include <ctime>
#include <chrono>

#include "CrystalEngine/Tool/Timer.h"
#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{

Date Timer::now()
{
    time_t _t = time(NULL);
    tm *_tm = localtime(&_t);
    return Date{
        _tm->tm_year + 1900,
        _tm->tm_mon + 1,
        _tm->tm_mday,
        _tm->tm_hour,
        _tm->tm_min,
        _tm->tm_sec,
    };
}

void Timer::run(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->alive = true;
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    _runable->run();
    _runable->alive = false;
}

void Timer::start(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->alive = true;
    std::thread thread = std::thread([_runable, _millisecond]() {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        _runable->run();
        _runable->alive = false;
    });
    thread.detach();
}

void Timer::runLoop(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->alive = true;
    while (_runable->alive)
    {
        _runable->run();
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    }
    _runable->alive = false;
}

void Timer::startLoop(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->alive = true;
    std::thread thread = std::thread([_runable, _millisecond]() {
        while (_runable->alive)
        {
            _runable->run();
            std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        }
        _runable->alive = false;
    });
    thread.detach();
}

void Timer::run(std::function<bool()> _runable, int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    _runable();
}

void Timer::start(std::function<bool()> _runable, int _millisecond)
{
    std::thread thread = std::thread([_runable, _millisecond]() {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        _runable();
    });
    thread.detach();
}

void Timer::runLoop(std::function<bool()> _runable, int _millisecond)
{
    while (_runable())
    {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    }
}
void Timer::startLoop(std::function<bool()> _runable, int _millisecond)
{
    std::thread thread = std::thread([_runable, _millisecond]() {
        while (_runable())
        {
            std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        }
    });
    thread.detach();
}

void Timer::sleep(int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
}
} // namespace CrystalEngine
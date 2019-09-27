/**
 * @file Timer.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#include "CrystalEngine/Tool/Timer.h"
#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{

Timer::Timer()
{
    
}

void Timer::run(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->start();
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    _runable->update();
    _runable->destory();
}

void Timer::start(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->start();
    std::thread thread = std::thread([_runable, _millisecond]() {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        _runable->update();
        _runable->destory();
    });
    thread.detach();
}

void Timer::runLoop(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->start();
    while (_runable->isAlive())
    {
        _runable->update();
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
    }
    _runable->destory();
}

void Timer::startLoop(Runnable *_runable, int _millisecond)
{
    if (_runable->isAlive())
        return;
    _runable->start();
    std::thread thread = std::thread([_runable, _millisecond]() {
        while (_runable->isAlive())
        {
            _runable->update();
            std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        }
        _runable->destory();
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

double Timer::executionTime(std::function<void()> _fun){
    clock_t start = clock();
    _fun();
    return (clock() - start)/(double)CLOCKS_PER_SEC;
}


void Timer::sleep(int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
}

void Timer::yield(){
    std::this_thread::yield();
}
} // namespace CrystalEngine
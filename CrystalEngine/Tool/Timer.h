#ifndef TIME_H
#define TIME_H

#include <thread>
#include <ctime>
#include <chrono>
#include <functional>

#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{

struct Date
{
	int year;
	int month;
	int day;
	int hour;
	int minute;
	int second;
};

class Runnable;
class Timer
{
private:
public:
	static Date now();

	static void run(Runnable *_runable, int _millisecond);
	static void start(Runnable *_runable, int _millisecond);

	static void runLoop(Runnable *_runable, int _millisecond);
	static void startLoop(Runnable *_runable, int _millisecond);

	static void run(std::function<bool()> _runable, int _millisecond);
	static void start(std::function<bool()> _runable, int _millisecond);

	static void runLoop(std::function<bool()> _runable, int _millisecond);
	static void startLoop(std::function<bool()> _runable, int _millisecond);

	template <class T>
	static void run(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
		(_runable->*_fun)();
	}

	template <class T>
	static void start(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		std::thread thread = std::thread([_runable, _fun, _millisecond]() {
			std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
			(_runable->*_fun)();
		});
		thread.detach();
	}

	template <class T>
	static void runLoop(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		while ((_runable->*_fun)())
		{
			std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
		}
	}
	template <class T>
	static void startLoop(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		std::thread thread = std::thread([_runable, _fun, _millisecond]() {
			while ((_runable->*_fun)())
			{
				std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
			}
		});
		thread.detach();
	}

	static void sleep(int _millisecond);
	static void yield();
};
} // namespace CrystalEngine
#endif
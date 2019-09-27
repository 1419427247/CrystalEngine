/**
 * @file Timer.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef TIMER_H
#define TIMER_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{


class Runnable;
/**
 * @brief 
 * 
 */
class Timer : public Object
{
public:
	OBJECT(Timer);
	Timer();
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void run(Runnable *_runable, int _millisecond);

	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void start(Runnable *_runable, int _millisecond);

	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void runLoop(Runnable *_runable, int _millisecond);
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void startLoop(Runnable *_runable, int _millisecond);
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void run(std::function<bool()> _runable, int _millisecond);
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void start(std::function<bool()> _runable, int _millisecond);
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void runLoop(std::function<bool()> _runable, int _millisecond);
	/**
	 * @brief 
	 * 
	 * @param _runable 
	 * @param _millisecond 
	 */
	static void startLoop(std::function<bool()> _runable, int _millisecond);

	/**
	 * @brief 
	 * 
	 * @tparam T 
	 * @param _runable 
	 * @param _fun 
	 * @param _millisecond 
	 */
	template <class T>
	static void run(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
		(_runable->*_fun)();
	}
	/**
	 * @brief 
	 * 
	 * @tparam T 
	 * @param _runable 
	 * @param _fun 
	 * @param _millisecond 
	 */
	template <class T>
	static void start(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		std::thread thread = std::thread([_runable, _fun, _millisecond]() {
			std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
			(_runable->*_fun)();
		});
		thread.detach();
	}
	/**
	 * @brief 
	 * 
	 * @tparam T 
	 * @param _runable 
	 * @param _fun 
	 * @param _millisecond 
	 */
	template <class T>
	static void runLoop(T *_runable, bool (T::*_fun)(), int _millisecond)
	{
		while ((_runable->*_fun)())
		{
			std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
		}
	}

	/**
	 * @brief 
	 * 
	 * @tparam T 
	 * @param _runable 
	 * @param _fun 
	 * @param _millisecond 
	 */
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

	static double executionTime(std::function<void()> _fun);

	/**
	 * @brief 
	 * 
	 * @param _millisecond 
	 */
	static void sleep(int _millisecond);

	/**
	 * @brief 
	 * 
	 */
	static void yield();
};
} // namespace CrystalEngine
#endif
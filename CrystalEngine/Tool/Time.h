#ifndef TIME_H
#define TIME_H

#include <thread>
#include <ctime>
#include <chrono>
#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
class Runnable;

class Time
{
private:
public:
	static void run(Runnable *_runable, int _millisecond);
	static void start(Runnable *_runable, int _millisecond);

	static void runLoop(Runnable *_runable, int _millisecond);
	static void startLoop(Runnable *_runable, int _millisecond);

	static void sleep(int _millisecond);
};
} // namespace CrystalEngine
#endif
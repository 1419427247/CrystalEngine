#ifndef TIME_H
#define TIME_H

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

	static void run(bool (*_runable)(), int _millisecond);
	static void start(bool (*_runable)(), int _millisecond);

	static void runLoop(bool (*_runable)(), int _millisecond);
	static void startLoop(bool (*_runable)(), int _millisecond);

	static void sleep(int _millisecond);
};
} // namespace CrystalEngine
#endif
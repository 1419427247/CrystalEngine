#ifndef TIME_H
#define TIME_H

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

	static void sleep(int _millisecond);
};
} // namespace CrystalEngine
#endif
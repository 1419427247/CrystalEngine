#ifndef TIME_H
#define TIME_H
#include <thread>
#include <ctime>
#include <chrono>
namespace CrystalEngine
{
class Time
{
private:
	std::thread thread;

public:
	Time();
	~Time();
	void run(bool (*_fun)(),int _millisecond);
	void loop(bool (*_fun)(),int _millisecond);
	static void sleep(int _millisecond);
};
} // namespace CrystalEngine
#endif
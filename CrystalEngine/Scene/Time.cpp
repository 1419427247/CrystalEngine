#include "CrystalEngine/Scene/Time.h"
namespace CrystalEngine
{
Time::Time()
{
    
}
Time::~Time()
{
}
void Time::run(bool (*_fun)(),int _millisecond)
{
    
    // auto future = std::promise<bool>().get_future();
    // auto status = future.wait_for(std::chrono::milliseconds(0));

    // if (status == std::future_status::ready) {
    //     std::cout << "Thread finished" << std::endl;
    // } else {
    //     std::cout << "Thread still running" << std::endl;
    // }

    thread = std::thread([_fun, _millisecond]() {
        std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        _fun();
    });
    thread.detach();
}
void Time::loop(bool (*_fun)(),int _millisecond)
{
    thread = std::thread([_fun, _millisecond]() {
        do
        {
            std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
        }while(_fun());
    });
    thread.detach();
}
void Time::sleep(int _millisecond)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(_millisecond));
}
} // namespace CrystalEngine
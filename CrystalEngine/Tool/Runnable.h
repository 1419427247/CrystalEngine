#ifndef RUNNABLE_H
#define RUNNABLE_H
namespace CrystalEngine
{
class Timer;
class Runnable
{
    friend class Timer;
    bool alive;
public:
    Runnable();
    virtual ~Runnable();
    virtual void run();

    bool isAlive();


    void exit();
    
};
} // namespace CrystalEngine

#endif

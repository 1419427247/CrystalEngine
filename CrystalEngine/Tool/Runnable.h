#ifndef RUNNABLE_H
#define RUNNABLE_H
namespace CrystalEngine
{
class Runnable
{
public:
    bool alive;
    
    Runnable();
    virtual ~Runnable();
    virtual void run();
    
};
} // namespace CrystalEngine

#endif

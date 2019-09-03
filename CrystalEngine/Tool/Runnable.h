#ifndef RUNNABLE_H
#define RUNNABLE_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{
class Timer;
class Runnable : public Object
{
    friend class Timer;
    bool alive;
public:
    OBJECT(Runnable)

    Runnable();
    virtual ~Runnable();
    virtual void run();

    bool isAlive();
    void exit();
    
};
} // namespace CrystalEngine

#endif

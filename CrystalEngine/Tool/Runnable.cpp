#include "CrystalEngine/Tool/Runnable.h"

namespace CrystalEngine
{
Runnable::Runnable()
{
    alive = false;
}
Runnable::~Runnable()
{
}
void Runnable::run()
{
}

bool Runnable::isAlive()
{
    return alive;
}
void Runnable::exit()
{
    alive = false;
}
} // namespace CrystalEngine

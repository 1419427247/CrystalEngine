#ifndef TIME_H
#define TIME_H

#include "CrystalEngine/Tool/Object.h"

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
class Time : public Object
{
    OBJECT(Time)
    static Date now();
};
} // namespace CrystalEngine

#endif
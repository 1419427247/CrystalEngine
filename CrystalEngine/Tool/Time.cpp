#include "CrystalEngine/Tool/Time.h"

namespace CrystalEngine
{
    Date Time::now(){
        std::time_t _t = std::time(NULL);
        std::tm *_tm = std::localtime(&_t);
        return Date{
            _tm->tm_year + 1900,
            _tm->tm_mon + 1,
            _tm->tm_mday,
            _tm->tm_hour,
            _tm->tm_min,
            _tm->tm_sec,
        };
    }

} // namespace CrystalEngine

#ifndef TEST_H
#define TEST_H

#include <vector>

#include "CrystalEngine/Tool/Object.h"

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << __FILE__ << "-" << __LINE__ << ":\n" << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            error_count++;                                                                                                 \
        }                                                                                                                  \
    }

namespace CrystalEngine
{
class Test : public Object
{
public:
    OBJECT(Test)
    Test();
    virtual ~Test();
    virtual void run();

    static int error_count;
    static std::vector<CrystalEngine::Test *> instance;

    static int testBegin();
    static void testDispose();

};
} // namespace CrystalEngine

#endif
#ifndef TEST_H
#define TEST_H
#include <iostream>
#include <string>
#include <vector>

#include "CrystalEngine/Tool/Object.h"

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            error_count++;                                                                                                 \
        }                                                                                                                  \
    }

namespace CrystalEngine
{
class Test : public Object
{
    std::string name;
    
public:
    Test();
    Test(std::string _name);
    virtual ~Test();
    virtual void run();

    static int error_count;
    static std::vector<CrystalEngine::Test *> instance;

    static int testBegin();
    static void testDispose();

};
} // namespace CrystalEngine

#endif
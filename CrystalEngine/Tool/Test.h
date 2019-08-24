#ifndef TEST_H
#define TEST_H
#include <iostream>
#include <string>
#include <vector>

namespace CrystalEngine
{
class Test
{
    std::string name;

public:
    Test(std::string _name);
    virtual ~Test();
    virtual void run();
};
} // namespace CrystalEngine

extern int error_count;
extern std::vector<CrystalEngine::Test *> *instance;

extern int testBegin();
extern void testDispose();

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            error_count++;                                                                                                 \
        }                                                                                                                  \
    }

#endif
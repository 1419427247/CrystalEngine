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
    static int error_count;
    static std::vector<Test *> instance;

    static void start();
    static void dispose();

    Test(std::string _name);
    virtual ~Test();
    virtual void run();
};
int CrystalEngine::Test::error_count = 0;
std::vector<Test *> instance;
} // namespace CrystalEngine

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            CrystalEngine::Test::error_count++;                                                                            \
        }                                                                                                                  \
    };

#endif
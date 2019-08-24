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

static int error_count = 0;
static std::vector<CrystalEngine::Test *> *instance = new std::vector<CrystalEngine::Test *>();

static void start()
{
    for (CrystalEngine::Test *var : *instance)
    {
        var->run();
    }
    std::cout << "Test the function to stop running." << std::endl
              << "The number of errors is " << error_count << std::endl;
}
static void dispose()
{
    // while (!Test::instance->empty())
    // {
    //     delete Test::instance->back();
    //     Test::instance->pop_back();
    // }
    for (size_t i = 0; i < instance->size(); i++)
    {
        delete (*instance)[i];
    }
}

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            error_count++;                                                                                                 \
        }                                                                                                                  \
    };

#endif
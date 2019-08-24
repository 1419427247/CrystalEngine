#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{

Test::Test(std::string _name)
{
    name = _name;
    for (Test *var : *instance)
    {
        if (var->name == _name)
            throw this;
    }
    instance->push_back(this);
}
Test::~Test()
{
}

void Test::run()
{
}
} // namespace CrystalEngine

int error_count = 0;
std::vector<CrystalEngine::Test *> *instance = new std::vector<CrystalEngine::Test *>();
int testBegin()
{
    for (CrystalEngine::Test *var : *instance)
    {
        var->run();
    }
    std::cout << "Test the function to stop running." << std::endl
              << "The number of errors is " << error_count << std::endl;
    return error_count;
}

void testDispose()
{
    while (!instance->empty())
    {
        delete instance->back();
        instance->pop_back();
    }
    error_count = 0;
}

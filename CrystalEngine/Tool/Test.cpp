#include "CrystalEngine/Tool/Test.h"

static int error_count = 0;
static std::vector<CrystalEngine::Test *> instance;

namespace CrystalEngine
{
void Test::start()
{
    for (Test *var : instance)
    {
        var->run();
    }
    std::cout << "Test the function to stop running." << std::endl
              << "The number of errors is " << error_count << std::endl;
}
void Test::dispose()
{
    while (!instance.empty())
    {
        delete instance.back();
        instance.pop_back();
    }
    for (size_t i = 0; i < instance.size(); i++)
    {
        delete instance[i];
    }
}

Test::Test(std::string _name)
{
    name = _name;
    for (Test *var : instance)
    {
        if (var->name == _name)
            throw this;
    }
    instance.push_back(this);
}
Test::~Test()
{
}

void Test::run()
{
}
} // namespace CrystalEngine
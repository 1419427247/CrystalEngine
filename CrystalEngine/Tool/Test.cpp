#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
void Test::start()
{
    for (Test *var : *Test::instance)
    {
        var->run();
    }
    std::cout << "Test the function to stop running." << std::endl
              << "The number of errors is " << error_count << std::endl;
}
void Test::dispose()
{
    // while (!Test::instance->empty())
    // {
    //     delete Test::instance->back();
    //     Test::instance->pop_back();
    // }
    for (size_t i = 0; i < Test::instance->size(); i++)
    {
        delete (*Test::instance)[i];
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
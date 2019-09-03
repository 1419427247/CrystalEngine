#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
Test::Test(){

}
Test::Test(std::string _name)
{
    name = _name;
    for (Test *var : instance)
    {
        if (var->name == _name)
            throw;
    }
    instance.push_back(this);
}
Test::~Test()
{
}

void Test::run()
{
}


int Test::error_count = 0;

std::vector<CrystalEngine::Test *> Test::instance;

int Test::testBegin()
{
    for (CrystalEngine::Test *var : instance)
    {
        var->run();
    }
    std::cout << "Test the function to stop running." << std::endl
              << "The number of errors is " << error_count << std::endl;
    return error_count;
}

void Test::testDispose()
{
    while (!instance.empty())
    {
        delete instance.back();
        instance.pop_back();
    }
    error_count = 0;
}

} // namespace CrystalEngine

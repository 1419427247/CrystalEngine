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
    std::cout<<instance->size();
}
Test::~Test()
{
}

void Test::run()
{
}
} // namespace CrystalEngine
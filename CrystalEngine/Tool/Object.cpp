#include"CrystalEngine/Tool/Object.h"
namespace CrystalEngine
{
    std::unordered_map<std::string, Object *(*)()> Object::__objects;

    Object::Object(){

    }

    Object::~Object(){

    }

    Object* Object::instantiation(std::string _string)
    {
        return __objects[_string]();
    }

    std::string Object::toString()
    {
        #ifdef OBJECT
        return getClassName();
        #else
        throw();
        #endif
    }
}
#ifndef OBJECT_H
#define OBJECT_H

#include <unordered_map>
#include <string>

#define REGISTER(OBJECT)                                 \
    {                                                    \
        using namespace CrystalEngine;                   \
        Object::__objects[#OBJECT] = OBJECT::instantiation;\
    }

#define INSTANTIATION(OBJECT_NAME) new OBJECT_NAME()

#define OBJECT(OBJECT_NAME)                 \
public:                                     \
    static Object *instantiation()          \
    {                                       \
        return (Object *)new OBJECT_NAME(); \
    }                                       \
    virtual std::string getClassName()      \
    {                                       \
        return #OBJECT_NAME;                \
    }

namespace CrystalEngine
{
class Object
{
public:
    static std::unordered_map<std::string, Object *(*)()> __objects;

    OBJECT(Object)

    Object();

    virtual ~Object();

    static Object *instantiation(std::string _string);
    virtual std::string toString();

    template <class T>
    static T *instantiation(std::string _string)
    {
        return (T *)__objects[_string]();
    }
};
} // namespace CrystalEngine
#endif
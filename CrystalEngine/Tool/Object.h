#ifndef OBJECT_H
#define OBJECT_H

#include <unordered_map>
#include <string>

#define REGISTER(OBJECT) objects[#OBJECT] = OBJECT::instantiation

#define INSTANTIATION(OBJECT_NAME) objects[#OBJECT_NAME]()

#define OBJECT(TYPE)                 \
public:                              \
    static Object *instantiation()   \
    {                                \
        return (Object *)new TYPE(); \
    }                                \
    virtual std::string getClassName()       \
    {                                \
        return #TYPE;          \
    }

namespace CrystalEngine
{

class Object;
static std::unordered_map<std::string, Object *(*)()> objects;

class Object
{
public:
    OBJECT(Object)

    Object()
    {

    }
    virtual ~Object()
    {
    }

    template<class T>
    static T *instantiation(std::string _string)
    {
        return (T*)objects[_string]();
    }


    static Object *instantiation(std::string _string)
    {
        return objects[_string]();
    }

    virtual std::string toString()
    {
        #ifdef OBJECT
        return getClassName();
        #else
        throw();
        #endif
    }
};

} // namespace CrystalEngine
#endif
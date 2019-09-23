/**
 * @file Object.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

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
        return __getClassName();
        #else
        throw();
        #endif
    }
}
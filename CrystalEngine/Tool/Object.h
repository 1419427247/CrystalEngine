/**
 * @file Object.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef OBJECT_H
#define OBJECT_H

#define REGISTER(OBJECT)                                    \
    {                                                       \
        using namespace CrystalEngine;                      \
        Object::__objects[#OBJECT] = OBJECT::instantiation; \
    }

#define INSTANTIATION(OBJECT_NAME) new OBJECT_NAME()

#define OBJECT(OBJECT_NAME)                 \
public:                                     \
    static Object* __instantiation()          \
    {                                       \
        return (Object *)new OBJECT_NAME(); \
    }                                       \
    virtual std::string __getClassName()      \
    {                                       \
        return #OBJECT_NAME;                \
    }

#include <iostream>
#include <unordered_map>
#include <vector>
#include <list>
#include <algorithm>
#include <string>
#include <cmath>
#include <thread>
#include <ctime>
#include <chrono>
#include <functional>


namespace CrystalEngine
{
/**
 * @brief 
 * 
 */
class Object
{
public:
    /**
     * @brief 
     * 
     */
    static std::unordered_map<std::string, Object *(*)()> __objects;

    OBJECT(Object)
    /**
     * @brief Construct a new Object object
     * 
     */
    Object();
    /**
     * @brief Destroy the Object object
     * 
     */
    virtual ~Object();
    /**
     * @brief 
     * 
     * @param _string 
     * @return Object* 
     */
    static Object *instantiation(std::string _string);
    /**
     * @brief 
     * 
     * @return std::string 
     */
    virtual std::string toString();
    /**
     * @brief 
     * 
     * @tparam T 
     * @param _string 
     * @return T* 
     */
    template <class T>
    static T *__instantiation(std::string _string)
    {
        return (T *)__objects[_string]();
    }
};
} // namespace CrystalEngine
#endif
/**
 * @file Test.h
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */

#ifndef TEST_H
#define TEST_H

#include <vector>

#include "CrystalEngine/Tool/Object.h"

#define Comparison(T1, T2)                                                                                                 \
    {                                                                                                                      \
        auto var = T1;                                                                                                     \
        if (var != T2)                                                                                                     \
        {                                                                                                                  \
            std::cout << __FILE__ << "-" << __LINE__ << ":\n" << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
            error_count++;                                                                                                 \
        }                                                                                                                  \
    }

namespace CrystalEngine
{
/**
 * @brief 
 * 
 */
class Test : public Object
{
public:
    OBJECT(Test)
    /**
     * @brief Construct a new Test object
     * 
     */
    Test();
    /**
     * @brief Destroy the Test object
     * 
     */
    virtual ~Test();
    /**
     * @brief 
     * 
     */
    virtual void run();
    /**
     * @brief 
     * 
     */
    static int error_count;
    /**
     * @brief 
     * 
     */
    static std::vector<CrystalEngine::Test *> instance;
    /**
     * @brief 
     * 
     * @return int 
     */
    static int testBegin();
    /**
     * @brief 
     * 
     */
    static void testDispose();

};
} // namespace CrystalEngine

#endif
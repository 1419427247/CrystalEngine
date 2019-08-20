#ifndef TEST_H
#define TEST_H
#include <iostream>
namespace CrystalEngine
{
#define Comparison(T1, T2)                                                             \
	{                                                                                  \
		auto var = T1;                                                                 \
		if (var == T2)                                                                 \
			std::cout << "The result is correct : " << #T1 << " == " << #T2 << std::endl; \
		else                                                                           \
			std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl;   \
	}

class Tset
{
	virtual void run();
};
} // namespace CrystalEngine
#endif
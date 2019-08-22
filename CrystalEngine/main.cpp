#include "CrystalEngine.h"
#include<iostream>
//std::cout << "The result is correct : " << #T1 << " == " << #T2 << std::endl; else
#define Comparison(T1, T2)                                                                                                 \
	{                                                                                                                      \
		auto var = T1;                                                                                                     \
		if (var != T2)                                                                                                     \
			std::cout << "The result is wrong : " << #T1 << " == " << var << " And " << #T1 << " != " << #T2 << std::endl; \
	}
#define Debug(C) C().run();


class Test;
std::vector<Test *> test;

class Test
{
	std::string name;

public:
	Test(std::string _name){
        test.push_back(this);
    }
	virtual void run(){

    }
};

class GameObjectTest : public Test
{
public:
	GameObjectTest():Test("GameObjectTest"){
		
	}
	void run(){
		CrystalEngine::GameObject *obj1 = new CrystalEngine::GameObject("G1");
        CrystalEngine::GameObject *obj2 = new CrystalEngine::GameObject("G2");
        CrystalEngine::GameObject *obj3 = new CrystalEngine::GameObject("G3");

        Comparison(obj1->addChild(obj2), true)
        Comparison(obj1->addChild(obj3), true)

        Comparison(obj1->addChild(obj2), false)
        Comparison(obj1->addChild(obj3), false)
                    
        Comparison(obj2->getParten(), obj1)
        Comparison(obj3->getParten(), obj1)

        Comparison(obj1->getChildrenCount(), 2)

        Comparison(obj1->getChildren().size(), 2)

        delete obj1;
        delete obj2;
        delete obj3;
	}
};

int main()
{
    Debug(GameObjectTest)
}
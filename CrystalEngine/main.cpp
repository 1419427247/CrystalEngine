#include "CrystalEngine.h"

int main()
{
     CrystalEngine::GameObject* obj1 = new CrystalEngine::GameObject("G1");
     CrystalEngine::GameObject* obj2 = new CrystalEngine::GameObject("G2");
     CrystalEngine::GameObject* obj3 = new CrystalEngine::GameObject("G3");

    
    Comparison(obj1->addChild(obj2),true)
    Comparison(obj1->addChild(obj3),true)

    Comparison(obj1->addChild(obj2),false)
    Comparison(obj1->addChild(obj3),false)

    Comparison(obj2->getParten(),obj1)
    Comparison(obj3->getParten(),obj1)
    
    Comparison(obj1->getchi)


}
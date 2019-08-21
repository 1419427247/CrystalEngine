#include "CrystalEngine.h"

int main()
{
    CrystalEngine::Vector v1(-1,3.3);
    CrystalEngine::Vector v2(-1,3.3);
    std::cout<< (v1 == v2) <<std::endl;
    // int a=0;
    // while (true)
    // {
    //     std::cout<<a++<<std::endl;
    //     CrystalEngine::GameObject *obj1 = new CrystalEngine::GameObject("G1");
    //     CrystalEngine::GameObject *obj2 = new CrystalEngine::GameObject("G2");
    //     CrystalEngine::GameObject *obj3 = new CrystalEngine::GameObject("G3");


    //     // Comparison(obj1->addChild(obj2), true)
    //     //     Comparison(obj1->addChild(obj3), true)

    //     //         Comparison(obj1->addChild(obj2), false)
    //     //             Comparison(obj1->addChild(obj3), false)

    //     //                 Comparison(obj2->getParten(), obj1)
    //     //                     Comparison(obj3->getParten(), obj1)

    //     //                         Comparison(obj1->getChildrenCount(), 2)

    //     //                             Comparison(obj1->getChildren().size(), 2)
        

    //     delete obj1;
    //     delete obj2;
    //     delete obj3;
    // }
}
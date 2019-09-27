
#include "CrystalEngine/Application/Application.h"

using namespace CrystalEngine;
int main()
{
    while (true)
    {

    
            Command com ={"help",{"-v", "qwq", "-h"}};
            Command com2 ={"move",{"-v", "-h"}};
            com = com2;
            com2 = com;
                    /* code */
    }
            //com = com2;
    // std::cout << Timer::executionTime([](){
    //     for (size_t i = 0; i < 100000; i++)
    //     {
    //     }
    // });


    //auto fun = std::bind(_t,_args...);

    // World world;

    // GameObject obj1("qwq",&world);
    // temp t1(&obj1);

    // Application application(&world);

    // application.run(100);
    return 1;
}
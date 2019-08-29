#include "CrystalEngine/Application.h"

class Temp : public CrystalEngine::Component
{
public:
	Temp():Component("Temp"){

	}
	void start()
	{
		std::cout << "Hi";
	}
	int i = 0;
	void update()
	{
		if(i++<10)
		std::cout << "QAQ";
		else
		destoryGameObject("qwq");
	}
	void destory(){
		std::cout << "By!";
	}
};

int main()
{
	CrystalEngine::Scene* scene = new CrystalEngine::Scene(new CrystalEngine::PhysicalManager());

	scene->creatGameObject("qwq");
	scene->creatComponent("qwq",new Temp());

	CrystalEngine::Application* application = new CrystalEngine::Application(scene);

	application->run();

	return 1;
}
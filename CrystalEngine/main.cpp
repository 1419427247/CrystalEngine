#include "CrystalEngine/Application.h"

class Temp 
{
public:
	bool update()
	{
		std::cout << "QAQ";
	}
};

int main()
{
	// CrystalEngine::Scene* scene = new CrystalEngine::Scene(new CrystalEngine::PhysicalManager());

	// scene->creatGameObject("qwq");
	// scene->creatComponent("qwq",new Temp());

	// CrystalEngine::Application* application = new CrystalEngine::Application(scene);

	// application->run();

	// return 1;
	
	//CrystalEngine::Timer::run<Temp>(new Temp(),&Temp::update,100);
	CrystalEngine::Timer::runLoop<Temp>(new Temp(),&Temp::update,100);
}
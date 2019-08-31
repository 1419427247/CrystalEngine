#include "CrystalEngine/Application.h"

class Temp : public CrystalEngine::Component
{
public:
	Temp() : Component("Temp")
	{
	}
	void start()
	{
		std::cout << "Hi";
	}
	int i = 0;
	void update()
	{
		std::cout << gameObject->transform->position->getX() << "," << gameObject->transform->position->getY() << std::endl;
		gameObject->transform->position->set(0,0);
			// destoryGameObject("qwq");
	}
	void destory()
	{
		std::cout << "By!";
	}
};

int main()
{
	CrystalEngine::Scene *scene = new CrystalEngine::Scene(new CrystalEngine::Box2dPhysical());

	scene->creatGameObject("qwq");
	scene->creatComponent("qwq", new CrystalEngine::RigidBody());
	scene->creatComponent("qwq", new Temp());

	CrystalEngine::Application *application = new CrystalEngine::Application(scene);

	application->run();

	return 1;
}
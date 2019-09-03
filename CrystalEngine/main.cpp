#include "CrystalEngine/Application.h"
#include "Box2D/Box2D.h"
using namespace CrystalEngine;

class Temp : public Component
{
public:
	OBJECT(Temp)
	RigidBody *r;
	void start()
	{
		r = (RigidBody *)getComponent("Temp");
		r->setType(BodyType::dynamicBody);
		std::cout << "Hi" << std::endl;
	}
	void update()
	{
		Vector v(0, 0);
		if (gameObject->transform->position->getY() < -30)
			r->setTransform(v, 0);
		std::cout << gameObject->transform->position->getX() << "," << gameObject->transform->position->getY() << std::endl;
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
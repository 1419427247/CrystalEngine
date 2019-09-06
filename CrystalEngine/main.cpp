#include<iostream>

#include "CrystalEngine/Application.h"
#include "Box2D/Box2D.h"


class Temp : public CrystalEngine::Component
{
public:
	OBJECT(Temp)
	CrystalEngine::RigidBody *r;
	void start()
	{
		r = (CrystalEngine::RigidBody *)getComponent("Temp");
		r->setType(CrystalEngine::BodyType::dynamicBody);
		std::cout << "Hi" << std::endl;
	}
	void update()
	{
		CrystalEngine::Vector v(0, 0);
		if (gameObject->transform->getPosition().getY() < -30)
			r->setTransform(v, VECTOR_DOWN);
		std::cout << gameObject->transform->toString() << std::endl;
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
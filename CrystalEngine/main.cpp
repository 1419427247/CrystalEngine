// #include "CrystalEngine/Application.h"
// #include "Box2D/Box2D.h"
// int main()
// {

// 	// do
// 	// {
// 	// 	testDispose();
// 	// 	new CrystalEngine::TestGameObject();
// 	// } while (!testBegin());
// }

#include "Box2D/Box2D.h"
#include <iostream>

int main()
{
	b2Vec2 gravity(0.0f, -10.0f);

	b2World world(gravity);

	b2BodyDef bodyDef;
	bodyDef.position.Set(1, 3);
	bodyDef.type = b2BodyType::b2_dynamicBody;

	b2CollidePolygons
	

	b2Body *box = world.CreateBody(&bodyDef);

	world.Step(0.02, 10, 2);

	std::cout << box->GetPosition().y << std::endl;

	world.Step(0.02, 10, 2);

	std::cout << box->GetPosition().y << std::endl;
	std::cout << bodyDef.position.y << std::endl;
	return 0;
}

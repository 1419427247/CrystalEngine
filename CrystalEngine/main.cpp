#include "CrystalEngine/Application.h"

class TestGameObject : public CrystalEngine::Test
{
public:
	TestGameObject() : Test("TestGameObject")
	{
	}
	~TestGameObject(){

	}
	void run()
	{
		CrystalEngine::GameObject *obj1 = new CrystalEngine::GameObject("G1");
		CrystalEngine::GameObject *obj2 = new CrystalEngine::GameObject("G2");
		CrystalEngine::GameObject *obj3 = new CrystalEngine::GameObject("G3");



		Comparison(obj1->addChild(obj2), true)
		Comparison(obj1->addChild(obj3), true)

		Comparison(obj1->addChild(obj2), true)
		Comparison(obj1->addChild(obj3), false)

		Comparison(obj2->getParten(), obj1)
		Comparison(obj3->getParten(), obj1)

		Comparison(obj1->getChildrenCount(), 2)
		Comparison(obj1->getChildren().size(), 2)

		delete obj1;
		delete obj2;
		delete obj3;
	}
}*testGameObject = new TestGameObject();

int main()
{
    // CrystalEngine::Test::start();
    // CrystalEngine::Test::dispose();

    std::cout<<CrystalEngine::Test::error_count++;
}
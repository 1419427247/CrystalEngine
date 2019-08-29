#include "CrystalEngine/Application.h"
#include "Box2D/Box2D.h"

class a : public CrystalEngine::Runnable
{
public:
	int i = 0;
	a()
	{
	}
	void run()
	{
		if (i++ < 10)
			std::cout << "qwq";
		else
			exit();
	}
};


class Temp : public CrystalEngine::Component{
	public:
	Temp():Component("Temp"){

	}
	void start(){

	}
	void update()
	{
		
	}
	void destory(){

	}
};

int main()
{
	// do
	// {
	// 	testDispose();
	// 	new CrystalEngine::TestScene();
	// } while (!testBegin());
	//CrystalEngine::Scene* scene = new CrystalEngine::Scene();
	CrystalEngine::Runnable *r = new a();
	CrystalEngine::Time t;
	t.startLoop(r, 1000);

	while (r->isAlive())
		;
}
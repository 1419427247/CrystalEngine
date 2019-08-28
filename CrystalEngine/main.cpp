#include "CrystalEngine/Application.h"
#include "Box2D/Box2D.h"
int main()
{
	do
	{
		testDispose();
		new CrystalEngine::TestScene();
	} while (!testBegin());
}
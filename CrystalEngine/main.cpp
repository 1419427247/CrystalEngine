#include "CrystalEngine/Application.h"

int main()
{
	do
	{
		testDispose();
		new CrystalEngine::TestGameObject();
	} while (!testBegin());
}
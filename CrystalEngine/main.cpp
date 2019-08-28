#include "CrystalEngine/Application.h"
#include "Box2D/Box2D.h"

class a{
	public:
	bool print(){
		std::cout<<"qwq";
	}
};
int main()
{
	// do
	// {
	// 	testDispose();
	// 	new CrystalEngine::TestScene();
	// } while (!testBegin());
	CrystalEngine::Date date= CrystalEngine::Time::now();
	std::cout << date.year <<date.month << date.day << date.hour << date.minute << date.second;
}
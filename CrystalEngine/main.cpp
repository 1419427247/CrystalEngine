/**
 * @file main.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 程序的主入口
 * @version 0.1
 * @date 2019年09月07日
 *
 * @copyright Copyright (c) 2019
 *
 */
#include "CrystalEngine/Application.h"


class Temp : public CrystalEngine::Component
{
public:
	OBJECT(Temp)
	CrystalEngine::GameObject *g;
	void start()
	{
		std::cout << "Hi~~" <<std::endl;
	}
	void update()
	{
		destoryGameObject("qwq");
		newGameObject("qwq");
	}
	void destory()
	{
		std::cout << "By!";
	}
};

int main()
{
	CrystalEngine::Scene scene = CrystalEngine::Scene(new CrystalEngine::Box2dPhysical());

	scene.creatGameObject("qwq");

	scene.creatComponent("qwq", new Temp());

	CrystalEngine::Application application = CrystalEngine::Application(scene);

	application.run(20);

	return 1;
}
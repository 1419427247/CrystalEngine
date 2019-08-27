#ifndef COLLISHION_H
#define COLLISHION_H
#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
// enum CollisionTye{

// }
class Collision : public Component
{
public:
    Collision();
    ~Collision();

    void start() override;
    void update() override;
	void destory() override;
};
} // namespace CrystalEngine
#endif
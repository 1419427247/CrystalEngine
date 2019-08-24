#include "CrystalEngine/Component/Transform.h"

namespace CrystalEngine
{
Transform::Transform() : Component("Transform")
{
    position = new Vector();
    rotate = new Vector();
}

Transform::Transform(Transform& _t): Component("Transform"){
    position = new Vector(*_t.position);
    rotate = new Vector(*_t.rotate);
}

Transform::~Transform()
{
}
} // namespace CrystalEngine
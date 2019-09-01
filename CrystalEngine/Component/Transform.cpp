#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Component/Vector.h"

namespace CrystalEngine
{
Transform::Transform() : Component("Transform")
{
    position = new Vector();
    rotate = 0;
}

Transform::Transform(Transform& _t): Component("Transform"){
    position = new Vector(*_t.position);
    rotate = _t.rotate;
}

Transform::~Transform()
{
    delete position;
}

} // namespace CrystalEngine
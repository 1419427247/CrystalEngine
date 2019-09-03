#include "CrystalEngine/Component/Transform.h"
#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{
Transform::Transform()
{
    position = new Vector();
    rotate = 0;
}

Transform::Transform(Transform& _t){
    position = new Vector(*_t.position);
    rotate = _t.rotate;
}

Transform::~Transform()
{
    delete position;
}

} // namespace CrystalEngine
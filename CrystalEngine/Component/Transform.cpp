#include "CrystalEngine/Component/Transform.h"

namespace CrystalEngine
{
Transform::Transform() : Component("Transform")
{
    position = new Vector();
    rotate = new Vector(1,0);
}

Transform::Transform(Transform& _t): Component("Transform"){
    position = new Vector(*_t.position);
    rotate = new Vector(*_t.rotate);
}

Transform::~Transform()
{
    delete position;
    delete rotate;
}

double Transform::getAngle(){
    return atan(rotate->getY()/rotate->getX());
}

} // namespace CrystalEngine
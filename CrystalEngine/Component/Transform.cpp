#include "CrystalEngine/Scene/GameObject.h"

#include "CrystalEngine/Component/Transform.h"

#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{
Transform::Transform()
{
    worldPosition = new Vector();
    worldRotate = new Vector(1.0, 0.0);

    loaclPosition = new Vector();
    loaclRotate = new Vector(1.0, 0.0);
}

Transform::Transform(const Transform &_t)
{
    worldPosition = new Vector(_t.worldPosition->getX(), _t.worldPosition->getY());
    worldRotate = new Vector(_t.worldRotate->getX(), _t.worldRotate->getY());

    loaclPosition = new Vector(_t.loaclPosition->getX(), _t.loaclPosition->getY());
    loaclRotate = new Vector(_t.loaclRotate->getX(), _t.loaclRotate->getY());
}

Transform::~Transform()
{
    delete worldPosition;
    delete loaclPosition;
    delete worldRotate;
    delete loaclRotate;
}

const Vector &Transform::getPosition()
{
    return *worldPosition;
}

const Vector &Transform::getRotate()
{
    return *worldRotate;
}

const Vector &Transform::getLocalPosition()
{
    return *loaclPosition;
}

const Vector &Transform::getLocalRotate()
{
    return *loaclPosition;
}

void Transform::setPosition(double _x,double _y){
     worldPosition->set(_x,_y);

    if(gameObject->getParten()){
        *loaclPosition = Vector(_x,_y) - *(gameObject->getParten()->transform->worldPosition);
    }
}
void Transform::setRotate(double _x,double _y){
    worldRotate->set(_x,_y);
}

void Transform::setPosition(Vector &_v)
{
    worldPosition->set(_v);

    if(gameObject->getParten()){
        *loaclPosition = _v - *(gameObject->getParten()->transform->worldPosition);
    }
}

void Transform::setRotate(Vector &_v)
{
    worldRotate->set(_v);
}

} // namespace CrystalEngine
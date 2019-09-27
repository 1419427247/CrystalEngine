/**
 * @file Transform.cpp
 * @author iPad水晶 (1419427247@qq.com)
 * @brief 
 * @version 0.1
 * @date 2019年09月07日
 * 
 * @copyright Copyright (c) 2019
 * 
 */
#include "CrystalEngine/GameObject/GameObject.h"

#include "CrystalEngine/Component/Transform.h"

#include "CrystalEngine/Tool/Vector.h"

namespace CrystalEngine
{
Transform::Transform(GameObject* _gameObject):Component(_gameObject)
{
    worldPosition = new Vector();
    worldRotate = new Vector(1.0, 0.0);

    loaclPosition = new Vector();
    loaclRotate = new Vector(1.0, 0.0);
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

std::string Transform::toString(){
   
    return std::to_string(worldPosition->getX()) 
    + "," 
    + std::to_string(worldPosition->getY()) 
    + ","
    + std::to_string(std::tan(worldRotate->getY()/worldRotate->getX()));
}

} // namespace CrystalEngine
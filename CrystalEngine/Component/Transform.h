#ifndef TRANSFORM_H
#define TRANSFORM_H
#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Scene/Component.h"

namespace CrystalEngine
{
class Vector;
class Transform : public Component
{
private:
	Vector *worldPosition;
	Vector *loaclPosition;
	Vector *worldRotate;
	Vector *loaclRotate;
public:
	OBJECT(Transform)

	Transform();
	Transform(const Transform &_t);
	~Transform();

	const Vector& getPosition();
	const Vector& getRotate();

	const Vector& getLocalPosition();
	const Vector& getLocalRotate();

	void setPosition(double _x,double _y);
	void setRotate(double _x,double _y);

	void setPosition( Vector& _v);
	void setRotate( Vector& _v);

	std::string toString();
};
} // namespace CrystalEngine
#endif
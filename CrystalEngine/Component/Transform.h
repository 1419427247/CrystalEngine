#ifndef TRANSFORM_H
#define TRANSFORM_H
#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Scene/Component.h"

namespace CrystalEngine
{
class Vector;
class Transform : public Component
{
public:
	OBJECT(Transform)

	Vector *position;
	double rotate;
	Transform();
	Transform(Transform &_t);
	~Transform();

};
} // namespace CrystalEngine
#endif
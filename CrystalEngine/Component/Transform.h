#ifndef TRANSFORM_H
#define TRANSFORM_H
#include "CrystalEngine/Tool/Test.h"
#include "CrystalEngine/Scene/Component.h"
#include "CrystalEngine/Component/Vector.h"

namespace CrystalEngine
{
class Transform : public Component
{
public:
	Vector *position;
	Vector *rotate;
	Transform();
	Transform(Transform& _t);
	~Transform();
};
} // namespace CrystalEngine
#endif
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
	Transform();
	~Transform();
};
} // namespace CrystalEngine
#endif
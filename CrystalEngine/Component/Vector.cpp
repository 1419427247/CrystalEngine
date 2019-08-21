#include <math.h>
#include "CrystalEngine/Component/Vector.h"
namespace CrystalEngine
{

double Vector::distance(Vector *_v1, Vector *_v2)
{
	return sqrt(fabs((_v1->x - _v2->x) * (_v1->y - _v2->y)));
}

Vector::Vector()
{
	x = 0;
	y = 0;
}

Vector::Vector(double _x, double _y)
{
	x = _x;
	y = _y;
}

Vector::~Vector()
{
}

double Vector::getX()
{
	return x;
}
double Vector::getY()
{
	return y;
}

double Vector::length()
{
	return sqrt(x * x + y * y);
}

void Vector::normalized()
{
	if (x == 0 && y == 0)
		return;
	if (y > x)
	{
		x = x / y;
		y = 1;
	}
	else
	{
		y = y / x;
		x = 1;
	}
}

} // namespace CrystalEngine
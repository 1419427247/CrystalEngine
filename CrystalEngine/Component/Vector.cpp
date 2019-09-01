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

Vector::Vector(const Vector* _v)
{
	x = _v->x;
	y = _v->y;
}

Vector::Vector(const Vector &_v)
{
	x = _v.x;
	y = _v.y;
}

Vector::Vector(double _x, double _y)
{
	x = _x;
	y = _y;
}

Vector::~Vector()
{
}

void Vector::set(double _x, double _y){
x = _x;
y = _y;
}

double Vector::getX() const
{
	return x;
}
double Vector::getY() const
{
	return y;
}

double Vector::length() const
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

bool Vector::operator==(Vector _v) const
{
	return x == _v.x && y == _v.y;
}

} // namespace CrystalEngine
#include "CrystalEngine/Tool/Vector.h"
#include<stdexcept>
#include <cmath>

#define PI acos(-1)

namespace CrystalEngine
{

double Vector::distance(Vector *_v1, Vector *_v2)
{
	return sqrt(std::fabs((_v1->x - _v2->x) * (_v1->y - _v2->y)));
}

Vector::Vector()
{
	x = 0;
	y = 0;
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

void Vector::set(const Vector &_v)
{
	x = _v.x;
	y = _v.y;
}

void Vector::set(double _x, double _y)
{
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
	return std::sqrt(x * x + y * y);
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

double Vector::toAngle() const{
	try{
		if(x==0 && y == 0){
			throw std::runtime_error("Invalid angle");
		}
	}catch(const std::runtime_error& e){
		return 0;
	}
	if(x==0){
		return y>0?PI/2.0:2.0*PI/3.0;
	}
	return std::tan(y/x);
}

Vector Vector::operator+(const Vector &_v)
{
	return Vector(this->x + _v.x, this->y + _v.y);
}

Vector Vector::operator-(const Vector &_v) 
{
	return Vector(this->x - _v.x, this->y - _v.y);
}

bool Vector::operator==(const Vector &_v)
{
	return x == _v.x && y == _v.y;
}

} // namespace CrystalEngine
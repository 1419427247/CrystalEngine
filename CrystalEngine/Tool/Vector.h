#ifndef VECTOR_H
#define VECTOR_H

#include "CrystalEngine/Tool/Object.h"
#include "CrystalEngine/Tool/Test.h"

namespace CrystalEngine
{
class Vector : public Object
{
	double x;
	double y;

public:
	OBJECT(Vector)

	static double distance(Vector *_v1, Vector *_v2);

	Vector();
	Vector(const Vector& _v);
	Vector(double _x, double _y);
	~Vector();

	void set(const Vector& _v);
	void set(double _x, double _y);

	double getX() const;
	double getY() const;

	double length() const;

	void normalized();

	double toAngle() const;

	Vector operator+(const Vector& _v) ;
	Vector operator-(const Vector& _v) ;
	bool operator==(const Vector& _v) ;
};
#define VECTOR_UP CrystalEngine::Vector(0, 1)
#define VECTOR_DOWN CrystalEngine::Vector(0, -1)
#define VECTOR_LEFT CrystalEngine::Vector(-1, 0)
#define VECTOR_RIGHT CrystalEngine::Vector(1, 0)
} // namespace CrystalEngine
#endif
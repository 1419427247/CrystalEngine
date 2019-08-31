#ifndef VECTOR_H
#define VECTOR_H

#include "CrystalEngine/Tool/Test.h"
#include <math.h>

namespace CrystalEngine
{
class Vector
{
	double x;
	double y;

public:
	static double distance(Vector *_v1, Vector *_v2);

	Vector();
	Vector(Vector& _v);
	Vector(double _x, double _y);
	~Vector();

	void set(double _x, double _y);

	double getX() const;
	double getY() const;

	double length() const;

	void normalized();

	bool operator==(Vector _v) const;
};
#define VECTOR_UP CrystalEngine::Vector(0, 1)
#define VECTOR_DOWN CrystalEngine::Vector(0, -1)
#define VECTOR_LEFT CrystalEngine::Vector(-1, 0)
#define VECTOR_RIGHT CrystalEngine::Vector(1, 0)
} // namespace CrystalEngine
#endif
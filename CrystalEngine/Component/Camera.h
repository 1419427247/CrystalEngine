#ifndef CAMERA_H
#define CAMERA_H
#include "CrystalEngine/Scene/Component.h"
namespace CrystalEngine
{
class Camera : public Component
{
private:
    float size;

public:
    Camera();
    ~Camera();
};
} // namespace CrystalEngine
#endif
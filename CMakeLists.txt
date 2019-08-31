cmake_minimum_required(VERSION 3.10.2)

project(CrystalEngine)

include_directories(.)

aux_source_directory(./CrystalEngine CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Component CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Scene CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Tool CrystalEngine_SRC_LIST)

add_compile_options(-std=c++11)

include_directories(./Library/Box2D-master)

add_subdirectory(./Library/Box2D-master)


add_executable(demo ${CrystalEngine_SRC_LIST})

target_link_libraries(demo Box2D)
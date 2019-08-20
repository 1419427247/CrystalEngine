cmake_minimum_required(VERSION 3.10.2)

project(CrystalEngine)

SET(CMAKE_BUILD_TYPE "Debug")

SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g2 -ggdb")

SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O3 -Wall")

include_directories(.)

aux_source_directory(./CrystalEngine CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Component CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Scene CrystalEngine_SRC_LIST)

aux_source_directory(./CrystalEngine/Tool CrystalEngine_SRC_LIST)

add_compile_options(-std=c++11)

add_executable(demo ${CrystalEngine_SRC_LIST})
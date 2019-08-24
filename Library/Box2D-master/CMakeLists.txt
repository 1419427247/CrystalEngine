include_directories(.)

aux_source_directory(./Box2D Box2D_SRC_LIST)

aux_source_directory(./Box2D/Collision Box2D_SRC_LIST)

aux_source_directory(./Box2D/Collision/Shapes Box2D_SRC_LIST)

aux_source_directory(./Box2D/Common Box2D_SRC_LIST)

aux_source_directory(./Box2D/Dynamics Box2D_SRC_LIST)

aux_source_directory(./Box2D/Dynamics/Contacts Box2D_SRC_LIST)

aux_source_directory(./Box2D/Dynamics/Joints Box2D_SRC_LIST)

aux_source_directory(./Box2D/Rope Box2D_SRC_LIST)

add_library(Box2D ${Box2D_SRC_LIST})


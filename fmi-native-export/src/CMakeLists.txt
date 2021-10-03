
include_directories(${CMAKE_SOURCE_DIR}/include)

set(sources
    "cppfmu_cs.cpp"
    "fmi_functions.cpp"
    "SlaveInstance.cpp"
)

add_library(fmu4j ${sources})
target_include_directories(fmu4j
        PRIVATE
        "${JNI_INCLUDE_DIRS}"
        "${CMAKE_CURRENT_SOURCE_DIR}"
)
target_link_libraries(fmu4j PRIVATE "${JNI_LIBRARIES}")

if (WIN32)
    set_target_properties(fmu4j
            PROPERTIES
            RUNTIME_OUTPUT_DIRECTORY_RELEASE "${CMAKE_SOURCE_DIR}/../fmu-builder/src/main/resources/binaries/win64"
            )
elseif (UNIX)
    set_target_properties(fmu4j
            PROPERTIES
            LIBRARY_OUTPUT_DIRECTORY "${CMAKE_SOURCE_DIR}/../fmu-builder/src/main/resources/binaries/linux64"
            )
endif ()

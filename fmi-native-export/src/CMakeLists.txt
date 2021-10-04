
include_directories(${CMAKE_SOURCE_DIR}/include)

set(sources
    "cppfmu_cs.cpp"
    "fmi_functions.cpp"
    "SlaveInstance.cpp"
)

add_library(fmu4j ${sources})
target_compile_features(fmu4j PUBLIC "cxx_std_17")
target_include_directories(fmu4j
        PRIVATE
        "${JNI_INCLUDE_DIRS}"
        "${CMAKE_CURRENT_SOURCE_DIR}"
)
target_link_libraries(fmu4j PRIVATE "${JNI_LIBRARIES}")

if (WIN32)
    set_target_properties(fmu4j
            PROPERTIES
            RUNTIME_OUTPUT_DIRECTORY_RELEASE "${CMAKE_BINARY_DIR}/bin"
            )
elseif (UNIX)
    set_target_properties(fmu4j
            PROPERTIES
            LIBRARY_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin"
            )
endif ()

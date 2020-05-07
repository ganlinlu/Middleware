cmake_minimum_required(VERSION 3.15)
project(CORBACProject)

set(CMAKE_CXX_STANDARD 14)

# 发现并使用omniidl编译所有的idl文件
message("发现并使用omniidl编译所有的idl文件")
file(GLOB_RECURSE FILE_LIST "*.idl")
foreach(src ${FILE_LIST})
    message("发现idl文件: " ${src})
    execute_process(COMMAND omniidl -C${PROJECT_SOURCE_DIR} -bcxx ${src})
endforeach()

add_executable(CORBACProject main.cpp ManagerCClient.cpp ManagerCClient.h DataServiceSK.cc DataService.hh DataService.idl)

target_link_libraries(CORBACProject libomnithread.so libomniORB4.so libomniDynamic4.so libomniCodeSets4.so libCOS4.so libCOSDynamic4.so)

# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/custom/Jetbrains/clion-2019.3.4/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /usr/local/custom/Jetbrains/clion-2019.3.4/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /workspace/CORBACProject

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /workspace/CORBACProject/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/wfdb_demo.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/wfdb_demo.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/wfdb_demo.dir/flags.make

CMakeFiles/wfdb_demo.dir/main.cpp.o: CMakeFiles/wfdb_demo.dir/flags.make
CMakeFiles/wfdb_demo.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/workspace/CORBACProject/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/wfdb_demo.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/wfdb_demo.dir/main.cpp.o -c /workspace/CORBACProject/main.cpp

CMakeFiles/wfdb_demo.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/wfdb_demo.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /workspace/CORBACProject/main.cpp > CMakeFiles/wfdb_demo.dir/main.cpp.i

CMakeFiles/wfdb_demo.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/wfdb_demo.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /workspace/CORBACProject/main.cpp -o CMakeFiles/wfdb_demo.dir/main.cpp.s

# Object files for target wfdb_demo
wfdb_demo_OBJECTS = \
"CMakeFiles/wfdb_demo.dir/main.cpp.o"

# External object files for target wfdb_demo
wfdb_demo_EXTERNAL_OBJECTS =

wfdb_demo: CMakeFiles/wfdb_demo.dir/main.cpp.o
wfdb_demo: CMakeFiles/wfdb_demo.dir/build.make
wfdb_demo: CMakeFiles/wfdb_demo.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/workspace/CORBACProject/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable wfdb_demo"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/wfdb_demo.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/wfdb_demo.dir/build: wfdb_demo

.PHONY : CMakeFiles/wfdb_demo.dir/build

CMakeFiles/wfdb_demo.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/wfdb_demo.dir/cmake_clean.cmake
.PHONY : CMakeFiles/wfdb_demo.dir/clean

CMakeFiles/wfdb_demo.dir/depend:
	cd /workspace/CORBACProject/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /workspace/CORBACProject /workspace/CORBACProject /workspace/CORBACProject/cmake-build-debug /workspace/CORBACProject/cmake-build-debug /workspace/CORBACProject/cmake-build-debug/CMakeFiles/wfdb_demo.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/wfdb_demo.dir/depend

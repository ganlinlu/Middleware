# 运行环境

|   软件   |                        版本                        |
| :------: | :------------------------------------------------: |
| 操作系统 |                 Ubuntu Kylin 20.04                 |
|   Java   |            openjdk version "1.8.0_252"             |
|   g++    |     gcc version 9.3.0 (Ubuntu 9.3.0-10ubuntu2)     |
|  MySQL   | Ver 8.0.19-0ubuntu5 for Linux on x86_64 ((Ubuntu)) |
| omniidl  |                omniidl version 1.0                 |
|   iidl   |      IDL-to-Java 编译器 (可移植), 版本 "3.2"       |

# 运行方法

## 服务器端运行方法

服务器端使用ideaIU编写，包含./CORBAProject中。可以直接使用ideaIU打开并且运行。但必须确保计算机上安装了MySQL8.0以上版本的数据库，且在启动服务器程序前已经启动了orbd服务。并且服务器端的运行参数应当与orbd服务的保持一致。

orbd启动命令：

```shell
sudo nohup orbd -ORBInitialHost localhost -ORBInitialPort 5001 &
```

## 客户端运行方法

### Java客户端运行方法

Java客户端使用ideaIU编写，包含在./CORBAProject中。可以直接使用ideaIU打开并且运行。但必须确保服务端程序已经启动，并且客户端的运行参数应当与服务器程序的保证一致。

### C++客户端运行方法

C++客户端使用CLion编写，包含在./CORBACProject中。可以直接使用CLion打开并运行。但是CLion的编译与项目管理使用了cmake。所以，在保证omiORB配置正确后，可以直接在命令行中直接编译运行。但必须确保服务端程序已经启动，并且客户端的运行参数在逻辑上应当与服务器程序的保证一致。

C++客户端运行参数：

```shell
./${ProgramName} -ORBInitRef NameService=corbaloc::localhost:5001/NameService
```


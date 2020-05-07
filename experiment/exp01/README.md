##### RPC部分的使用方法

###### 编译环境

1. GCC: gcc version 9.2.1 20191008 (Ubuntu 9.2.1-9ubuntu2)
2. RPCGEN: rpcgen (Ubuntu GLIBC 2.30-0ubuntu2.1) 2.30
3. RPCBIND: 1.2.5-6 (amd64)

###### 运行方法

进入mathService目录中，先运行服务端程序mathServer：“./mathServer”。然后运行客户端程序mathClient：“./mathClient 127.0.0.1”，再根据输出的提示依次输入数据。

##### RMI部分的使用方法

###### 运行环境

1. javac: javac 1.8.0_242
2. java: openjdk version "1.8.0_242"
3. rmic: openjdk version "1.8.0_242"

###### 运行方法

可以直接在IDEA中打开RMIPROJECT目录，然后运行类：ServerService.java和Client.java。

也可以进入目录RMIPROJECT/out/production/RMIPROJECT中，使用命令运行ServerService.class和Client.class。


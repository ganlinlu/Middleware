//
// Created by ganlin on 2020/5/2.
//

#include <iostream>
#include "ManagerCClient.h"

ManagerCClient::ManagerCClient(int argc, char **argv) {
//  std:cout << argc << endl;
  if (argc - 1 != 2 && argc - 1 != 4){
    std::cerr << "输入的参数不足，无法启动客户端！" << std::endl;
    exit(EXIT_FAILURE);
  }

  CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);
  CORBA::Object_var objRef = orb->resolve_initial_references("NameService");
  CosNaming::NamingContext_var ncRef = CosNaming::NamingContext::_narrow(objRef);

  if (CORBA::is_nil(ncRef)) {
    std::cerr << "Can't access to the NameService!" << std::endl;
    exit(EXIT_FAILURE);
  }

  CosNaming::Name name;
  name.length(1);
  name[0].id = CORBA::string_dup("DataService");
  name[0].kind = CORBA::string_dup("");
  objRef = ncRef->resolve(name);

  this->sendMesg = DataService::DataTransform::_narrow(objRef);
  if(CORBA::is_nil(sendMesg)) {
    std::cerr << "Narrow error" << std::endl;
    exit(EXIT_FAILURE);
  }
  this->mesg.ID = "null";
  this->mesg.StudentNumber = "null";
  this->mesg.Classes = "null";
  this->mesg.score = "null";
}

void ManagerCClient::inputRecord() {
  std::cout << "请选择你要进行的操作：0：查询; 1：插入" << std::endl;
  int order = 2;
  std::cin >> order;
  string a, b, c, d;
  switch (order) {
    case 0:
      this->mesg.isInsert = false;
      this->mesg.ID = "null";
      this->mesg.StudentNumber = "null";
      this->mesg.Classes = "null";
      this->mesg.score = "null";
      break;
    case 1:
      std::cout << "请依次输入：ID StudentNumber Classes score;" << std::endl;
      this->mesg.isInsert = true;
      std::cin >> a >> b >> c >> d;
      this->mesg.ID = a.data();
      this->mesg.StudentNumber = b.data();
      this->mesg.Classes = c.data();
      this->mesg.score = d.data();
      break;
    default:
      std::cerr << "错误的指令！！" << std::endl;
      break;
  }

}

void ManagerCClient::DataTran() {
  std::cout << "开始传送数据：" << std::endl;
  string result = sendMesg->sendData(this->mesg);
  std::cout << "处理结果：\n" << result << endl;
}

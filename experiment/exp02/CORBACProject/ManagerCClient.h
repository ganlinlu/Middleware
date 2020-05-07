//
// Created by ganlin on 2020/5/2.
//

#ifndef CORBACPROJECT_MANAGERCCLIENT_H
#define CORBACPROJECT_MANAGERCCLIENT_H

#include "DataService.hh"
#include <omniORB4/CORBA.h>
#include <omniORB4/Naming.hh>
#include <string>

using namespace std;

class ManagerCClient {
public:
  ManagerCClient(int argc, char** argv);
  void inputRecord();
  void DataTran();
private:
  DataService::_cxx_operator  mesg;
  DataService::DataTransform_var sendMesg;
};


#endif //CORBACPROJECT_MANAGERCCLIENT_H

#include <iostream>
#include "ManagerCClient.h"

int main(int argc, char **argv) {

    ManagerCClient * m2 = new ManagerCClient(argc, argv);
    m2->inputRecord();
    m2->DataTran();

    return 0;
}

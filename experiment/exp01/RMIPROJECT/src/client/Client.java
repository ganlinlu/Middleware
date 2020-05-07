package client;

import data.Data;
import server.DataService;

import java.rmi.RMISecurityManager;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * <h3>RMIPROJECT</h3>
 * <p>用以实现RMI客户端</p>
 *
 * @author : ganlin
 * @date : 2020-03-19 17:58
 **/
public class Client {
  Data userInput = new Data();
  DataService dbServer = null;

  /**
   * @MethodName Client
   * @author ganlin
   * @Description 默认的构造函数用来执行绑定操作。
   * @Date 2020/3/19 下午6:28
   */
  public Client(){
    try {
      dbServer = (DataService) Naming.lookup("rmi://127.0.0.1:1111/db1");
    } catch (NotBoundException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  /**
   * @MethodName inputInfo
   * @author ganlin
   * @Description 获取用户从控制台输入的数据
   * @Date 2020/3/19 下午6:31
   *
   * @return void
   */
  public void inputInfo() {
    Scanner sc = new Scanner(System.in);
    System.out.println("请选择你的操作：0: 查询, 1: 插入, 2: 创建表");
    int type = sc.nextInt();

    switch (type) {
      case 0:
        userInput.type = userInput.QUERY;
        System.out.println("请输入要查询的表名：");
        userInput.tableName = sc.next();
        userInput.dataElements = userInput.typeElements = null;
        break;
      case 1:
        userInput.type = userInput.INSERT;
        System.out.println("请输入要插入记录的表名：");
        userInput.tableName = sc.next();
        System.out.println("请输入对应格式的信息：");
        String id = sc.next();
        String name = sc.next();
        String score = sc.next();
        String[] info = {id, name, score};
        userInput.dataElements = info;
        userInput.typeElements = null;
        break;
      case 2:
        userInput.type = userInput.CREAT;
        System.out.println("请输入要创建的表名：");
        userInput.tableName = sc.next();
        System.out.println("请以此输入属性名称及存储类型：");
        String ele1 = sc.next();
        String type1 = sc.next();
        String ele2 = sc.next();
        String type2 = sc.next();
        String ele3 = sc.next();
        String type3 = sc.next();
        String[] ele = {ele1, ele2, ele3};
        String[] types = {type1, type2, type3};
        userInput.dataElements = ele;
        userInput.typeElements = types;
        break;
      default:
        System.err.println("输入了错误的命令！！");
        break;
    }

    sc.close();

    return;
  }

  /**
   * @MethodName RMIMethod
   * @author ganlin
   * @Description 调用远程方法
   * @Date 2020/3/19 下午10:05
   *
   * @return String
   */
  public String RMIMethod(){
    String result = null;
    try {
      result = dbServer.getData(userInput);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return result;
  }

  public static void main(String[] args){
    Client c1 = new Client();
    c1.inputInfo();
    System.out.println(c1.RMIMethod());
  }
}

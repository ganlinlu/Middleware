package server;

import data.Data;
import server.DBmanager;
import server.DataService;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * <h3>RMIPROJECT</h3>
 * @ClassName DBServer
 * <p>实现了接口DataService，将远程调用和数据库操作联合起来</p>
 *
 * @author : ganlin
 * @date : 2020-03-19 上午7:49
 **/
public class DBServer extends UnicastRemoteObject implements DataService{
  public DBmanager admin1 = new DBmanager();

  /**
   * @MethodName DBServer
   * @author ganlin
   * @Description 带有端口号设置的构造函数
   * @Date 2020/3/20 上午8:18
   *
   * @param port
   * <p>指定的端口号</p>
   * @return
   */
  public DBServer(int port) throws RemoteException {
    super(port);
  }

  /**
   * @MethodName DBServer
   * @author ganlin
   * @Description 默认的构造函数
   * @Date 2020/3/20 上午8:40
   *
   * @return
   */
  public DBServer() throws RemoteException {
  }

  /**
   * @MethodName DBServer
   * @author ganlin
   * @Description 带有三个参数的构造函数
   * @Date 2020/3/20 上午8:49
   *
   * @param port, csf, ssf
   * <p>分别对应端口号，客户端和服务端</p>
   * @return 
   */
  public DBServer(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException{
    super(port, csf, ssf);
  }

  /**
   * @MethodName getData
   * @author ganlin
   * @Description 实现接口中的getData方法
   * @Date 2020/3/20 上午8:51
   *
   * @param data
   * <p>接受来自用户的输入数据</p>
   * @return java.lang.String
   */
  @Override
  public String getData(Data data) throws RemoteException {
    String result = "";

    switch (data.type){
      case 0:
        result = admin1.queryRecord(data.tableName);
        break;
      case 1:
        result = admin1.insertRecord(data.tableName, data.dataElements);
        break;
      case 2:
        result = admin1.CreateTable(data.tableName, data.dataElements, data.typeElements);
        break;
      default:
        result = "wrong request!";
    }

    return result;
  }
}

package server;

import data.Data;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <h3>RMIPROJECT</h3>
 * @InterfaceName DataService
 * <p>远程调用的端口，在Server和Client中都有应用</p>
 *
 * @author : ganlin
 * @date : 2020-03-19 上午7:49
 **/
public interface DataService extends Remote {
  /*/**
   * @MethodName getData
   * @author ganlin
   * @Description 接口内定义的方法，用来实现远程调用
   * @Date 2020/3/19 上午7:52
   *
   * @param [data]
   * <p> 传输用户输入的数据</p>
   * @return java.lang.String
   * <p> 返回服务器的处理结果</p>
   */
  public String getData(Data data) throws RemoteException;
}

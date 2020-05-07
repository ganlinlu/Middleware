package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <h3>服务器端主方法</h3>
 * @author ganlin
 * @date 2020/03/19
 * <p> 此类用于将编写好的Server实现对象绑定到Java RMI的名字服务上。</p>
 */
public class ServerService {
  /**
   * @MethodName main
   * @author ganlin
   * @Description 服务器的主类，完成服务器实例的创建和绑定工作
   * @Date 2020/3/20 上午8:52
   *
   * @param [args]
   * @return void
   */
  public static void main(String[] args) {
    try {
      DBServer dbServer = new DBServer();
      System.out.println("开始绑定...");
      LocateRegistry.createRegistry(1111);
      Naming.rebind("//127.0.0.1:1111/db1", dbServer);
      System.out.println("绑定完成");
    } catch (RemoteException e) {
      System.err.println("创建服务器实例失败");
      e.printStackTrace();
    } catch (MalformedURLException e) {
      System.err.println("绑定失败");
      e.printStackTrace();
    }
  }
}

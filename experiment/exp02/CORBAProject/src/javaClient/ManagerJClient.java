package javaClient;

import DataService.DataTransform;
import DataService._operator;
import DataService.DataTransformHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Scanner;

/**
 * <h3>CORBAProject</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to input the order and record</p>
 *
 * @author : ganlin
 * @date : 2020-05-01 22:15
 **/
public class ManagerJClient {
  DataTransform dataServiceRef = null;
  _operator record = null ;
  org.omg.CORBA.Object objRef = null;
  ORB orb = null;
  String setInfo = null;
  String returnInfo = null;

  public ManagerJClient(String[] args){
    try {
      this.orb = ORB.init(args, null);
      objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
      dataServiceRef = DataTransformHelper.narrow(ncRef.resolve_str("DataService"));
    } catch (InvalidName invalidName) {
      invalidName.printStackTrace();
    } catch (CannotProceed cannotProceed) {
      cannotProceed.printStackTrace();
    } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
      invalidName.printStackTrace();
    } catch (NotFound notFound) {
      notFound.printStackTrace();
    }
    record = new _operator();
  }

  public void inputRecord(){
    Scanner sca1 = new Scanner(System.in);
    System.out.println("请选择你要进行的操作：0：查询; 1：插入");
    int order = sca1.nextInt();
    switch (order){
      case 0:
        record.isInsert = false;
        record.ID = "null";
        record.StudentNumber = "null";
        record.Classes = "null";
        record.score = "null";
        break;
      case 1:
        record.isInsert = true;
        System.out.println("请依次输入：ID StudentNumber Classes score;");
        record.ID = Integer.toString(sca1.nextInt());
        record.StudentNumber = Integer.toString(sca1.nextInt());
        record.Classes = sca1.next();
        record.score = Integer.toString(sca1.nextInt());
        break;
      default:
        System.err.println("错误的指令！！");
        break;
    }

    return;
  }

  public void sendRecord(){
    System.out.println("开始传送数据...");
    String result = dataServiceRef.sendData(record);
    System.out.println("获得结果：");
    System.out.println(result);

    return;
  }

  public static void main(String[] args){
    ManagerJClient c1 = new ManagerJClient(args);
    c1.inputRecord();
    c1.sendRecord();
  }
}

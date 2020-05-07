package server;

import DataService.DataTransform;
import DataService.DataTransformPOA;
import DataService.DataTransformHelper;
import DataService._operator;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

class DataServiceImpl extends DataTransformPOA {
  DBManager man1 = new DBManager("ScoreRecord");
  private ORB orb;
  public void setOrb(ORB orb_val)
  {
    this.orb = orb_val;
  }

  public String sendData(_operator name) {
    String result;
    if (name.isInsert){
      String [] record = {name.ID, name.StudentNumber, name.Classes, name.score};
      result = man1.insertRecord(record);
    } else {
      result = man1.queryRecord();
    }
    return result;
  }
}

/**
 * <h3>CORBAProject</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to implement OMG server</p>
 *
 * @author : ganlin
 * @date : 2020-05-01 17:23
 **/
public class ManagerServer {
  public static void main(String args[]) {
    try{
      System.out.println("创建和初始化 ORB ");

      ORB orb = ORB.init(args, null);


      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

      rootpoa.the_POAManager().activate();

      System.out.println("创建服务对象并将其向 ORB 注册 ");
      DataServiceImpl dataServiceImpl = new DataServiceImpl();

      dataServiceImpl.setOrb(orb);

      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(dataServiceImpl);
      DataTransform href = DataTransformHelper.narrow(ref);
      System.out.println(orb.object_to_string(href));

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
      NameComponent[] path = {new NameComponent("DataService", "")};

      System.out.println(ncRef.getClass().toString());
      ncRef.rebind(path, href);

      System.out.println("DataService ready and waiting ...");

      orb.run();

    } catch (Exception e) {
      System.err.println("Error: " + e);
    }
  }
}

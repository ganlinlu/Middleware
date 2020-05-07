package data;

import java.io.Serializable;


/**
 * <h3>RMIPROJECT</h3>
 * @ClassName Data
 * <p>用以存储和传输用户输入的数据,实现了序列化接口Serializable</p>
 *
 * @author : ganlin
 * @date : 2020-03-19 上午7:20
 **/
public class Data implements Serializable {
  public static final  int QUERY = 0;
  public static final int INSERT = 1;
  public static final int CREAT = 2;
  public int type;
  public String tableName;
  public String[] dataElements;
  public String[] typeElements;

  /**
   * @MethodName Data
   * @author ganlin
   * @Description 带参数的构造函数
   * @Date 2020/3/19 上午7:20
   *
   * @param [type1, tableName1, dataElements1, typeElements1]
   * @return
   */
  public Data(int type1, String tableName1, String[] dataElements1, String[] typeElements1) {
    type = type1;
    tableName = tableName1;
    dataElements = dataElements1;
    typeElements = typeElements1;
  }

  /**
   * @MethodName Data
   * @author ganlin
   * @Description 不带参数的构造函数
   * @Date 2020/3/20 上午7:42
   *
   * @return
   */
  public Data(){

  }
}

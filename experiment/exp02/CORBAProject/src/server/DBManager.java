package server;

import java.sql.*;

/**
 * <h3>CORBAProject</h3>
 * <h4> IntelliJ IDEA</h4>
 * <p>used to manager score table</p>
 *
 * @author : ganlin
 * @date : 2020-05-01 12:26
 **/
public class DBManager {
  //  MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL; 注意下两行的写法针对 MySQL 8.0，jdbc8.0以上版本，低版本请用低版本方法。
  String dirver = "com.mysql.cj.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/CORBA_Project?useSSL=false&serverTimezone=UTC";

  String user = "CORBA_admin";
  String passwd = "MYSQLcorba12369.";

  Connection conn = null;
  Statement state = null;

  String tableName = null;

  public DBManager(String tableName){
    this.tableName = tableName;
    try {
      Class.forName(dirver);
      System.out.println("连接数据库...");
      conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("创建数据库成功！");
    } catch (ClassNotFoundException e) {
      System.err.println("注册JDBC驱动故障！！");
      e.printStackTrace();
    } catch (SQLException e){
      System.err.println("连接数据库故障！！");
      e.printStackTrace();
    }
  }

  /**
   * @MethodName insertRecord
   * @author ganlin
   * @Description 用于向表中插入数据
   * @Date 2020/5/1 下午12:46
   *
   * @param records
   * @return java.lang.String
   */
  public String insertRecord(String[]records){
    boolean ok = true;
    try {
      state = conn.createStatement();
    } catch (SQLException e) {
      System.err.println("创建实例失败！！");
      e.printStackTrace();
      ok = false;
    }
    String insertRecordSql = "insert into " + this.tableName + " value( ";
    insertRecordSql += "'" + records[0] + "', ";
    insertRecordSql += "'" + records[1] + "', ";
    insertRecordSql += "'" + records[2] + "', ";
    insertRecordSql += records[3] +")";

    try {
      System.out.println("插入记录...");
      state.executeUpdate(insertRecordSql);
      System.out.println("插入成功！");
      state.close();
    } catch (SQLException e) {
      System.err.println("插入错误！！");
      e.printStackTrace();
      ok = false;
    }

    if (ok)
      return "ok";
    else
      return "insert wrong!";
  }

  /**
   * @MethodName queryRecord
   * @author ganlin
   * @Description TODO
   * @Date 2020/5/1 下午12:49
   *
   * @param
   * @return java.lang.String
   */
  public String queryRecord(){
    String results = "";
    try {
      state = conn.createStatement();
    } catch (SQLException e) {
      System.err.println("创建实例失败！！");
      e.printStackTrace();
    }

    try {
      System.out.println("查询记录中...");
      ResultSet result = state.executeQuery("select * from " + tableName);
      System.out.println("查询完成！");
      System.out.println("\t\tID\t\t\tStudentNumber\tClasses\tscore\t");
      results += "\tID\t\tNAME\tSCORE\t\n";
      while (result.next()){
        String query = result.getString("ID" ) + "\t\t" + result.getString("StudentNumber") + "\t\t\t" + result.getString("Classes") + "\t\t" + result.getInt("score");
        System.out.println(query);
        results += query + "\n";
      }
      state.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return results;
  }
}

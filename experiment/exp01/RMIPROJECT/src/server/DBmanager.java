package server;

import java.sql.*;

/**
 * <h3>RMIPROJECT</h3>
 * @ClassName DataService
 * <p>定义了数据库的相关操作</p>
 *
 * @author : ganlin
 * @date : 2020-03-19 上午7:49
 **/
public class DBmanager {
    //  MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL; 注意下两行的写法针对 MySQL 8.0，jdbc8.0以上版本，低版本请用低版本方法。
    String dirver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/RMIPROJECT1?useSSL=false&serverTimezone=UTC";

    String user = "RMI";
    String passwd = "RMIMYSQL12369.";

    Connection conn = null;
    Statement state = null;

    /**
     * @MethodName DBmanager
     * @author ganlin
     * @Description 默认构造方法，用以完成数据库的连接，驱动的激活。
     * @Date 2020/3/20 上午8:03
     *
     * @return
     */
    public DBmanager(){

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
     * @MethodName CreateTable
     * @author ganlin
     * @Description 完成创建数据表的功能。
     * @Date 2020/3/20 上午8:05
     *
     * @param tableName, columnNames, attributes
     * <p>分别对应表名、表中属性和属性存储类型</p>
     * @return java.lang.String
     */
    public String CreateTable(String tableName, String[] columnNames, String[] attributes){
        boolean ok = true;
        try {
            state = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("创建实例失败！！");
            e.printStackTrace();
            ok = false;
        }
        String createTableSql = "CREATE TABLE " + tableName + "( ";
        int length = columnNames.length;

        for (int i = 0; i < length - 1; i++) {
            String column = columnNames[i] + " " + attributes[i] + "not null,";
            createTableSql += column;
        }
        createTableSql += columnNames[length - 1] + " " + attributes[length - 1] + "not null ) charset=utf8;";
        try {
            System.out.println("正在创建表"+ tableName + "...");
            state.executeLargeUpdate(createTableSql);
            System.out.println("创建表成功！");
            state.close();
        } catch (SQLException e) {
            System.err.println("创建表失败！！");
            e.printStackTrace();
            ok = false;
        }

        if (ok)
            return "ok";
        else
            return "operate wrong!";
    }

    /**
     * @MethodName insertRecord
     * @author ganlin
     * @Description 用以完成数据库记录的插入操作
     * @Date 2020/3/20 上午8:08
     *
     * @param tableName, records
     * <p>分别对应表名和要插入的记录</p>
     * @return java.lang.String
     */
    public String insertRecord(String tableName, String[]records){
        boolean ok = true;
        try {
            state = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("创建实例失败！！");
            e.printStackTrace();
            ok = false;
        }
        String insertRecordSql = "insert into " + tableName + " value( ";
        int length = records.length;
        insertRecordSql += "'" + records[0] + "', ";
        insertRecordSql += "'" + records[1] + "', ";
        insertRecordSql += records[2] +")";

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
     * @Description 用以完成数据表的查询工作
     * @Date 2020/3/20 上午8:10
     *
     * @param tableName
     * <p>对应要查询的表名</p>
     * @return java.lang.String
     */
    public String queryRecord(String tableName){
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
            System.out.println("\tID\t\tNAME\tSCORE\t");
            results += "\tID\t\tNAME\tSCORE\t\n";
            while (result.next()){
                String query = result.getString("ID" ) + "\t" + result.getString("NAME") + "\t\t" + result.getInt("SCORE");
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

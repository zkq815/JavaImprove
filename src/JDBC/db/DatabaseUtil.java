package JDBC.db;

import java.sql.*;

/**
 * Created by zkq on 2017/2/5.
 */
public class DatabaseUtil {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PWD = "123";
    private static Connection connection = null;
    static {

        try {
            //1、加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2、获得数据库链接
            connection = DriverManager.getConnection(URL,USER,PWD);
            //3、操作数据库，实现增删改查四大天王
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select user_name,age from person");
//            while (resultSet.next()){
//                System.out.println("resultSet = " + resultSet.getString("user_name"));
//                System.out.println("resultSet = " + resultSet.getString("age"));
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}

package JDBC.dao;


import JDBC.db.DatabaseUtil;
import JDBC.model.Custom;

import java.sql.*;

/**
 * Created by zkq on 2017/2/8.
 */
public class CustomDao {
    private Connection connection = null;

    public Custom select(int id){
        Custom custom = new Custom();
        try {
            connection = DatabaseUtil.getConnection();
//            connection.setAutoCommit(false);
            String sql = "select * from custom where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("resultSet = " + resultSet.getInt("id"));
                System.out.println("resultSet = " + resultSet.getString("buy_name"));
                System.out.println("resultSet = " + resultSet.getString("buy_money"));
                System.out.println("resultSet = " + resultSet.getDate("buy_time")+" "+resultSet.getTime("buy_time").toString());
                custom.setId(id);
                custom.setName(resultSet.getString("buy_name"));
                custom.setName(resultSet.getDate("buy_time").toString());
                custom.setMoney(resultSet.getFloat("buy_money"));
            }
            return custom;

        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return custom;
    }

    /**
     * 注释
     * */
    public boolean updata(Custom custom){
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);
            connection.commit();
            String sql = "" +
                    "update custom " +
                    "set buy_money=?,buy_time=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1,custom.getMoney());
            preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
            preparedStatement.setInt(3,custom.getId());
            preparedStatement.execute();

//            String a ="";
//            a.substring(1,5);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }
}

package JDBC.dao;


import JDBC.db.DatabaseUtil;
import JDBC.model.Shop;

import java.sql.*;

/**
 * Created by zkq on 2017/2/9.
 */
public class ShopDao {
    private Connection connection = null;

    public Shop select(int id){
        Shop shop = new Shop();
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);
            connection.commit();
            String sql = "select * from shop where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("resultSet = " + resultSet.getInt("id"));
                System.out.println("resultSet = " + resultSet.getString("shop_name"));
                System.out.println("resultSet = " + resultSet.getString("shop_money"));
                System.out.println("resultSet = " + resultSet.getDate("shop_time")+" "+resultSet.getTime("shop_time").toString());
                shop.setId(id);
                shop.setName(resultSet.getString("shop_name"));
                shop.setName(resultSet.getDate("shop_time").toString());
                shop.setMoney(resultSet.getFloat("shop_money"));
            }
            return shop;

        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return shop;
    }

    public boolean updata(Shop shop){
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);
            connection.commit();
            String sql = "" +
                    "update shop " +
                    "set shop_money=?,shop_time=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1,shop.getMoney());
            preparedStatement.setDate(2,new Date(System.currentTimeMillis()));
            preparedStatement.setInt(3,shop.getId());
            preparedStatement.execute();

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

package JDBC.dao;


import JDBC.db.DatabaseUtil;
import JDBC.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zkq on 2017/2/5.
 */
public class PersonDao {
    private Connection connection = null;

    public void select_nofilter(){
        //1、获得连接
        connection = DatabaseUtil.getConnection();

        try {
            //2、获得callableStatement
            CallableStatement callableStatement = connection.prepareCall("call sp_select_nofilter");
            //3、执行存储过程
            callableStatement.execute();
            //4、处理返回结果：结果集，出参
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                System.out.println("user_name=="+resultSet.getString("user_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void select_filter(String name){
        //1、获得连接
        connection = DatabaseUtil.getConnection();

        try {
            //2、获得callableStatement
            CallableStatement callableStatement = connection.prepareCall("call sp_select_filter(?)");
            callableStatement.setString(1,name);
            //3、执行存储过程
            callableStatement.execute();
            //4、处理返回结果：结果集，出参
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                System.out.println("user_name=="+resultSet.getString("user_name"));
                System.out.println("age=="+resultSet.getString("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select_count(){
        Integer count = 0;
        //1、获得连接
        connection = DatabaseUtil.getConnection();

        try {
            //2、获得callableStatement
            CallableStatement callableStatement = connection.prepareCall("call sp_select_count(?)");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            //3、执行存储过程
            callableStatement.execute();
            //4、处理返回结果：结果集，出参
            count = callableStatement.getInt(1);
            System.out.println("count = " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(Person person){
        try {
            connection = DatabaseUtil.getConnection();
            String sql = "" +
                    "insert into person" +
                    "(user_name,sex,age,birthday) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getUserName());
            preparedStatement.setInt(2,person.getSex());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setDate(4,new Date(person.getBirthday().getTime()));
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(Integer id){
        try {
            connection = DatabaseUtil.getConnection();
            String sql = "delete from person where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person){
        try {
            connection = DatabaseUtil.getConnection();
            String sql = "" +
                    "update person " +
                    "set user_name=?,sex=?,age=?,birthday=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getUserName());
            preparedStatement.setInt(2,person.getSex());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setDate(4,new Date(person.getBirthday().getTime()));
            preparedStatement.setInt(5,person.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person searchOnePerson(Integer id){
        Person person = null;

        try {
            connection = DatabaseUtil.getConnection();
            String sql = "select * from person where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setUserName(resultSet.getString("user_name"));
                person.setAge(resultSet.getInt("age"));
                person.setSex(resultSet.getInt("sex"));
//                System.out.println("id = " + resultSet.getInt("id"));
//                System.out.println("user_name = " + resultSet.getString("user_name"));
//                System.out.println("age = " + resultSet.getInt("age"));
//                System.out.println("sex = " + resultSet.getInt("sex"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public List<Person> searchPerson(){
        List<Person> personList = null;
        Statement statement = null;
        try {
            connection = DatabaseUtil.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            personList = new ArrayList<Person>();

            while (resultSet.next()){
                Person p = new Person();
                p.setId(resultSet.getInt("id"));
                p.setAge(resultSet.getInt("age"));
                p.setSex(resultSet.getInt("sex"));
                p.setUserName(resultSet.getString("user_name"));
                personList.add(p);
//                System.out.println("resultSet = " + resultSet.getString("user_name"));
//                System.out.println("resultSet = " + resultSet.getString("age"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("personList.size = " + personList.size());
        return personList;
    }

    public List<Person> searchPersonByName(String name){
        List<Person> personList = null;
        Statement statement = null;
        try {
            connection = DatabaseUtil.getConnection();
            statement = connection.createStatement();
            String sql = "select * from person where user_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            personList = new ArrayList<Person>();

            while (resultSet.next()){
                Person p = new Person();
                p.setId(resultSet.getInt("id"));
                p.setAge(resultSet.getInt("age"));
                p.setSex(resultSet.getInt("sex"));
                p.setUserName(resultSet.getString("user_name"));
                personList.add(p);
//                System.out.println("resultSet = " + resultSet.getString("user_name"));
//                System.out.println("resultSet = " + resultSet.getString("age"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("personList.size = " + personList.size());
        return personList;
    }

    public List<Person> searchPersonByAge(Integer age){
        List<Person> personList = null;
        Statement statement = null;
        try {
            connection = DatabaseUtil.getConnection();
            statement = connection.createStatement();
            String sql = "select * from person where age=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,age);
            ResultSet resultSet = preparedStatement.executeQuery();
            personList = new ArrayList<Person>();

            while (resultSet.next()){
                Person p = new Person();
                p.setId(resultSet.getInt("id"));
                p.setAge(resultSet.getInt("age"));
                p.setSex(resultSet.getInt("sex"));
                p.setUserName(resultSet.getString("user_name"));
                personList.add(p);
//                System.out.println("resultSet = " + resultSet.getString("user_name"));
//                System.out.println("resultSet = " + resultSet.getString("age"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("personList.size = " + personList.size());
        return personList;
    }

    public List<Person> searchPersonByParams(List<HashMap<String,Object>> params){
        List<Person> personList = new ArrayList<Person>();
        try {
        connection = DatabaseUtil.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select * from person where 1=1 ");
        if(params!=null){
            for (int i = 0; i <params.size() ; i++) {
                HashMap<String,Object> map = params.get(i);
                sql.append(" and "+map.get("name")+" "+map.get("relationship")+" "+map.get("value"));
            }
        }


        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setSex(resultSet.getInt("sex"));
            person.setUserName(resultSet.getString("user_name"));
//            System.out.println("person.getUserName = " + person.getUserName());
//            System.out.println("person.getAge() = " + person.getAge());
//            System.out.println("person.getSex() = " + person.getSex());
            personList.add(person);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

}

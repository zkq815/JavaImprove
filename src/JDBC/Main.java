package JDBC;

import JDBC.action.DBAction;
import JDBC.dao.CustomDao;
import JDBC.dao.PersonDao;
import JDBC.dao.ShopDao;
import JDBC.model.Custom;
import JDBC.model.Person;
import JDBC.model.Shop;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by zkq on 2017/2/4.
 */
public class Main {
    private static final String CONTEXT="欢迎来到人堆：\n"+
            "下面是人堆的功能列表：\n"+
            "[MAIN/M]:主菜单\n"+
            "[QUERY/Q]：查看全部人堆的信息\n"+
            "[GET/G]查看某位人物的信息\n"+
            "[ADD/A]添加一个人物\n"+
            "[UPDATE/U]更新人物信息\n"+
            "[DELETE/D]删除一个人物\n"+
            "[SEARCH/S]搜索一个人物（通过名称、年龄）\n"+
            "[EXIT/E]退出人堆\n"+
            "[BREAK/B]退出当前功能，返回主菜单\n";

    private static final String OPEATION_MAIN = "MAIN";
    private static final String OPEATION_QUERY = "QUERY";
    private static final String OPEATION_GET = "GET";
    private static final String OPEATION_ADD = "ADD";
    private static final String OPEATION_UPDATE = "UPDATE";
    private static final String OPEATION_DELETE = "DELETE";
    private static final String OPEATION_SEARCH = "SEARCH";
    private static final String OPEATION_EXIT = "EXIT";
    private static final String OPEATION_BREAK = "BREAK";

    public static void main(String[] args){
        PersonDao personDao = new PersonDao();
//        personDao.select_nofilter();
//        personDao.select_filter("小红");
//        personDao.select_count();
        CustomDao customDao = new CustomDao();
        Custom custom = new Custom();
        ShopDao shopDao = new ShopDao();
        Shop shop = new Shop();
        custom = customDao.select(1);
        System.out.println("---------------------------");
        shop = shopDao.select(1);
        System.out.println("------------购买20块钱的东西---------------");

        custom.setMoney((float) (custom.getMoney()-20.00));
        custom.setData(new Date().toString());

        shop.setMoney((float)(shop.getMoney()+20.00));
        shop.setData(new Date().toString());

        if(customDao.updata(custom)){
            shopDao.updata(shop);
        }else{
            System.out.println("购买失败");
            return;
        }
        System.out.println("----------更新完毕-----------------");
        customDao.select(1);
        System.out.println("---------------------------");
        shopDao.select(1);


    }

    private void product(){
        System.out.println(CONTEXT);
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        DBAction dbAction = new DBAction();

        String temp="";
        Integer step = 1;
        while(true){
            String in = scanner.next().toString();
            if(OPEATION_EXIT.equals(in.toUpperCase()) ||OPEATION_EXIT.substring(0,1).equals(in.toUpperCase())) {
                System.out.println("程序已经退出");
                break;
            }else if(OPEATION_QUERY.equals(in) || OPEATION_QUERY.substring(0,1).equals(in.toUpperCase())){
                List<Person> personList = dbAction.selectAllPerson();
                for (Person p : personList) {
                    System.out.println(p.getId()+":"+p.getUserName());
                }
            }else if(OPEATION_ADD.equals(in.toUpperCase())
                    || OPEATION_ADD.substring(0,1).equals(in.toUpperCase())
                    || temp.equals(OPEATION_ADD)) {
                temp = OPEATION_ADD;
                //新增人物
                if(1==step){
                    System.out.println("请输入人物的【姓名】");
                }else if(2==step){
                    System.out.println("您输入的姓名为："+in);
                    person.setUserName(in);
                    System.out.println("请输入人物的【年龄】");
                }else if(3==step){
                    person.setAge(Integer.parseInt(in));
                    System.out.println("请输入人物的【性别】");
                }else if(4==step){
                    person.setSex(Integer.parseInt(in));
                    System.out.println("请输入人物的【生日】：");
                }else if(5==step){
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sf.parse(in);
                        person.setBirthday(birthday);
                        dbAction.addPerson(person);
                        System.out.println("添加人物成功！");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("您输入的格式有误，请重新输入");
                        step = 4;
                    }
                }

                if(temp.equals(OPEATION_ADD)){
                    step ++;
                }
            }else{
                System.out.println("您输入的内容为："+scanner.next().toString());
            }
        }
    }

    private void justTest(){
        DBAction dbAction = new DBAction();
        //新增一条数据
        Person person = new Person();
        person.setSex(2);
        person.setUserName("小鱼儿");
        person.setAge(20);
        person.setBirthday(new Date());
//        dbAction.addPerson(person);

        //删除一条数据
//        dbAction.deletePerson(4);

        //更新一条数据
        person.setId(8);
//        dbAction.updatePerson(person);

        //查询所有的数据
        List<Person> personList = dbAction.selectAllPerson();
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getId()+":"+personList.get(i).getUserName());
        }
        System.out.println("---------------------------------------------------");
        //按照自定义的字段查询
        List<HashMap<String,Object>> params = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("name","age");
        map.put("relationship","=");
        map.put("value",22);
        params.add(map);
        map = new HashMap<String,Object>();
        map.put("name","user_name");
        map.put("relationship","like");
        map.put("value","'%小%'");
        params.add(map);

        personList = dbAction.selectPersonByParams(params);
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getId()+":"+personList.get(i).getUserName());
        }
    }
}

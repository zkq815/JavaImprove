package JsonAndGson;

import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zkq on 2017/2/21.
 */
public class JsonAndGsonDemo {
    public static void main(String[] args) {
//        jsonObject();
//        jsonWithMap();
        jsonWithFile();
    }

    private static void jsonObject(){
        Object object = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zkq");
        jsonObject.put("age",25.5);
        jsonObject.put("birthday","1990-08-15");
        jsonObject.put("school","蓝翔");
        jsonObject.put("skill",new String[]{"笑","哭"});
        jsonObject.put("commen",object);
        System.out.println("jsonObject = " + jsonObject.toString());
    }

    private static void jsonWithMap(){
        Object object = null;
        Map<String,Object> jsonObject = new HashMap<String,Object>();
        jsonObject.put("name","zkq");
        jsonObject.put("age",25.5);
        jsonObject.put("birthday","1990-08-15");
        jsonObject.put("school","蓝翔");
        jsonObject.put("skill",new String[]{"笑","哭"});
        jsonObject.put("commen",object);
        System.out.println("jsonObject = " + new JSONObject(jsonObject).toString());
    }

    private static void jsonWithFile(){
        File file = new File(String.valueOf(JsonAndGsonDemo.class.getResource("/test.json")));
        file = new File("test.json");
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = "";
            int length;
            while ((str = br.readLine())!=null){
                sb.append(str);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            System.out.println("jsonObject = " + jsonObject.toString());
            if(!jsonObject.isNull("name"))
                System.out.println("jsonObject.getString(\"name\") = " + jsonObject.getString("name"));
            if(!jsonObject.isNull("age"))
                System.out.println("jsonObject.getDouble(\"age\") = " + jsonObject.getDouble("age"));
            if(!jsonObject.isNull("has_gf"))
                System.out.println("jsonObject.getBoolean(\"has_gf\") = " + jsonObject.getBoolean("has_gf"));
            if(!jsonObject.isNull("skill")){
                for (int i = 0; i < jsonObject.getJSONArray("skill").length(); i++) {
                    System.out.println("jsonObject = " + jsonObject.getJSONArray("skill").get(i).toString());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

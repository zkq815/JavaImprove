package IODemo;

import java.io.*;

/**
 * Created by zkq on 2017/2/16.
 */
public class SerializableTest {

    public static void serializableSaveTest(String fileName){
        Person p = new Person("zkq",23);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(p);
            oos.flush();
        }catch (IOException e){

        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void serializableReadTest(String fileName){
        System.out.println("fileName = " + fileName);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            Person p = (Person) ois.readObject();
            System.out.println("p = " + p.toString());

        }catch (IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

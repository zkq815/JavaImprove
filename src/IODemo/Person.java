package IODemo;

import java.io.Serializable;

/**
 * Created by zkq on 2017/2/16.
 */
public class Person implements Serializable{
    private String name;
    private transient int whatever;//该元素不会进行jvm默认的序列化，但是不代表不能被序列化

    public Person() {

    }

    public Person(String name, int whatever) {
        super();
        this.name = name;
        this.whatever = whatever;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWhatever() {
        return whatever;
    }

    public void setWhatever(int whatever) {
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", whatever='" + whatever + '\'' +
                '}';
    }

    //序列化
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        s.defaultWriteObject();//将jvm能默认序列化的元素进行序列化操作
        s.writeInt(whatever);//自己完成whatever的序列化
    }

    //反序列化
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException,ClassNotFoundException{
        s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
        this.whatever = s.readInt();//自己完成stuage的反序列化操作
    }
}

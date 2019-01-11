package test4;

import java.util.Map;
import java.util.TreeMap;

public class Test4 {
    public static void main(String[] args) {
        Map<Integer,String> students=new TreeMap<>();
        students.put(2,"小明2");
        students.put(5,"小明5");
        students.put(4,"小明4");
        students.put(1,"小明1");
        students.put(3,"小明3");
        System.out.println(students.toString());

    }
}

package test9;

/**
 * @Author: xcx
 * @Date: 2019/1/13 0:01
 * @Version 1.0
 */
public class Penguin extends Pet {
    private String sex="Q仔";
    public Penguin(){}
    @Override
    public void print()
    {
        super.print();
        System.out.print(" 性别："+sex);
    }

    public String getSex() {
        return sex;
    }
}

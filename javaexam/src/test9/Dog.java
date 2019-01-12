package test9;

/**
 * @Author: xcx
 * @Date: 2019/1/12 23:58
 * @Version 1.0
 */
public class Dog extends Pet {
    private String strain="牧羊犬";
    public Dog(){}

    @Override
    public void print()
    {
        super.print();
        System.out.print(" 品种："+strain);
    }


    public String getStrain() {
        return strain;
    }
}

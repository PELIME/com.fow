package test9;

/**
 * @Author: xcx
 * @Date: 2019/1/12 23:53
 * @Version 1.0
 */
public class Test9 {
    public static void main(String[] args) {
        Master master=new Master();
        Dog dog=new Dog();
        Penguin penguin=new Penguin();
        dog.setHealth(45);
        master.cure(dog);
        master.cure(dog);
        penguin.setHealth(46);
        master.cure(penguin);
        master.cure(penguin);
    }
}

package test9;

/**
 * @Author: xcx
 * @Date: 2019/1/12 23:55
 * @Version 1.0
 */
public class Pet {
    private String name ="";
    private int health=100;
    private int love=20;
    public void print()
    {
        System.out.print("\n宠物名："+name+" 健康："+health+" 爱心："+love);
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLove() {
        return love;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

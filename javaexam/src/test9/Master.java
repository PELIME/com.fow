package test9;

/**
 * @Author: xcx
 * @Date: 2019/1/13 0:03
 * @Version 1.0
 */
public class Master {
    public void cure(Dog dog)
    {
        if(dog.getHealth()<50)
        {
            System.out.print("\n狗狗健康值："+dog.getHealth());
            System.out.print("\n给狗狗打针、吃药治疗");
            dog.setHealth(60);
            System.out.print("\n狗狗健康值："+dog.getHealth());
        }
        else
            System.out.print("\n狗狗健康,健康值："+dog.getHealth());
    }
    public void cure(Penguin penguin)
    {
        if(penguin.getHealth()<50)
        {
            System.out.print("\nQ仔健康值："+penguin.getHealth());
            System.out.print("\n给Q仔吃药、疗养治疗");
            penguin.setHealth(60);
            System.out.print("\nQ仔健康值："+penguin.getHealth());
        }
        else
            System.out.print("\nQ仔健康,健康值："+penguin.getHealth());
    }
}

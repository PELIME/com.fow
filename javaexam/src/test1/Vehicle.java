package test1;

public  class Vehicle {
    int speed;
    String kind;
    String color;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "速度:" + speed + "\t类别:" + kind + "\t颜色:" + color;
    }
    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle();
        vehicle.setSpeed(80);
        vehicle.setKind("五菱宏光");
        vehicle.setColor("白色");
        System.out.println(vehicle.toString());
    }

}


package test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test3 {


    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,100);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(calendar.getTime()));
    }
}

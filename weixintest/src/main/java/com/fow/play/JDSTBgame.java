package com.fow.play;

public class JDSTBgame {
    static final String[] JD_STRING={"我出【剪刀】，平手。","我出【石头】,哈哈你输了！！","我出 【布】,是在下输了。"};
    static final String[] ST_STRING={"我出【剪刀】，是在下输了。","我出【石头】,平手。","我出 【布】,哈哈你输了！！"};
    static final String[] B_STRING={"我出【剪刀】，哈哈你输了！！","我出【石头】,是在下输了。","我出 【布】,平手。"};
    public static String getResult(String jdstb)
    {
        jdstb=jdstb.trim();
        int r=((int)(Math.random()*100))%3;
        if(jdstb.equals("剪刀"))
            return JD_STRING[r];
        else if(jdstb.equals("石头"))
            return ST_STRING[r];
        else if(jdstb.equals("布"))
            return B_STRING[r];
        else
            return "error";
    }
}

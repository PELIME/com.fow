package com.fow.play;

import java.util.*;

public class WxSessionContainer {
    private static Map<String,WxSession> wxSessionMap=new HashMap<>();

    private static final long EXPIRATION_TIME=1000*60*30;
    private static final int START=0;
    private static final int INTERVAL=10000;
    public static void put(WxSession session)
    {
        wxSessionMap.put(session.getOpenid(),session);
    }
    public static WxSession get(String openid)
    {
        return wxSessionMap.get(openid);
    }
    public static boolean contain(String openid)
    {
        return wxSessionMap.containsKey(openid);
    }
    public static void remove(String openid)
    {
        wxSessionMap.remove(openid);
    }
    static {
        Timer tt=new Timer();
        tt.schedule(new TimerTask() {
            @Override
            public void run() {
                long nd=new Date().getTime();
                Iterator<Map.Entry<String,WxSession>> entries=wxSessionMap.entrySet().iterator();
                while (entries.hasNext())
                {
                    Map.Entry<String,WxSession> entry=(Map.Entry)entries.next();
                    String openid=entry.getKey();
                    WxSession wxSession=entry.getValue();
                    long createtime=wxSession.getCreatetime();
                    if((nd-createtime)>EXPIRATION_TIME)
                    {
                        synchronized (wxSessionMap)
                        {
                            wxSessionMap.remove(openid);
                        }
                        System.out.println(openid+" 已过期");
                    }
                }
            }
        },START,INTERVAL);
    }
}

package com.fow.play;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WxSession {
    private String openid;
    private Map<String,String> parameter=new HashMap<>();
    private long createtime=new Date().getTime();
    public String getParameter(String key)
    {
        return parameter.get(key);
    }
    public void setParameter(String key,String value)
    {
        parameter.put(key,value);
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public long getCreatetime() {
        return createtime;
    }
}

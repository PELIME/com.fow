package com.fow.controller;

import org.springframework.util.StringUtils;

public class Luck {
    public void getOpenid(String code)
    {

        String url="";
        if(StringUtils.isEmpty(code))
        {
            url="http://open.winxin.qq.com/connect/oauth2/authorize?appid="+getAppid()+"" +
                    "&redirect_url="+getRedirectUrl();
        }
        else
        {
            url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + getAppid() +
                    "&secret=" + getSecret() + "&code=" + code + "&grant_type=authorization_code";
        }

    }


    public String getAppid()
    {
        return "appid";
    }

    public String getRedirectUrl()
    {
        return "redirecturl";
    }
    public String getSecret()
    {
        return "secrect";
    }
}

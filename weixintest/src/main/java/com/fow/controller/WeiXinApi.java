package com.fow.controller;

import com.fow.weixinutil.WeiXinCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
public class WeiXinApi {
    private static final String TOKEN="lbx123456";
    @RequestMapping("/wx")
    public @ResponseBody String rukou(HttpServletRequest request)
    {
        String method=request.getMethod();
        if(method.equalsIgnoreCase("get"))
        {
            String signature=request.getParameter("signature");
            String timestamp=request.getParameter("timestamp");
            String nonce=request.getParameter("nonce");
            String echostr=request.getParameter("echostr");
            if(WeiXinCheck.check(signature,WeiXinApi.TOKEN,timestamp,nonce))
            {
                return echostr;
            }
        }
        return "呵呵";
    }
}

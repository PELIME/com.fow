package com.fow.controller;

import com.fow.weixinutil.WeiXinCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;


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
        else if(method.equalsIgnoreCase("post"))
        {


            try {
                BufferedReader breader=request.getReader();
                String stmp=null;
                System.out.println("----------------------");
                while ((stmp=breader.readLine())!=null)
                {
                    System.out.println(stmp);
                }
                System.out.println("----------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "呵呵";
    }
}

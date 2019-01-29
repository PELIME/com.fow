package com.fow.controller;

import com.fow.message.wxdomain.Text;
import com.fow.play.JDSTBgame;
import com.fow.play.WxSession;
import com.fow.play.WxSessionContainer;
import com.fow.weixinutil.WeiXinCheck;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
public class WeiXinApi {
    private static final String TOKEN="lbx123456";

    @Autowired
    private XStream textXStream;


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
                Text text=(Text) textXStream.fromXML(request.getReader());
                //System.out.println(text.toString());
                //text.setCreateTime(null);
                String content=text.getContent().trim();
                text.setContent("输入“玩游戏”试试吧");
                if(content.equals("玩游戏"))
                {
                    if(WxSessionContainer.contain(text.getFromUserName()))
                    {
                        text.setContent("你已经在游戏里面了哟，输入“退出”可退出当前游戏");
                    }
                    else
                    {
                        text.setContent("输入你想玩的游戏：\n 剪刀石头布");
                    }
                }
                if(WxSessionContainer.contain(text.getFromUserName()))
                {
                    if(content.equals("退出"))
                    {
                        WxSessionContainer.remove(text.getFromUserName());
                        text.setContent("退出成功，想玩游戏时就告诉我哟！");
                    }
                    else
                    {
                        String result=JDSTBgame.getResult(content);
                        if(result.equals("error"))
                            text.setContent("输入有误，请输入：\n剪刀 \n 石头 \n 布 \n中的一个");
                        else
                            text.setContent(result);
                    }
                }
                if(content.equals("剪刀石头布"))
                {
                    if(WxSessionContainer.contain(text.getFromUserName()))
                    {
                        text.setContent("出拳吧！\n 输入“退出”可退出当前游戏");
                    }
                    else
                    {
                        WxSession session=new WxSession();
                        session.setOpenid(text.getFromUserName());
                        WxSessionContainer.put(session);
                        text.setContent("出拳吧！\n 输入“退出”可退出当前游戏");
                    }
                }
                if(content.contains("宝宝"))
                {
                    text.setContent("宝宝生日快乐！！\n 爱你！么么哒！");
                }
                text.exchange();
                text.setMsgId(null);
                String result=textXStream.toXML(text);
                System.out.println(result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "呵呵";
    }
}

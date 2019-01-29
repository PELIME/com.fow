package com.fow.message;

import com.fow.message.wxdomain.Text;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

public class TextConverter implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        Text text=(Text)o;
        String prefix = "<![CDATA[";
        String suffix = "]]>";
        writer.startNode("ToUserName");
        writer.setValue(prefix+text.getFromUserName()+suffix);
        writer.endNode();
        writer.startNode("FromUserName");
        writer.setValue("<![CDATA["+text.getToUserName()+"]]>");
        writer.endNode();
        writer.startNode("CreateTime");
        writer.setValue("<![CDATA["+new Timestamp((new Date()).getTime()) +"]]>");
        writer.endNode();
        writer.startNode("MsgType");
        writer.setValue("<![CDATA["+text.getMsgType()+"]]>");
        writer.endNode();
        writer.startNode("Content");
        writer.setValue("<![CDATA["+text.getContent()+"]]>");
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Text text=new Text();
        Method[] methods=text.getClass().getMethods();
        while (reader.hasMoreChildren())
        {
            reader.moveDown();
            String nodeNme=reader.getNodeName();
            for(Method m:methods)
            {
                if(m.getName().equalsIgnoreCase("set"+nodeNme)) {
                    try {
                        m.invoke(text,reader.getValue());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }
            reader.moveUp();
        }
        return text;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Text.class);
    }
}

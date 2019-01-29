package com.fow;

import com.fow.message.TextConverter;
import com.fow.message.wxdomain.Text;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Writer;

@SpringBootApplication
@Configuration
public class WeiXinApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiXinApplication.class);
    }

    @Bean
    XStream textXStream()
    {
        XStream xStream=new XStream(new XppDriver()
        {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    //对所有XML节点都增加CDATA标记
                    boolean cdata = true;

                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        xStream.alias("xml",Text.class);
        xStream.processAnnotations(Text.class);
        //xStream.registerConverter(new TextConverter());
        return xStream;
    }
}

package test8;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: xcx
 * @Date: 2019/1/12 23:37
 * @Version 1.0
 */
public class Test8 {
    public static void main(String[] args) {
        String testString="you are my friend you are  my friend#";//可以用文件，标准输入设备，网络等获取替换
        System.out.println(read(testString));
    }
    public static int read(String content)
    {
        if(content==null||content.equals(""))
            return 0;
        Set<String> strings=new TreeSet<>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<content.length();i++)
        {
            char tmp=content.charAt(i);
            if(tmp=='#')
                return strings.size();
            else if(tmp==' ')
            {
                if(!sb.toString().trim().equals(""))
                {
                    strings.add(sb.toString().trim());
                    sb=new StringBuffer();
                }
            }
            else
                sb.append(tmp);
        }
        return strings.size();
    }
}

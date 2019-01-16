package com.fow.pelime.util;

public class ImageUtil {
    public final static byte[] JPG_HEADER={-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1};
    public final static byte[] PNG_HEADER={-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13};
    public final static byte[] BMP_HEADER={66, 77, -99, -99, -99, 0, 0, 0, 0, 0, 54, 0, 0, 0, 40, 0, 0, 0};

    /**
     * 目前支持格式：.jpg .png .bmp
     * @param fileheader 文件头，当前版本最短匹配数组长度为12，建议最短长度为18
     * @return 图片格式后缀例如".jpg"
     */
    public static String getRealFormat(byte[] fileheader)
    {
        if(fileheader[0]==-1)
        {
            if(match(fileheader,"jpg"))
                return ".jpg";
        }
        else if(fileheader[0]==-119)
        {
            if(match(fileheader,"png"))
                return ".png";
        }
        else if(fileheader[0]==66)
        {
            if(match(fileheader,"bmp"))
                return ".bmp";
        }
        else return "";
        return "";
    }

    /**
     *
     * @param matchbytes
     * @param type
     * @return
     */
    private static boolean match(byte[] matchbytes,String type)
    {
        if(type.equals("jpg"))
        {
            for(int i=1;i<JPG_HEADER.length;i++)
            {
                if(matchbytes[i]!=JPG_HEADER[i])
                    return false;
            }
            return true;
        }
        else if(type.equals("png"))
        {
            for(int i=1;i<PNG_HEADER.length;i++)
            {
                if(matchbytes[i]!=PNG_HEADER[i])
                    return false;
            }
            return true;
        }
        else if(type.equals("bmp"))
        {
            matchbytes[2]=-99;
            matchbytes[3]=-99;
            matchbytes[4]=-99;
            for(int i=1;i<BMP_HEADER.length;i++)
            {
                if(matchbytes[i]!=BMP_HEADER[i])
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}

package com.fow.weixinutil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class WeiXinCheck {
    public static boolean check(String signature,String token,String timestamp,String nonce)
    {
        String[] tmpArr={token,timestamp,nonce};
        Arrays.sort(tmpArr);
        String tmpStr=tmpArr[0].concat(tmpArr[1]).concat(tmpArr[2]);
        System.out.println(tmpStr);
        try {
            MessageDigest mdTemp=MessageDigest.getInstance("SHA1");
            mdTemp.update(tmpStr.toString().getBytes("UTF-8"));
            byte[] md=mdTemp.digest();
            String mdStr=byteToStr(md);
            System.out.println(mdStr);
            if(signature.equals(mdStr))
                return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将字节数组转换为十六进制字符串.
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串.
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1' , '2', '3', '4' , '5', '6', '7' , '8', '9', 'a' , 'b', 'c', 'd' , 'e', 'f'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

}

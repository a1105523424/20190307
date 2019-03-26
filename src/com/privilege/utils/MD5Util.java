package com.privilege.utils;

import com.mchange.util.Base64Encoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
    private  static  String util="!";
    public static String MD5Encoding(String pass)   {
        //初始化MD5
        MessageDigest md5=null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //创建base64的编码格式
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encoder = null;
        try {
            pass = util+pass;
            encoder = base64Encoder.encode(md5.digest(pass.getBytes("utf-8")) );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encoder;
    }
}
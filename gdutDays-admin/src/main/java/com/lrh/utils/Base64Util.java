package com.lrh.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
public class Base64Util {
    public static String encode(String str){
        return Base64.encodeBase64String(str.getBytes());
    }

    public static String decode(String str){
        return new String(Base64.decodeBase64(str));
    }
}

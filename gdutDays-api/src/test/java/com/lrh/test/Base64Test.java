package com.lrh.test;

import com.lrh.utils.Base64Util;
import org.junit.Test;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
public class Base64Test {

    @Test
    public void test(){
        //System.out.println(Base64Util.encode("123456"));
        System.out.println(Base64Util.decode("MTIzNDU2"));
    }
}

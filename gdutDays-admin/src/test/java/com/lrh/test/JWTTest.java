package com.lrh.test;

import com.lrh.utils.JWTUtils;
import org.junit.Test;

import java.util.Map;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
public class JWTTest {
    @Test
    public void test(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY0ODE4NTIsInVzZXJJZCI6MiwiaWF0IjoxNjc2Mzk1NDUyfQ.hYBh7Ew-DyQFe4jYMfV3SR8ElWNdeAfN1q4a_XJ-BJk";
        Map<String, Object> map = JWTUtils.checkToken(token);
        System.out.println(map.get("userId"));
    }
}

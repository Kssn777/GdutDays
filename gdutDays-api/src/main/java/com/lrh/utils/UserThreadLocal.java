package com.lrh.utils;

import com.lrh.entity.User;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
public class UserThreadLocal {
    private UserThreadLocal(){}
    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();

    public static void put(User user){
        LOCAL.set(user);
    }

    public static User get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}

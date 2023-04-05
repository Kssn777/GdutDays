package com.lrh.handler;

import com.alibaba.fastjson.JSON;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.service.LoginService;
import com.lrh.utils.ErrorMsg;
import com.lrh.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 判断请求路径是否为Controller的方法
         * 判断token是否为空
         * 如果token不为空，登录验证  loginService checkToken
         * 如果验证成功  放行
         */
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if(StringUtils.isBlank(token)||token.equals("undefined")){
            Result result = Result.fail(ErrorMsg.NO_LOGIN.getCode(), null,ErrorMsg.NO_LOGIN.getMessage());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        User user = loginService.checkToken(token);//防止伪造token

        if(user==null){
            Result result = Result.fail(ErrorMsg.USER_EXPIRE.getCode(),null ,ErrorMsg.USER_EXPIRE.getMessage());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        UserThreadLocal.put(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //删除ThreadLocal  防止内存泄漏
        UserThreadLocal.remove();
    }

}

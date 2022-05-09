package com.time.album.timealbum.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liangpeibin
 * @ClassName LoginConfig
 * @Description
 * @since 2022/5/3 12:11
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new com.time.album.timealbum.interceptor.UserLoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/",
                "/user/userLogin",           //登录路径
                "/user/forgetPassword",      //忘记密码路径
                "/user/forgetPasswordDo",    //忘记密码修改路径
                "/user/userRegister",        //用户注册路径
                "/user/userRegisterDo",      //用户注册执行路径
                "/user/index",               //放行登录页
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                 //css静态资源
                "/**/*.jpg",                 //照片静态资源
                "/**/*.png"                  //照片静态资源

        );
    }
}

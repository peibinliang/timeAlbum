package com.time.album.timealbum.interceptor;

import com.time.album.timealbum.dto.resp.UserRespDto;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author liangpeibin
 * @ClassName UserLoginInterceptor
 * @Description 登录拦截器
 * @since 2022/5/3 12:02
 */
public class UserLoginInterceptor implements HandlerInterceptor {
    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器的preHandle方法");
        try {
            HttpSession session = request.getSession();
            //统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            UserRespDto user = (UserRespDto) session.getAttribute("user");
            if (user != null) {
                return true;
            }
            String msg = "您尚未登录或登录已失效！请先登录。";
            request.setAttribute("msg",msg);
            response.sendRedirect("http://localhost:8088/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }
}

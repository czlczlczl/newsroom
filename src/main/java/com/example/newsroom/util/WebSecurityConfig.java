package com.example.newsroom.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录配置
 *
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurationSupport {

    /**
     * 登录session key
     */
    public final static String SESSION_USERNAME = "username";
    public final static String SESSION_ROLE = "role";
    public final static String SESSION_ID = "id";
    public final static String SESSION_NAME = "name";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
//
//
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
//
//        // 排除配置
//        addInterceptor.excludePathPatterns("/");
//        addInterceptor.excludePathPatterns("/error");
//
//        addInterceptor.excludePathPatterns("/common/**");
//        addInterceptor.excludePathPatterns("/search/**");
//        addInterceptor.excludePathPatterns("/file/**");
//        addInterceptor.excludePathPatterns("/mail/**");
//
//        addInterceptor.excludePathPatterns("/contribute/**");
////        addInterceptor.excludePathPatterns("/admin/**");
//        addInterceptor.excludePathPatterns("/logout");
//        addInterceptor.excludePathPatterns("/");
//
//        addInterceptor.excludePathPatterns("/images/**");
//        addInterceptor.excludePathPatterns("/static/**");
//        addInterceptor.excludePathPatterns("/*.ico");
//        addInterceptor.excludePathPatterns("/*.js");
//        addInterceptor.excludePathPatterns("/*.css");
//        addInterceptor.excludePathPatterns("/*.png");
//        addInterceptor.excludePathPatterns("/*.json");
//        addInterceptor.excludePathPatterns("/workbox-v3.6.3/**");
//
//
//        // 拦截配置
//        addInterceptor.addPathPatterns("/**");
//    }
//
    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
            System.out.println(request.getRequestURI()+" | id:"+session.getAttribute(SESSION_ID)+" | username:"+session.getAttribute(SESSION_USERNAME)+" | role:"+session.getAttribute(SESSION_ROLE));

            if (session.getAttribute(SESSION_ID) == null && session.getAttribute(SESSION_USERNAME) == null && session.getAttribute(SESSION_ROLE) == null) {
                System.out.println(401);
//                跳转登录
//                String url = "/";
//                response.sendRedirect(url);
                response.setStatus(401);
                return false;
            }
//            权限判断
            if (session.getAttribute(SESSION_ROLE) != null && (int)session.getAttribute(SESSION_ROLE) != 0 && request.getRequestURI().contains("/admin/")){
                System.out.println(403);
                response.setStatus(403);
                return false;
            }
            return true;
        }
    }
//
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:./file/公告图片/");
        super.addResourceHandlers(registry);
    }
}
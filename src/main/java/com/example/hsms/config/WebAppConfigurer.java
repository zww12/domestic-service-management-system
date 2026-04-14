package com.example.hsms.config;

import com.example.hsms.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/7
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    // 跨域配置（允许所有来源）
    @Override
 public void addCorsMappings(CorsRegistry registry)
    {registry.addMapping("/**").allowedOriginPatterns("*").allowCredentials(true).allowedMethods("GET", "HEAD", "POST", "PUT",
                "DELETE","OPTIONS").maxAge(3600);}

    // 静态资源映射（本地磁盘→URL）
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:D:\\bisheimage\\swiperImgs\\");
        registry.addResourceHandler("/image/bigType/**").addResourceLocations("file:D:\\bisheimage\\bigTypeImgs\\");
        registry.addResourceHandler("/image/worker/**").addResourceLocations("file:D:\\bisheimage\\workerImgs\\");

    }
    // JWT拦截器配置
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }

    // 注册拦截器：拦截所有路径，排除白名单
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       String[] patterns=new String[]
//                {"/back/login","/worker/**","/findall","/login","/findCategories","/reserve","/comment","/admin/worker","/findallsmall","/admin/user","/admin/smallType","/admin/bigType","/collection","/api/chat"};
//registry.addInterceptor(sysInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
        String[] patterns=new String[]
                {"/back/login","/worker/**","/findall","/login","/findCategories","/findallsmall","/api/chat/ask"};
        registry.addInterceptor(sysInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
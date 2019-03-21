package com.wzq.labsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置静态资源访问权限
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    //获取配置文件的路径
    @Value("${fileUpload.location.path}")
    private String resourceDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置文件上传资源访问
        registry.addResourceHandler(resourceDir + "**")
                .addResourceLocations("file:" + System.getProperty("user.dir").replace("\\","/") + resourceDir);
        super.addResourceHandlers(registry);
    }
}


package com.testing.boottesting.config;

import com.testing.boottesting.interceptors.BasicAuthHandlerInterceptor;
import com.testing.boottesting.interceptors.LogHandlerInterceptor;
import com.testing.boottesting.post.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.Executors;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final PropConfig propConfig;

    public WebConfig(PropConfig propConfig) {
        this.propConfig = propConfig;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BasicAuthHandlerInterceptor())
                .order(1)
                .addPathPatterns("/employee");

        registry.addInterceptor(new LogHandlerInterceptor(propConfig))
                .order(2)
                .addPathPatterns("/employee/**");
    }

    @Bean(initMethod = "init")
    public PostService postService() {
        return new PostService();
    }
}

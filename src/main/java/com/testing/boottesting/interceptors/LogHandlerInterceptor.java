package com.testing.boottesting.interceptors;

import com.testing.boottesting.config.PropConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
public class LogHandlerInterceptor implements HandlerInterceptor {

    private final PropConfig propConfig;

    public LogHandlerInterceptor(PropConfig propConfig) {
        this.propConfig = propConfig;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(propConfig.getHost() + ":" + propConfig.getPort());
        log.info("List " +propConfig.getList().toString());
        return true;
    }
}

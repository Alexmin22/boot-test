package com.testing.boottesting.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthHandlerInterceptor implements HandlerInterceptor {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if(StringUtils.hasText(authorization) && authorization.startsWith("Basic ")) {
            String base64Creds = authorization.substring("Basic ".length());
            String[] credentials = new String(Base64.getDecoder().decode(base64Creds), StandardCharsets.UTF_8)  //admin:admin
                    .split(":");
            if(USERNAME.equals(credentials[0]) && PASSWORD.equals(credentials[1])) {
                return true;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false;
    }
}

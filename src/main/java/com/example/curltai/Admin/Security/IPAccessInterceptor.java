package com.example.curltai.Admin.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class IPAccessInterceptor implements HandlerInterceptor {

    private static final String ALLOWED_IP = "192.168.0.107"; // Replace with your server's IP address

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String clientIp = request.getRemoteAddr();
        if (!clientIp.equals(ALLOWED_IP)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
            return false;
        }
        return true;
    }
}

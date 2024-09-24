package com.kdg.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomExceptionHandlingFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        // 예외가 발생하면 예외 메시지를 request에 설정
        if (failed.getCause() instanceof AccountLockedException) {
            request.setAttribute("errorMessage", failed.getCause().getMessage());
        }

        // 기본 인증 실패 처리 로직 호출
        super.unsuccessfulAuthentication(request, response, failed);
    }
}

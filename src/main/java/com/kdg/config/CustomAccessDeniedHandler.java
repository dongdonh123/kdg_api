package com.kdg.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
            throws IOException {

        // 요청한 URI 확인
        String requestURI = request.getRequestURI();

        // 경로에 따른 필요한 권한 설정
        Map<String, String[]> requiredPermissionsMap = new HashMap<>();
        requiredPermissionsMap.put("/admin", new String[]{"ADMIN"});
        requiredPermissionsMap.put("/board", new String[]{"BOARD"});
        // 다른 경로도 추가 가능

        // 요청 경로에 맞는 권한 정보 가져오기
        String[] requiredPermissions = requiredPermissionsMap.getOrDefault(requestURI, new String[]{"UNKNOWN"});

        // 403 상태 코드 설정
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        // 응답 형식을 JSON으로 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 필요한 권한을 동적으로 JSON 메시지에 포함
        String jsonResponse = String.format("{\"status\": 403, \"message\": \"You do not have the required permissions to access this resource.\", " +
                "\"required_permissions\": %s}", arrayToJsonString(requiredPermissions));

        // 응답 본문 작성
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
        writer.close();
    }

    // 배열을 JSON 배열로 변환하는 헬퍼 메소드
    private String arrayToJsonString(String[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("\"").append(array[i]).append("\"");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
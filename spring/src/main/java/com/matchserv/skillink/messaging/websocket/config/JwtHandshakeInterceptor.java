package com.matchserv.skillink.messaging.websocket.config;

import com.matchserv.skillink.security.core.JwtTokenService;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.*;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    private final JwtTokenService jwt;

    @Override
    public boolean beforeHandshake(@NonNull ServerHttpRequest req,@NonNull ServerHttpResponse res,
                                   @NonNull WebSocketHandler wsHandler,@NonNull Map<String, Object> attrs) {
        if (req instanceof ServletServerHttpRequest servletReq) {
            String token = servletReq.getServletRequest().getParameter("token");
            if (token != null) {
                try {
                    Claims claims = jwt.parseAndValidate(token).getBody();
                    attrs.put("email", claims.getSubject());
                    attrs.put("role", claims.get("role"));
                    return true;
                } catch (Exception e) {
                    return false; // token invalide => refuser handshake si tu veux
                }
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(@NonNull ServerHttpRequest request,@NonNull ServerHttpResponse response,
                               @NonNull WebSocketHandler wsHandler, Exception exception) {}
}

package com.matchserv.skillink.api.controllers;

import com.matchserv.skillink.api.dto.auth.*;
import com.matchserv.skillink.data.models.User;
import com.matchserv.skillink.data.repositories.UserRepository;
import com.matchserv.skillink.security.core.JwtTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenService jwt;
    private final PasswordEncoder encoder;
    private final UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody RegisterRequest req) {
        if (userRepo.findByEmail(req.email()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        User u = new User();
        u .setUsername(req.username());
        u.setEmail(req.email());
        u.setPasswordHash(encoder.encode(req.password()));
        userRepo.save(u);

        var access = jwt.generateAccessToken(u.getEmail(), Map.of("username", u.getUsername(), "role", u.getRole() == null ? "USER" : u.getRole().name()));
        var refresh = jwt.generateRefreshToken(u.getEmail());
        return ResponseEntity.ok(new TokenResponse(access, refresh, "Bearer", 60L*60L));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest req) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.email(), req.password()));
        String email = authentication.getName();
        User u = userRepo.findByEmail(email).orElseThrow();
        var access = jwt.generateAccessToken(email, Map.of("username", u.getUsername(), "role", u.getRole() == null ? "USER" : u.getRole().name()));
        var refresh = jwt.generateRefreshToken(email);
        return ResponseEntity.ok(new TokenResponse(access, refresh, "Bearer", 60L*60L));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody Map<String,String> body) {
        String refresh = body.get("refreshToken");
        if (refresh == null) return ResponseEntity.badRequest().build();
        var claims = jwt.parseAndValidate(refresh).getBody();
        String email = claims.getSubject();
        User u = userRepo.findByEmail(email).orElseThrow();
        var access = jwt.generateAccessToken(email, Map.of("username", u.getUsername(), "role", u.getRole() == null ? "USER" : u.getRole().name()));
        return ResponseEntity.ok(new TokenResponse(access, refresh, "Bearer", 60L*60L));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String,Object>> me(Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).build();
        User u = userRepo.findByEmail(auth.getName()).orElseThrow();
        return ResponseEntity.ok(Map.of(
                "id", u.getId(),
                "username", u.getUsername(),
                "email", u.getEmail(),
                "role", u.getRole(),
                "points", u.getPoints()
        ));
    }
}

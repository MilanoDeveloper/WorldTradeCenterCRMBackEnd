package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.dto.request.LoginRequest;
import br.com.fiap.wtc.work.dto.response.LoginResponse;
import br.com.fiap.wtc.work.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {

        return ResponseEntity.ok(authService.login(request));
    }
}
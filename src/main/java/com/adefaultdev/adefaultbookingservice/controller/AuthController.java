package com.adefaultdev.adefaultbookingservice.controller;

import com.adefaultdev.adefaultbookingservice.dto.AuthResponseDto;
import com.adefaultdev.adefaultbookingservice.dto.LoginRequestDto;
import com.adefaultdev.adefaultbookingservice.dto.RegisterRequestDto;
import com.adefaultdev.adefaultbookingservice.dto.UserResponseDto;
import com.adefaultdev.adefaultbookingservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(
            @Valid @RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(
            @Valid @RequestBody RegisterRequestDto dto) {
        return authService.register(dto);
    }
}
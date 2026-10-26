package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.AuthResponseDto;
import com.adefaultdev.adefaultbookingservice.dto.LoginRequestDto;
import com.adefaultdev.adefaultbookingservice.dto.RegisterRequestDto;
import com.adefaultdev.adefaultbookingservice.dto.UserResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.User;
import com.adefaultdev.adefaultbookingservice.enums.Role;
import com.adefaultdev.adefaultbookingservice.exceptions.EmailAlreadyExistsException;
import com.adefaultdev.adefaultbookingservice.repository.UserRepository;
import com.adefaultdev.adefaultbookingservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDto login(LoginRequestDto dto) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(),
                        dto.password()
                )
        );

        String token = jwtService.generateToken(authentication);

        return new AuthResponseDto(token);
    }

    public UserResponseDto register(RegisterRequestDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException(dto.email());
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}
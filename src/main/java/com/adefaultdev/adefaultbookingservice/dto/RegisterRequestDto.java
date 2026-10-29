package com.adefaultdev.adefaultbookingservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO returned when a registration is requested.
 *
 * @author AdefaultDev
 * @since 1.0
 */
public record RegisterRequestDto(
        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        @Email
        @Size(max = 254)
        String email,

        @NotBlank
        @Size(min = 8, max = 72)
        String password
) {}
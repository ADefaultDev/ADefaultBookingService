package com.adefaultdev.adefaultbookingservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO returned when a booking is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
public record LoginRequestDto(
        @Email @NotBlank String email,
        @NotBlank String password
) {}
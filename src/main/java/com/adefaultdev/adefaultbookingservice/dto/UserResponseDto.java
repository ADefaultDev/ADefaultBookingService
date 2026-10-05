package com.adefaultdev.adefaultbookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO returned when a user is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;
}
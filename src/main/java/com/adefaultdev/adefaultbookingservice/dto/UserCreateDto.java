package com.adefaultdev.adefaultbookingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO used for creating a new user.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    private String name;

    private String email;

    private String password;
}
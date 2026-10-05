package com.adefaultdev.adefaultbookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO returned when an address is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class AddressResponseDto {

    private Long id;

    private String country;

    private String city;

    private String street;

    private String houseNumber;
}

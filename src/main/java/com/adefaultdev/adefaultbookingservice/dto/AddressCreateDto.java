package com.adefaultdev.adefaultbookingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO used for creating a new address.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class AddressCreateDto {

    private String country;

    private String city;

    private String street;

    private String houseNumber;
}

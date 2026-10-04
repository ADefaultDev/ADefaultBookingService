package com.adefaultdev.adefaultbookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressResponseDto {

    private Long id;

    private String country;

    private String city;

    private String street;

    private String houseNumber;
}

package com.adefaultdev.adefaultbookingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressCreateDto {

    private String country;

    private String city;

    private String street;

    private String houseNumber;
}

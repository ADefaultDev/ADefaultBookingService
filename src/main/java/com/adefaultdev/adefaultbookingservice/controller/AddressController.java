package com.adefaultdev.adefaultbookingservice.controller;

import com.adefaultdev.adefaultbookingservice.dto.AddressCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.AddressResponseDto;
import com.adefaultdev.adefaultbookingservice.exception.AddressNotFoundException;
import com.adefaultdev.adefaultbookingservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressResponseDto createAddress(
            @RequestBody AddressCreateDto dto) {

        return addressService.createAddress(dto);
    }

    @PutMapping("/{id}")
    public AddressResponseDto editAddress(
            @PathVariable Long id,
            @RequestBody AddressCreateDto dto) {

        return addressService.editAddress(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}


package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.AddressCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.AddressResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Address;
import com.adefaultdev.adefaultbookingservice.exception.AddressNotFoundException;
import com.adefaultdev.adefaultbookingservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Provides business logic for managing addresses.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressResponseDto createAddress(AddressCreateDto dto) {

        Address address = new Address();

        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());

        Address savedAddress = addressRepository.save(address);

        return toResponseDto(savedAddress);
    }

    public List<AddressResponseDto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public AddressResponseDto getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        return toResponseDto(address);
    }

    public AddressResponseDto editAddress(
            Long id,
            AddressCreateDto dto) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());

        Address updatedAddress = addressRepository.save(address);

        return toResponseDto(updatedAddress);
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException(id);
        }
        addressRepository.deleteById(id);
    }

    private AddressResponseDto toResponseDto(Address address) {
        return new AddressResponseDto(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getHouseNumber()
        );
    }
}

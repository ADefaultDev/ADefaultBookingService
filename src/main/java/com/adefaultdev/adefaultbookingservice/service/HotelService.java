package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.HotelCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.HotelResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Hotel;
import com.adefaultdev.adefaultbookingservice.exceptions.HotelNotFoundException;
import com.adefaultdev.adefaultbookingservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Provides business logic for managing hotels.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelResponseDto createHotel(HotelCreateDto hotelCreateDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelCreateDto.getName());
        hotel.setAddress(hotelCreateDto.getAddress());
        hotel.setRooms(hotelCreateDto.getRooms());
        hotel.setHotelRating(hotelCreateDto.getHotelRating());

        Hotel savedHotel = hotelRepository.save(hotel);

        return toResponseDto(savedHotel);

    }

    public HotelResponseDto editHotel(
            Long id,
            HotelCreateDto dto) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotel.setName(dto.getName());
        hotel.setAddress(dto.getAddress());
        hotel.setRooms(dto.getRooms());
        hotel.setHotelRating(dto.getHotelRating());

        Hotel updatedHotel = hotelRepository.save(hotel);

        return toResponseDto(updatedHotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)){
            throw new HotelNotFoundException(id);
        }
        hotelRepository.deleteById(id);
    }

    public HotelResponseDto toResponseDto(Hotel hotel){
        return new HotelResponseDto(
                hotel.getId(),
                hotel.getRooms(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getHotelRating()
        );
    }
}

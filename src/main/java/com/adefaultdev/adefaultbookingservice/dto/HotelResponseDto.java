package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Address;
import com.adefaultdev.adefaultbookingservice.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

/**
 * DTO returned when a hotel is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class HotelResponseDto {

    private Long id;

    private List<Room> rooms;

    private String name;

    private Address address;

    private int hotelRating;
}

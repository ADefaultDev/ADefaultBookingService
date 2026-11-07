package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Address;
import com.adefaultdev.adefaultbookingservice.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * DTO used for creating a new hotel.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class HotelCreateDto {

    private List<Room> rooms;

    private String name;

    private Address address;

    private int hotelRating;
}



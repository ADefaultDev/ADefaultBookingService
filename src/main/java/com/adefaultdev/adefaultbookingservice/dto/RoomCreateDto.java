package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Address;
import com.adefaultdev.adefaultbookingservice.entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO used for creating a new room.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class RoomCreateDto {

    private int capacity;

    private Hotel hotel;

    private int number;
}


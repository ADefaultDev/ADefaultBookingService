package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO returned when a room is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class RoomResponseDto {

    private Long id;

    private String name;

    private int capacity;

    private Address address;

    private int number;
}


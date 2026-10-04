package com.adefaultdev.adefaultbookingservice.dto;

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

    private String name;

    private int capacity;
}


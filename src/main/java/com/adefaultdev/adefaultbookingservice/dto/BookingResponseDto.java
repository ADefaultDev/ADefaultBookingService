package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.entity.User;
import com.adefaultdev.adefaultbookingservice.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * DTO returned when a booking is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class BookingResponseDto {

    private Long id;

    private Date date;

    private BookingStatus bookingStatus;

    private Room room;

    private User user;
}

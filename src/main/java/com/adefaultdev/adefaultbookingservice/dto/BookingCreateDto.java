package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.entity.User;
import com.adefaultdev.adefaultbookingservice.enums.BookingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * DTO used for creating a new booking.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class BookingCreateDto {

    private Date date;

    private BookingStatus bookingStatus;

    private Room room;

    private User user;
}
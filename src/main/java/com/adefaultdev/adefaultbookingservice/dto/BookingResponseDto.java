package com.adefaultdev.adefaultbookingservice.dto;

import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * DTO returned when a booking is requested or created.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Getter
@NoArgsConstructor
public class BookingResponseDto {

    private Date date;

    private Room room;

    private User user;
}

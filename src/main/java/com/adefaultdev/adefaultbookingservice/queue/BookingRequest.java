package com.adefaultdev.adefaultbookingservice.queue;

import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.entity.User;

import java.time.LocalDateTime;

/**
 * Represents a booking request waiting to be processed.
 *
 * @author AdefaultDev
 * @since 1.0
 */
public record BookingRequest(
        User user,
        Room room,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
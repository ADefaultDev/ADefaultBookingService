package com.adefaultdev.adefaultbookingservice.queue;

import java.time.LocalDateTime;

/**
 * Represents a booking request waiting to be processed.
 *
 * @author AdefaultDev
 * @since 1.0
 */
public record BookingRequest(
        Long userId,
        Long roomId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
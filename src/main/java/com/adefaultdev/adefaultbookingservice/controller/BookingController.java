package com.adefaultdev.adefaultbookingservice.controller;

import com.adefaultdev.adefaultbookingservice.dto.BookingCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.BookingResponseDto;
import com.adefaultdev.adefaultbookingservice.queue.BookingQueue;
import com.adefaultdev.adefaultbookingservice.queue.BookingRequest;
import com.adefaultdev.adefaultbookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * The controller for managing bookings.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingQueue bookingQueue;
    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createBooking(
            @RequestBody BookingCreateDto dto) {

        BookingRequest request = new BookingRequest(
                dto.getUser(),
                dto.getRoom(),
                dto.getStartTime(),
                dto.getEndTime()
        );

        boolean added = bookingQueue.add(request);

        if (!added) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "Booking queue is full"
            );
        }
    }

    @PutMapping("/{id}")
    public BookingResponseDto editBooking(
            @PathVariable Long id,
            @RequestBody BookingCreateDto dto) {

        return bookingService.editBooking(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

}
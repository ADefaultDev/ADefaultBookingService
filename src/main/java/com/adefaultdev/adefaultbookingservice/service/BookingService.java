package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.BookingCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.BookingResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Booking;
import com.adefaultdev.adefaultbookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingResponseDto createBooking(BookingCreateDto bookingCreateDto) {
        Booking booking = new Booking();
        booking.setUser(bookingCreateDto.getUser());
        booking.setRoom(bookingCreateDto.getRoom());
        booking.setDate(bookingCreateDto.getDate());

        Booking savedBooking = bookingRepository.save(booking);

        return new BookingResponseDto(

        );

    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
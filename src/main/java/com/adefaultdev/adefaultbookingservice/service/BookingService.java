package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.BookingCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.BookingResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Booking;
import com.adefaultdev.adefaultbookingservice.exceptions.BookingNotFoundException;
import com.adefaultdev.adefaultbookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Provides business logic for managing bookings.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingResponseDto createBooking(BookingCreateDto bookingCreateDto) {
        Booking booking = new Booking();
        booking.setUser(bookingCreateDto.getUser());
        booking.setRoom(bookingCreateDto.getRoom());
        booking.setBookingStatus(bookingCreateDto.getBookingStatus());
        booking.setDate(bookingCreateDto.getDate());

        Booking savedBooking = bookingRepository.save(booking);

        return toResponseDto(savedBooking);

    }

    public BookingResponseDto editBooking(
            Long id,
            BookingCreateDto dto) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        booking.setBookingStatus(dto.getBookingStatus());
        booking.setRoom(dto.getRoom());
        booking.setUser(dto.getUser());
        booking.setDate(dto.getDate());

        Booking updatedBooking = bookingRepository.save(booking);

        return toResponseDto(updatedBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        if(!bookingRepository.existsById(id)){
            throw new BookingNotFoundException(id);
        }
        return bookingRepository.findById(id);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)){
            throw new BookingNotFoundException(id);
        }
        bookingRepository.deleteById(id);
    }

    public BookingResponseDto toResponseDto(Booking booking){
        return new BookingResponseDto(
                booking.getId(),
                booking.getDate(),
                booking.getBookingStatus(),
                booking.getRoom(),
                booking.getUser()
        );
    }
}
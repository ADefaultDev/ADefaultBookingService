package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.BookingCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.BookingResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Booking;
import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.entity.User;
import com.adefaultdev.adefaultbookingservice.enums.BookingStatus;
import com.adefaultdev.adefaultbookingservice.exceptions.BookingNotFoundException;
import com.adefaultdev.adefaultbookingservice.exceptions.RoomNotFoundException;
import com.adefaultdev.adefaultbookingservice.exceptions.UserNotFoundException;
import com.adefaultdev.adefaultbookingservice.queue.BookingRequest;
import com.adefaultdev.adefaultbookingservice.repository.BookingRepository;
import com.adefaultdev.adefaultbookingservice.repository.RoomRepository;
import com.adefaultdev.adefaultbookingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingResponseDto createBooking(BookingCreateDto bookingCreateDto) {
        Booking booking = new Booking();
        booking.setUser(bookingCreateDto.getUser());
        booking.setRoom(bookingCreateDto.getRoom());
        booking.setBookingStatus(bookingCreateDto.getBookingStatus());
        booking.setDate(bookingCreateDto.getDate());
        booking.setStartTime(bookingCreateDto.getStartTime());
        booking.setEndTime(bookingCreateDto.getEndTime());

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

    @Transactional
    public void processBooking(BookingRequest request) {

        User user = userRepository.findById(request.user())
                .orElseThrow(() ->
                        new UserNotFoundException(request.user()));

        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(() ->
                        new RoomNotFoundException(request.roomId()));

        if (!request.startTime().isBefore(request.endTime())) {
            throw new IllegalArgumentException(
                    "Start time must be before end time");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartTime(request.startTime());
        booking.setEndTime(request.endTime());
        booking.setBookingStatus(BookingStatus.CONFIRMED);

        bookingRepository.save(booking);
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
                booking.getUser(),
                booking.getStartTime(),
                booking.getEndTime()
        );
    }
}
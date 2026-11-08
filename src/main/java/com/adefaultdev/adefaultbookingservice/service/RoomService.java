package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.RoomCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.RoomResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Room;
import com.adefaultdev.adefaultbookingservice.exceptions.RoomNotFoundException;
import com.adefaultdev.adefaultbookingservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Provides business logic for managing rooms.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponseDto createRoom(RoomCreateDto roomCreateDto) {
        Room room = new Room();
        room.setCapacity(roomCreateDto.getCapacity());
        room.setHotel(roomCreateDto.getHotel());
        Room savedRoom = roomRepository.save(room);

        return toResponseDto(savedRoom);

    }

    public RoomResponseDto editRoom(
            Long id,
            RoomCreateDto dto) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));

        room.setCapacity(dto.getCapacity());
        room.setNumber(dto.getNumber());

        Room updatedRoom = roomRepository.save(room);

        return toResponseDto(updatedRoom);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)){
            throw new RoomNotFoundException(id);
        }
        roomRepository.deleteById(id);
    }

    public RoomResponseDto toResponseDto(Room room){
        return new RoomResponseDto(
                room.getId(),
                room.getCapacity(),
                room.getHotel(),
                room.getNumber()
        );
    }
}
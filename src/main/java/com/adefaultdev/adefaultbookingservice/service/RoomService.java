package com.adefaultdev.adefaultbookingservice.service;

import com.adefaultdev.adefaultbookingservice.dto.RoomCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.RoomResponseDto;
import com.adefaultdev.adefaultbookingservice.entity.Room;
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
        room.setName(roomCreateDto.getName());
        room.setCapacity(roomCreateDto.getCapacity());

        Room savedRoom = roomRepository.save(room);

        return new RoomResponseDto(
                savedRoom.getId(),
                savedRoom.getName(),
                savedRoom.getCapacity()
        );

    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
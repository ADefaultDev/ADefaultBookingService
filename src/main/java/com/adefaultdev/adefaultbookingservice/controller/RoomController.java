package com.adefaultdev.adefaultbookingservice.controller;

import com.adefaultdev.adefaultbookingservice.dto.RoomCreateDto;
import com.adefaultdev.adefaultbookingservice.dto.RoomResponseDto;
import com.adefaultdev.adefaultbookingservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for managing rooms.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public RoomResponseDto createRoom(
            @RequestBody RoomCreateDto dto) {

        return roomService.createRoom(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public RoomResponseDto editRoom(
            @PathVariable Long id,
            @RequestBody RoomCreateDto dto) {

        return roomService.editRoom(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
package com.adefaultdev.adefaultbookingservice.repository;

import com.adefaultdev.adefaultbookingservice.entity.Booking;
import com.adefaultdev.adefaultbookingservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing {@link Room} entities.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
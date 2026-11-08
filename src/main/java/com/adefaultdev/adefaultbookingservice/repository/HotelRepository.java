package com.adefaultdev.adefaultbookingservice.repository;

import com.adefaultdev.adefaultbookingservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing {@link Hotel} entities.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

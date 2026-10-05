package com.adefaultdev.adefaultbookingservice.repository;


import com.adefaultdev.adefaultbookingservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing {@link Address} entities.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

package com.adefaultdev.adefaultbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adefaultdev.adefaultbookingservice.entity.User;
import java.util.Optional;

/**
 * Repository for managing {@link User} entities.
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
package com.scheculerpoint.scheculerpoint.repository;

import com.scheculerpoint.scheculerpoint.domain.User;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginRole(EnumUserRole role);
}

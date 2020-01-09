package com.scheculerpoint.scheculerpoint.repository;

import com.scheculerpoint.scheculerpoint.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
}

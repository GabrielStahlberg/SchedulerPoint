package com.scheculerpoint.scheculerpoint.repository;

import com.scheculerpoint.scheculerpoint.domain.Movimentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentationRepository extends JpaRepository<Movimentation, Long> {
}

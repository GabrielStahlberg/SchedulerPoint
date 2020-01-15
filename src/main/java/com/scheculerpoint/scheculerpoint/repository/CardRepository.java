package com.scheculerpoint.scheculerpoint.repository;

import com.scheculerpoint.scheculerpoint.domain.Card;
import com.scheculerpoint.scheculerpoint.domain.Category;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}

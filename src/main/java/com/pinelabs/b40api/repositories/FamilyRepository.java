package com.pinelabs.b40api.repositories;

import com.pinelabs.b40api.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}

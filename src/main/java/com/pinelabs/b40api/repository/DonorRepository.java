package com.pinelabs.b40api.repository;

import com.pinelabs.b40api.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
}

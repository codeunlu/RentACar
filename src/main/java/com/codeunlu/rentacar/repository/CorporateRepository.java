package com.codeunlu.rentacar.repository;

import com.codeunlu.rentacar.model.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepository extends JpaRepository<Corporate,Long> {
}

package com.codeunlu.rentacar.repository;

import com.codeunlu.rentacar.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
}

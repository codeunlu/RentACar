package com.codeunlu.rentacar.repository.users;

import com.codeunlu.rentacar.model.users.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
}

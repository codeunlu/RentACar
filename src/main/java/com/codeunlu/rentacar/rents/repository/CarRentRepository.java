package com.codeunlu.rentacar.rents.repository;

import com.codeunlu.rentacar.rents.model.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentRepository extends JpaRepository<CarRent,Long> {
    CarRent findByCarId(Long id);
}

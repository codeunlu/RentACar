package com.codeunlu.rentacar.cars.repository;

import com.codeunlu.rentacar.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
    Car findByTitle(String title);
}

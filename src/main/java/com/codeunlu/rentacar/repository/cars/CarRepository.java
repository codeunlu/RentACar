package com.codeunlu.rentacar.repository.cars;

import com.codeunlu.rentacar.model.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}

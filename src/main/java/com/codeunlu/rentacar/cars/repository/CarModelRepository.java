package com.codeunlu.rentacar.cars.repository;

import com.codeunlu.rentacar.cars.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
    CarModel findByName(String name);
}

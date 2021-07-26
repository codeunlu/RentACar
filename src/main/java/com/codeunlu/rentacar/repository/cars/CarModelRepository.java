package com.codeunlu.rentacar.repository.cars;

import com.codeunlu.rentacar.model.cars.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
}

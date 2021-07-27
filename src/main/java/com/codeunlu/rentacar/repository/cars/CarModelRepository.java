package com.codeunlu.rentacar.repository.cars;

import com.codeunlu.rentacar.model.cars.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
    List<CarModel> findByCarBrandId(Long id);
}

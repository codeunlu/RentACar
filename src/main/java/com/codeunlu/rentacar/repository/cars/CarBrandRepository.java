package com.codeunlu.rentacar.repository.cars;

import com.codeunlu.rentacar.model.cars.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
}

package com.codeunlu.rentacar.cars.repository;

import com.codeunlu.rentacar.cars.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    CarBrand findByName(String name);
}

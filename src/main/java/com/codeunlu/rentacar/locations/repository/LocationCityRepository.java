package com.codeunlu.rentacar.locations.repository;

import com.codeunlu.rentacar.locations.model.LocationCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationCityRepository extends JpaRepository<LocationCity,Long> {
    LocationCity findByTitle(String title);
}

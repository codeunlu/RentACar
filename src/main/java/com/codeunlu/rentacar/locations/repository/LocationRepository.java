package com.codeunlu.rentacar.locations.repository;

import com.codeunlu.rentacar.locations.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
    Location findByTitle(String title);
}

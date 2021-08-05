package com.codeunlu.rentacar.locations.model;

import com.codeunlu.rentacar.cars.model.Car;
import com.codeunlu.rentacar.rents.model.CarRent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "location_city_id", referencedColumnName = "id")
    private LocationCity locationCity;

    @OneToOne(mappedBy = "location")
    private CarRent carRent;


    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}

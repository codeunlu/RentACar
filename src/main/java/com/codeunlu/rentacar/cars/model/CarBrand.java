package com.codeunlu.rentacar.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"cars","carModels"})
@Table(name = "car_brands")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "carBrand",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<CarModel> carModels;

    @OneToMany(mappedBy = "carBrand",fetch = FetchType.LAZY)
    private Set<Car> cars;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

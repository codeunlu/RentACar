package com.codeunlu.rentacar.model.cars;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "cars_brands")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "carBrand",cascade = CascadeType.ALL)
    private Set<CarModel> carModels;

    @OneToMany(mappedBy = "carBrand")
    private Set<Car> cars;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

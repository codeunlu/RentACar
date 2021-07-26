package com.codeunlu.rentacar.model.cars;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "cars_models")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @OneToMany(mappedBy = "carModel")
    private Set<Car> cars;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

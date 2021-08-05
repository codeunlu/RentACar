package com.codeunlu.rentacar.cars.model;

import com.codeunlu.rentacar.cars.model.enums.CarCaseType;
import com.codeunlu.rentacar.cars.model.enums.Fuel;
import com.codeunlu.rentacar.cars.model.enums.Gear;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_brand_id",nullable = false)
    private CarBrand carBrand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_model_id",nullable = false)
    private CarModel carModel;

    @Column(name = "car_year")
    private Long carYear;

    @Enumerated
    @Column(name = "car_fuel")
    private Fuel fuel;

    @Enumerated
    @Column(name = "car_gear")
    private Gear gear;

    @Enumerated
    @Column(name = "car_case_type")
    private CarCaseType carCaseType;

    @Column(name = "car_door")
    private Long carDoor;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

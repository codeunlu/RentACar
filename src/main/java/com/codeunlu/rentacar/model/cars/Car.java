package com.codeunlu.rentacar.model.cars;

import com.codeunlu.rentacar.model.enums.CarCaseType;
import com.codeunlu.rentacar.model.enums.Fuel;
import com.codeunlu.rentacar.model.enums.Gear;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    /* Brand */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_brand_id",nullable = false)
    private CarBrand carBrand;

    /* Model */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_model_id",nullable = false)
    private CarModel carModel;

    @Column(name = "car_year")
    private Long carYear;

    /* Fuel */
    @Enumerated
    @Column(name = "car_fuel")
    private Fuel fuel;

    /* Gear */
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

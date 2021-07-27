package com.codeunlu.rentacar.dto.cars.create;

import com.codeunlu.rentacar.model.cars.CarBrand;
import com.codeunlu.rentacar.model.cars.CarModel;
import com.codeunlu.rentacar.model.enums.CarCaseType;
import com.codeunlu.rentacar.model.enums.Fuel;
import com.codeunlu.rentacar.model.enums.Gear;


public class CreateCarDto {
    private Long id;

    private String title;

    private CarBrand carBrand;

    private CarModel carModel;

    private Long carYear;

    private Fuel fuel;

    private Gear gear;

    private CarCaseType carCaseType;

    private Long carDoor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Long getCarYear() {
        return carYear;
    }

    public void setCarYear(Long carYear) {
        this.carYear = carYear;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public CarCaseType getCarCaseType() {
        return carCaseType;
    }

    public void setCarCaseType(CarCaseType carCaseType) {
        this.carCaseType = carCaseType;
    }

    public Long getCarDoor() {
        return carDoor;
    }

    public void setCarDoor(Long carDoor) {
        this.carDoor = carDoor;
    }
}

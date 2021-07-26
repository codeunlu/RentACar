package com.codeunlu.rentacar.dto.create;

import com.codeunlu.rentacar.model.cars.CarModel;
import java.util.Set;

public class CreateBrandDto {
    private Long id;
    private String name;
    private Set<CarModel> carModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(Set<CarModel> carModels) {
        this.carModels = carModels;
    }
}

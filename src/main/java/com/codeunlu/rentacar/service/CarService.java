package com.codeunlu.rentacar.service;

import com.codeunlu.rentacar.dto.create.CreateBrandDto;
import com.codeunlu.rentacar.dto.create.CreateCarDto;
import com.codeunlu.rentacar.dto.create.CreateModelDto;
import com.codeunlu.rentacar.model.cars.Car;
import com.codeunlu.rentacar.model.cars.CarBrand;
import com.codeunlu.rentacar.model.cars.CarModel;
import com.codeunlu.rentacar.repository.cars.CarBrandRepository;
import com.codeunlu.rentacar.repository.cars.CarModelRepository;
import com.codeunlu.rentacar.repository.cars.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarModelRepository carModelRepository;
    private final CarBrandRepository carBrandRepository;
    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, CarModelRepository carModelRepository,
                      CarBrandRepository carBrandRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.carModelRepository = carModelRepository;
        this.carBrandRepository = carBrandRepository;
        this.modelMapper = modelMapper;
    }

    public CreateBrandDto createBrands(CreateBrandDto createBrandDto){
        CarBrand carBrand = modelMapper.map(createBrandDto,CarBrand.class);
        return modelMapper.map(carBrandRepository.save(carBrand),CreateBrandDto.class);
    }

    public CreateModelDto createModels(Long id,CreateModelDto createModelDto){
        Optional<CarBrand> carBrand = carBrandRepository.findById(id);
        if(carBrand.isPresent()){
            CarModel carModel = modelMapper.map(createModelDto,CarModel.class);
            carModel.setCarBrand(carBrand.get());
            return modelMapper.map(carModelRepository.save(carModel),CreateModelDto.class);
        }
        return null;
    }

    public CreateCarDto createCars(CreateCarDto createCarDto) {
        Optional<CarBrand> carBrand = carBrandRepository.findById(createCarDto.getCarBrand().getId());
        Optional<CarModel> carModel = carModelRepository.findById(createCarDto.getCarModel().getId());
        Car car = modelMapper.map(createCarDto,Car.class);
        if(carBrand.isPresent() && carModel.isPresent()){
            return modelMapper.map(carRepository.save(car),CreateCarDto.class);
        }
        return null;
    }
}

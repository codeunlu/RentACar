package com.codeunlu.rentacar.cars.service;

import com.codeunlu.rentacar.cars.dto.converter.CreateCarDtoConverter;
import com.codeunlu.rentacar.cars.dto.request.CreateCarRequest;
import com.codeunlu.rentacar.cars.dto.request.UpdateCarRequest;
import com.codeunlu.rentacar.cars.exception.CarNotFoundException;
import com.codeunlu.rentacar.cars.model.Car;
import com.codeunlu.rentacar.cars.model.CarBrand;
import com.codeunlu.rentacar.cars.model.CarModel;
import com.codeunlu.rentacar.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarBrandService carBrandService;
    private final CarModelService carModelService;
    private final CreateCarDtoConverter converter;

    public CarService(CarRepository carRepository, CarBrandService carBrandService,
                      CarModelService carModelService, CreateCarDtoConverter converter) {
        this.carRepository = carRepository;
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
        this.converter = converter;
    }

    public Boolean createCar(CreateCarRequest request){
        if(findByTitle(request.getTitle()) != null){
            return false;
        }
        Car car = new Car();
        CarBrand carBrand = carBrandService.findById(request.getCarModel().getCarBrand().getId());
        CarModel carModel = carModelService.findById(request.getCarModel().getId());
        car.setTitle(request.getTitle());
        car.setGear(request.getGear());
        car.setCarDoor(request.getCarDoor());
        car.setContent(request.getContent());
        car.setFuel(request.getFuel());
        car.setCarYear(request.getCarYear());
        car.setCarCaseType(request.getCarCaseType());
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        converter.convert(carRepository.save(car));
        return true;
    }

    public CreateCarRequest updateCar(UpdateCarRequest request, Long id){
        Car car = findById(id);
        CarBrand carBrand = carBrandService.findById(request.getCarModel().getCarBrand().getId());
        CarModel carModel = carModelService.findById(request.getCarModel().getId());
        car.setTitle(request.getTitle());
        car.setGear(request.getGear());
        car.setCarDoor(request.getCarDoor());
        car.setContent(request.getContent());
        car.setFuel(request.getFuel());
        car.setCarYear(request.getCarYear());
        car.setCarCaseType(request.getCarCaseType());
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        return converter.convert(carRepository.save(car));
    }

    public Boolean deleteCar(Long id){
        Car car = findById(id);
        carRepository.delete(car);
        return true;
    }

    public List<CreateCarRequest> getAll(){
        return carRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public CreateCarRequest getCar(Long id){
        return converter.convert(findById(id));
    }


    protected Car findByTitle(String title){
        return carRepository.findByTitle(title);
    }

    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car is not founded!"));
    }
}

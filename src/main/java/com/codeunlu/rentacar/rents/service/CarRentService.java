package com.codeunlu.rentacar.rents.service;

import com.codeunlu.rentacar.cars.service.CarService;
import com.codeunlu.rentacar.locations.service.LocationService;
import com.codeunlu.rentacar.rents.dto.CarRentDto;
import com.codeunlu.rentacar.rents.dto.converter.CarRentDtoConvert;
import com.codeunlu.rentacar.rents.dto.request.CreateCarRentRequest;
import com.codeunlu.rentacar.rents.exception.RentNotFoundException;
import com.codeunlu.rentacar.rents.model.CarRent;
import com.codeunlu.rentacar.rents.repository.CarRentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentService {

    private final CarRentRepository carRentRepository;
    private final CarRentDtoConvert converter;
    private final CarService carService;
    private final LocationService locationService;

    public CarRentService(CarRentRepository carRentRepository, CarRentDtoConvert converter, CarService carService, LocationService locationService) {
        this.carRentRepository = carRentRepository;
        this.converter = converter;
        this.carService = carService;
        this.locationService = locationService;
    }

    public Boolean createCarRent(CreateCarRentRequest request){
        if(findByCarId(request.getCar().getId()) != null){
            return false;
        }
        CarRent carRent = new CarRent();
        carRent.setLocation(locationService.findById(request.getLocation().getId()));
        carRent.setCar(carService.findById(request.getCar().getId()));
        carRent.setStartDate(request.getStartDate());
        carRent.setEndDate(request.getEndDate());
        converter.converToCarRent(carRentRepository.save(carRent));
        return true;
    }

    public Boolean deleteCarRent(Long id){
        CarRent carRent = findById(id);
        carRentRepository.delete(carRent);
        return true;
    }

    public CreateCarRentRequest updateCarRent(CreateCarRentRequest request,Long id){
        if(findById(id) == null){
            return null;
        }
        CarRent carRent = findById(id);
        carRent.setLocation(locationService.findById(request.getLocation().getId()));
        carRent.setCar(carService.findById(request.getCar().getId()));
        carRent.setStartDate(request.getStartDate());
        carRent.setEndDate(request.getEndDate());
        return converter.convert(carRentRepository.save(carRent));
    }

    public List<CarRentDto>  getAll(){
        return carRentRepository.findAll()
                .stream()
                .map(converter::converToCarRent)
                .collect(Collectors.toList());
    }

    public CarRentDto getCarRent(Long id){
        return converter.converToCarRent(findById(id));
    }




    protected CarRent findById(Long id){
        return carRentRepository.findById(id)
                .orElseThrow(() -> new RentNotFoundException("Car Rent is not founded!"));
    }


    protected CarRent findByCarId(Long id){
        return carRentRepository.findByCarId(id);
    }

}

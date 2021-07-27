package com.codeunlu.rentacar.service.cars;

import com.codeunlu.rentacar.dto.cars.CarBrandDto;
import com.codeunlu.rentacar.dto.cars.CarModelDto;
import com.codeunlu.rentacar.dto.cars.create.CreateBrandDto;
import com.codeunlu.rentacar.model.cars.CarBrand;
import com.codeunlu.rentacar.repository.cars.CarBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;
    private final ModelMapper modelMapper;


    public CarBrandService(CarBrandRepository carBrandRepository, ModelMapper modelMapper) {
        this.carBrandRepository = carBrandRepository;
        this.modelMapper = modelMapper;
    }

    public CreateBrandDto createBrands(CreateBrandDto createBrandDto){
        CarBrand carBrand = modelMapper.map(createBrandDto,CarBrand.class);
        return modelMapper.map(carBrandRepository.save(carBrand),CreateBrandDto.class);
    }

    public List<CarBrandDto> getAllBrand() {
        List<CarBrand> carBrands = carBrandRepository.findAll();
        List<CarBrandDto> carBrandDtos = carBrands.stream()
                .map(carBrand -> modelMapper.map(carBrand,CarBrandDto.class))
                .collect(Collectors.toList());
        return carBrandDtos;
    }


    public CarBrandDto updateBrand(Long id, CarBrandDto carBrandDto) {
        Optional<CarBrand> carBrand = carBrandRepository.findById(id);
        if(carBrand.isPresent()){
            carBrand.get().setName(carBrandDto.getName());
            return modelMapper.map(carBrandRepository.save(carBrand.get()), CarBrandDto.class);
        }
        return null;
    }

    public CarBrand findById(Long id ){
        Optional<CarBrand> carBrand = carBrandRepository.findById(id);
        if(carBrand.isPresent()){
            return carBrand.get();
        }
        return null;
    }
}

package com.codeunlu.rentacar.service.cars;

import com.codeunlu.rentacar.dto.cars.CarModelDto;
import com.codeunlu.rentacar.dto.cars.create.CreateModelDto;
import com.codeunlu.rentacar.model.cars.CarModel;
import com.codeunlu.rentacar.repository.cars.CarModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarModelService {
    private final CarModelRepository carModelRepository;
    private final CarBrandService carBrandService;
    private final ModelMapper modelMapper;

    public CarModelService(CarModelRepository carModelRepository, CarBrandService carBrandService, ModelMapper modelMapper) {
        this.carModelRepository = carModelRepository;
        this.carBrandService = carBrandService;
        this.modelMapper = modelMapper;
    }

    public CreateModelDto createModels(Long id, CreateModelDto createModelDto){
        if(!carBrandService.findById(id).equals(null)){
            CarModel carModel = modelMapper.map(createModelDto,CarModel.class);
            carModel.setCarBrand(carBrandService.findById(id));
            return modelMapper.map(carModelRepository.save(carModel),CreateModelDto.class);
        }
        return null;
    }

    public List<CarModelDto> getAllModelBrand(Long id) {
        List<CarModel> carModels = carModelRepository.findByCarBrandId(id);
        List<CarModelDto> carModelDtos = carModels.stream()
                .map(carModel -> modelMapper.map(carModel,CarModelDto.class))
                .collect(Collectors.toList());
        return carModelDtos;
    }

    public CarModelDto getModel(Long id) {
        Optional<CarModel> carModels = carModelRepository.findById(id);
        if(carModels.isPresent()){
            return modelMapper.map(carModels.get(), CarModelDto.class);
        }
        return null;
    }

    public CarModelDto updateModel(Long id, CarModelDto carModelDto) {
        Optional<CarModel> carModel = carModelRepository.findById(id);
        if(carModel.isPresent()){
            carModel.get().setName(carModelDto.getName());
            return modelMapper.map(carModelRepository.save(carModel.get()), CarModelDto.class);
        }
        return null;
    }

    public CarModel findById(Long id ){
        Optional<CarModel> carModel = carModelRepository.findById(id);
        if(carModel.isPresent()){
            return carModel.get();
        }
        return null;
    }


}

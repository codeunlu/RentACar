package com.codeunlu.rentacar.service;

import com.codeunlu.rentacar.dto.create.CreateIndividualDto;
import com.codeunlu.rentacar.dto.IndividualDto;
import com.codeunlu.rentacar.model.Individual;
import com.codeunlu.rentacar.repository.IndividualRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IndividualService {
    private final IndividualRepository individualRepository;
    private final ModelMapper modelMapper;

    public IndividualService(IndividualRepository individualRepository, ModelMapper modelMapper) {
        this.individualRepository = individualRepository;
        this.modelMapper = modelMapper;
    }

    public CreateIndividualDto createIndividual(CreateIndividualDto createIndividualDto){
        Individual individual = modelMapper.map(createIndividualDto,Individual.class);
        individual.setCreatedAt(LocalDateTime.now());
        return modelMapper.map(individualRepository.save(individual), CreateIndividualDto.class);
    }

    public List<IndividualDto> getIndividuals() {
        List<Individual> individuals = individualRepository.findAll();
        List<IndividualDto> individualDtos = individuals.stream()
                .map(individual -> modelMapper.map(individual,IndividualDto.class))
                .collect(Collectors.toList());
        return individualDtos;
    }

    public IndividualDto getIndividual(Long id) {
        Optional<Individual> individual = individualRepository.findById(id);
        if(individual.isPresent()){
            return modelMapper.map(individual.get(),IndividualDto.class);
        }
        return null;
    }

    public IndividualDto updateIndividual(Long id, IndividualDto individualDto) {
        Optional<Individual> individual = individualRepository.findById(id);
        if(individual.isPresent()){
            individual.get().setName(individualDto.getName());
            individual.get().setSurname(individualDto.getSurname());
            individual.get().setDateOfBirth(individualDto.getDateOfBirth());
            individual.get().setNationalId(individualDto.getNationalId());

            return modelMapper.map(individualRepository.save(individual.get()), IndividualDto.class);
        }
        return null;
    }

    public Boolean deleteIndividual(Long id) {
        Optional<Individual> individual = individualRepository.findById(id);
        if(individual.isPresent()){
            individualRepository.delete(individual.get());
            return true;
        }
        return false;
    }
}

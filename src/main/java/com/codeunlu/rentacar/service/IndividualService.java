package com.codeunlu.rentacar.service;

import com.codeunlu.rentacar.core.utilities.results.DataResult;
import com.codeunlu.rentacar.core.utilities.results.Result;
import com.codeunlu.rentacar.core.utilities.results.SuccessDataResult;
import com.codeunlu.rentacar.core.utilities.results.SuccessResult;
import com.codeunlu.rentacar.dto.CreateIndividualDto;
import com.codeunlu.rentacar.dto.IndividualDto;
import com.codeunlu.rentacar.dto.IndividualDtoConverter;
import com.codeunlu.rentacar.model.Individual;
import com.codeunlu.rentacar.repository.IndividualRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualService {
    private final IndividualRepository individualRepository;
    private final IndividualDtoConverter individualDtoConverter;

    public IndividualService(IndividualRepository individualRepository, IndividualDtoConverter individualDtoConverter) {
        this.individualRepository = individualRepository;
        this.individualDtoConverter = individualDtoConverter;
    }

    public Result createIndividual(CreateIndividualDto individualDto) {
        Individual individual = new Individual();

        individual.setName(individualDto.getName());
        individual.setSurname(individualDto.getSurname());
        individual.setDateOfBirth(individualDto.getDateOfBirth());
        individual.setNationalId(individualDto.getNationalId());
        individual.setContacts(individualDto.getContacts());
        individual.setAddresses(individualDto.getAddresses());

        individualRepository.save(individual);
        return new SuccessResult("Successfully added!");
    }

    public DataResult<List<IndividualDto>> getIndividual() {
        List<Individual> individuals = individualRepository.findAll();
        List<IndividualDto> individualDtoList = new ArrayList<>();

        for (Individual individual: individuals){
            individualDtoList.add(individualDtoConverter.convert(individual));
        }

        return new SuccessDataResult<List<IndividualDto>>(individualDtoList,"All Individual Listed!");
    }

    public DataResult<IndividualDto> getIndividualId(Long id) {
        Individual individual = individualRepository.findById(id);
        IndividualDto individualDto = individualDtoConverter.convert(individual);
        return new SuccessDataResult<IndividualDto>(individualDto,"Successfully Listed!");
    }
}

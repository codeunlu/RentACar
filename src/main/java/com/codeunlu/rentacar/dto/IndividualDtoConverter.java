package com.codeunlu.rentacar.dto;

import com.codeunlu.rentacar.model.Individual;
import org.springframework.stereotype.Component;

@Component
public class IndividualDtoConverter {

    public IndividualDto convert(Individual individual){
        IndividualDto individualDto = new IndividualDto();

        individualDto.setName(individual.getName());
        individualDto.setSurname(individual.getSurname());
        individualDto.setDateOfBirth(individual.getDateOfBirth());
        individualDto.setNationalId(individual.getNationalId());
        individualDto.setContacts(individual.getContacts());
        individualDto.setAddresses(individual.getAddresses());

        return individualDto;
    }

}

package com.codeunlu.rentacar.service;

import com.codeunlu.rentacar.dto.CorporateDto;
import com.codeunlu.rentacar.dto.create.CreateCorporateDto;
import com.codeunlu.rentacar.model.Corporate;
import com.codeunlu.rentacar.repository.CorporateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CorporateService {
    private final CorporateRepository corporateRepository;
    private final ModelMapper modelMapper;

    public CorporateService(CorporateRepository corporateRepository, ModelMapper modelMapper) {
        this.corporateRepository = corporateRepository;
        this.modelMapper = modelMapper;
    }

    public CreateCorporateDto createCorporate(CreateCorporateDto createCorporateDto){
        Corporate corporate = modelMapper.map(createCorporateDto,Corporate.class);
        corporate.setCreatedAt(LocalDateTime.now());
        return modelMapper.map(corporateRepository.save(corporate), CreateCorporateDto.class);
    }

    public List<CorporateDto> getCorporates() {
        List<Corporate> corporates = corporateRepository.findAll();
        List<CorporateDto> corporateDtos = corporates.stream()
                .map(individual -> modelMapper.map(corporates,CorporateDto.class))
                .collect(Collectors.toList());
        return corporateDtos;
    }

    public CorporateDto getCorporate(Long id) {
        Optional<Corporate> corporate = corporateRepository.findById(id);
        if(corporate.isPresent()){
            return modelMapper.map(corporate.get(),CorporateDto.class);
        }
        return null;
    }

    public CorporateDto updateCorporate(Long id, CorporateDto corporateDto) {
        Optional<Corporate> corporate = corporateRepository.findById(id);
        if(corporate.isPresent()){
            corporate.get().setCompanyName(corporateDto.getCompanyName());
            corporate.get().setCompanyContact(corporateDto.getCompanyContact());
            corporate.get().setCompanyURI(corporateDto.getCompanyURI());
            return modelMapper.map(corporateRepository.save(corporate.get()), CorporateDto.class);
        }
        return null;
    }

    public Boolean deleteCorporate(Long id) {
        Optional<Corporate> corporate = corporateRepository.findById(id);
        if(corporate.isPresent()){
            corporateRepository.delete(corporate.get());
            return true;
        }
        return false;
    }
}

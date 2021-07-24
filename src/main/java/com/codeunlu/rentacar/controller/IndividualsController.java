package com.codeunlu.rentacar.controller;

import com.codeunlu.rentacar.core.utilities.results.DataResult;
import com.codeunlu.rentacar.core.utilities.results.Result;
import com.codeunlu.rentacar.dto.CreateIndividualDto;
import com.codeunlu.rentacar.dto.IndividualDto;
import com.codeunlu.rentacar.service.IndividualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class IndividualsController {

    private final IndividualService individualService;

    public IndividualsController(IndividualService individualService) {
        this.individualService = individualService;
    }

    @PostMapping
    public ResponseEntity<Result> createIndividual(@RequestBody CreateIndividualDto createIndividualDto){
        return ResponseEntity.ok(individualService.createIndividual(createIndividualDto));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<IndividualDto>>> getIndividual(){
        return ResponseEntity.ok(individualService.getIndividual());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<IndividualDto>> getIndividualId(@PathVariable Long id){
        return ResponseEntity.ok(individualService.getIndividualId(id));
    }
}

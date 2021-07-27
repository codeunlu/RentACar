package com.codeunlu.rentacar.controller.users;

import com.codeunlu.rentacar.dto.users.create.CreateIndividualDto;
import com.codeunlu.rentacar.dto.users.IndividualDto;
import com.codeunlu.rentacar.service.users.IndividualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/individuals")
public class IndividualController {

    private final IndividualService individualService;

    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }


    @PostMapping("/create")
    public ResponseEntity<CreateIndividualDto> createIndividual(@RequestBody CreateIndividualDto createIndividualDto){
        return ResponseEntity.ok(individualService.createIndividual(createIndividualDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<IndividualDto>> getIndividuals(){
        return ResponseEntity.ok(individualService.getIndividuals());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<IndividualDto> getIndividual(@PathVariable Long id){
        return ResponseEntity.ok(individualService.getIndividual(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<IndividualDto> updateIndividual(@PathVariable Long id,
                                                          @RequestBody IndividualDto individualDto){
        return ResponseEntity.ok(individualService.updateIndividual(id,individualDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteIndividual(@PathVariable Long id){
        return ResponseEntity.ok(individualService.deleteIndividual(id));
    }

}

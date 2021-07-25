package com.codeunlu.rentacar.controller;

import com.codeunlu.rentacar.dto.CorporateDto;
import com.codeunlu.rentacar.dto.create.CreateCorporateDto;
import com.codeunlu.rentacar.service.CorporateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/corporates")
public class CorporateController {

    private final CorporateService corporateService;

    public CorporateController(CorporateService corporateService) {
        this.corporateService = corporateService;
    }


    @PostMapping("/create")
    public ResponseEntity<CreateCorporateDto> createCorporate(@RequestBody CreateCorporateDto createCorporateDto){
        return ResponseEntity.ok(corporateService.createCorporate(createCorporateDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CorporateDto>> getCorporates(){
        return ResponseEntity.ok(corporateService.getCorporates());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CorporateDto> getCorporate(@PathVariable Long id){
        return ResponseEntity.ok(corporateService.getCorporate(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CorporateDto> updateCorporate(@PathVariable Long id,
                                                          @RequestBody CorporateDto corporateDto){
        return ResponseEntity.ok(corporateService.updateCorporate(id,corporateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCorporate(@PathVariable Long id){
        return ResponseEntity.ok(corporateService.deleteCorporate(id));
    }

}

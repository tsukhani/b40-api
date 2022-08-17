package com.pinelabs.b40api.controllers;

import com.pinelabs.b40api.dtos.CreateFamilyDto;
import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.services.FamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping()
    public ResponseEntity<List<Family>> getAll() {
        return new ResponseEntity<>(this.familyService.getAllFamily(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Family> create(@RequestBody CreateFamilyDto dto) {
        return new ResponseEntity<>(this.familyService.createFamily(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Family> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.familyService.getFamilyById(id), HttpStatus.OK);
    }
}

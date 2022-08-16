package com.pinelabs.b40api.controllers;

import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.services.FamilyService;
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
    public List<Family> getAll() {
        return this.familyService.getAllFamily();
    }

    @PostMapping()
    public Family create() {
        return new Family();
    }

    @GetMapping("/{id}")
    public Family getById(@PathVariable("id") Long id) {
        return this.familyService.getFamilyById(id);
    }
}

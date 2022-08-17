package com.pinelabs.b40api.controllers;

import com.pinelabs.b40api.dtos.CreateFamilyDto;
import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.services.FamilyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
@Tag(name = "Family", description = "CRUD for Family domain object")
public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get family", description = "returns a list of family", tags = {"Family"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful get family",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Family.class))
                    )
            )
    })
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

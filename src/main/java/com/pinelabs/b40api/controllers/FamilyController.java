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

import javax.validation.Valid;
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
        return new ResponseEntity<>(this.familyService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post Family", description = "Create a family", tags = {"Family"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful create family",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Family.class)
                    )
            )
    })
    public ResponseEntity<Family> create(@RequestBody @Valid CreateFamilyDto dto) {
        return new ResponseEntity<>(this.familyService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get family by their id", description = "returns a family by id", tags = {"Family"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful get family",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Family.class)
                    )
            )
    })
    public ResponseEntity<Family> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.familyService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "delete family by their id", description = "returns the deleted family data", tags = {"Family"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Successful delete family",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Family.class)
                    )
            )
    })
    public ResponseEntity<Family> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.familyService.deleteById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "update family by their id", description = "returns the updated family data", tags = {"Family"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Successful update family",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Family.class)
                    )
            )
    })
    public ResponseEntity<Family> updateById(@RequestBody Family dto, @PathVariable("id") Long id) {
        return new ResponseEntity<>(this.familyService.updateById(dto, id), HttpStatus.ACCEPTED);
    }
}

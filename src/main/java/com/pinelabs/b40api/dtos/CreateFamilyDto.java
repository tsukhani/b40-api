package com.pinelabs.b40api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateFamilyDto {

    @NotNull(message = "family_name cannot be null")
    @JsonProperty("family_name")
    private String familyName;

    @NotNull(message = "lat cannot be null")
    @JsonProperty("lat")
    private Float lat;

    @NotNull(message = "lon cannot be null")
    @JsonProperty("lon")
    private Float lon;

    @NotNull(message = "number_of_children cannot be null")
    @JsonProperty("number_of_children")
    private Integer numberOfChildren;

    @NotNull(message = "household_income cannot be null")
    @JsonProperty("household_income")
    private Double householdIncome;

    @NotNull(message = "religion cannot be null")
    @JsonProperty("religion")
    private String religion;

    @NotNull(message = "race cannot be null")
    @JsonProperty("race")
    private String race;

    @NotNull(message = "family_size cannot be null")
    @JsonProperty("family_size")
    private Integer familySize;
}

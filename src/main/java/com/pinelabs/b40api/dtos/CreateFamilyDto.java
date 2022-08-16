package com.pinelabs.b40api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateFamilyDto {
    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("lat")
    private Float lat;

    @JsonProperty("lon")
    private Float lon;

    @JsonProperty("number_of_children")
    private Integer numberOfChildren;

    @JsonProperty("religion")
    private String religion;

    @JsonProperty("race")
    private String race;

    @JsonProperty("family_size")
    private Integer familySize;

}

package com.pinelabs.b40api.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FamilyNotFoundException extends RuntimeException {
    private final String fieldName;
    private final Object fieldValue;

    public FamilyNotFoundException(String fieldName, Object fieldValue) {
        super(String.format("Family not found with %s: '%s'", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

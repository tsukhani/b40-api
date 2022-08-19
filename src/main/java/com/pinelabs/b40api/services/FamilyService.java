package com.pinelabs.b40api.services;

import com.pinelabs.b40api.dtos.CreateFamilyDto;
import com.pinelabs.b40api.models.Family;

import java.util.List;

public interface FamilyService {
    Family getFamilyById(Long id);

    List<Family> getAllFamily();

    Family createFamily(CreateFamilyDto dto);

    Family deleteById(Long id);

    Family updateById(Family updateFamily, Long id);
}

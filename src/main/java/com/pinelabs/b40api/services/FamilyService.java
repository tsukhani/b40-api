package com.pinelabs.b40api.services;

import com.pinelabs.b40api.exceptions.FamilyNotFoundException;
import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.repositories.FamilyRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FamilyService {
    private final FamilyRepository familyRepository;
    private final ModelMapper mapper;

    @Autowired
    public FamilyService(FamilyRepository familyRepository, ModelMapper mapper) {
        this.familyRepository = familyRepository;
        this.mapper = mapper;
    }

    public Family getFamilyById(Long id) {
        return this.familyRepository.findById(id)
                .orElseThrow(() -> new FamilyNotFoundException("id", id));
    }

    public List<Family> getAllFamily() {
        return this.familyRepository.findAll();
    }

    public Family createFamily() {
        return new Family();
    }

    public Family updateById(Family updateFamily, Long id) {
        return new Family();
    }
}

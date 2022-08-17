package com.pinelabs.b40api.services;

import com.pinelabs.b40api.dtos.CreateFamilyDto;
import com.pinelabs.b40api.exceptions.FamilyNotFoundException;
import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.repositories.FamilyRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FamilyService {
    private final FamilyRepository familyRepository;
    private final Logger LOG = LoggerFactory.getLogger(FamilyService.class);

    public FamilyService(FamilyRepository familyRepository) {
        LOG.debug("Get all Families");
        this.familyRepository = familyRepository;
    }

    public Family getFamilyById(Long id) {
        LOG.debug("Get Family By Id");
        return this.familyRepository.findById(id)
                .orElseThrow(() -> new FamilyNotFoundException("id", id));
    }

    public List<Family> getAllFamily() {
        return this.familyRepository.findAll();
    }

    public Family createFamily(CreateFamilyDto dto) {
        var family = Family.builder()
                .familyName(dto.getFamilyName())
                .householdIncome(dto.getHouseholdIncome())
                .familySize(dto.getFamilySize())
                .numberOfChildren(dto.getNumberOfChildren())
                .lat(dto.getLat())
                .lon(dto.getLon())
                .race(dto.getRace())
                .religion(dto.getReligion())
                .build();

        return this.familyRepository.save(family);
    }

    public Family deleteById(Long id) {
        var toDeleteFamily = this.familyRepository.findById(id)
                .orElseThrow(() -> new FamilyNotFoundException("id", id));

        this.familyRepository.deleteById(id);

        return toDeleteFamily;
    }

    public Family updateById(Family updateFamily, Long id) {
        return null;
    }
}

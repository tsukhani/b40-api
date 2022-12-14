package com.pinelabs.b40api.services.Impl;

import com.pinelabs.b40api.dtos.CreateFamilyDto;
import com.pinelabs.b40api.exceptions.FamilyNotFoundException;
import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.repositories.FamilyRepository;
import com.pinelabs.b40api.services.FamilyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FamilyServiceImpl implements FamilyService {
    private final FamilyRepository familyRepository;
    private final Logger LOG = LoggerFactory.getLogger(FamilyServiceImpl.class);

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        LOG.debug("Get all Families");
        this.familyRepository = familyRepository;
    }

    @Override
    public Family getFamilyById(Long id) {
        LOG.debug("Get Family By Id");
        return this.familyRepository.findById(id)
                .orElseThrow(() -> new FamilyNotFoundException("id", id));
    }

    @Override
    public List<Family> getAllFamily() {
        return this.familyRepository.findAll();
    }

    @Override
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

    @Override
    public Family deleteById(Long id) {
        var toDeleteFamily = this.familyRepository.findById(id)
                .orElseThrow(() -> new FamilyNotFoundException("id", id));

        this.familyRepository.deleteById(id);

        return toDeleteFamily;
    }

    @Override
    public Family updateById(Family updateFamily, Long id) {
        return this.familyRepository.findById(id)
                .map(family -> {
                    family.setFamilyName(updateFamily.getFamilyName());
                    family.setFamilySize(updateFamily.getFamilySize());
                    family.setHouseholdIncome(updateFamily.getHouseholdIncome());
                    family.setLat(updateFamily.getLat());
                    family.setLon(updateFamily.getLon());
                    family.setRace(updateFamily.getRace());
                    family.setReligion(updateFamily.getReligion());
                    family.setNumberOfChildren(updateFamily.getNumberOfChildren());

                    return this.familyRepository.save(family);
                })
                .orElseThrow(() -> new FamilyNotFoundException("id", id));
    }
}

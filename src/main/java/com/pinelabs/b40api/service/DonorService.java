package com.pinelabs.b40api.service;

import com.pinelabs.b40api.model.Donor;
import com.pinelabs.b40api.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonor(){
        return donorRepository.findAll();
    }

    public Donor getDonor(Integer id){
        return donorRepository.findById(id);
    }

    public Donor createDonor(Donor donor){
        return donorRepository.save(donor);
    }

    public Donor updateDonor(Donor donor){
        return null;
    }

    public void deleteDonor(Integer id){
        donorRepository.deleteById(id);
    }


}

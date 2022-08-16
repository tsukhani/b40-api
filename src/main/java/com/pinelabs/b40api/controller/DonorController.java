package com.pinelabs.b40api.controller;

import com.pinelabs.b40api.models.Donor;
import com.pinelabs.b40api.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("donor")
public class DonorController {

    @Autowired
    private DonorRepository donorRepository;

    @GetMapping("get/all")
    public List<Donor> getAllDonor(){
        return donorRepository.findAll();
    }

    @PostMapping("create")
    public String createDonor(@RequestBody Donor donor){
        donorRepository.save(donor);
        return "New Donor added";
    }

    @GetMapping("{get/id}")
    public Donor getDonorById(@PathVariable Integer id){
        return donorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Invalid Id"));
    }

    @PutMapping("{update/id}")
    public Donor updateDonor(@PathVariable Integer id,@RequestBody Donor donorDetails) {
        Donor updateDonorDetails = donorRepository.findById(id).get();

        updateDonorDetails.setLocation(donorDetails.getLocation());
        updateDonorDetails.setReligion(donorDetails.getReligion());
        updateDonorDetails.setPhoneNumber(donorDetails.getPhoneNumber());

        return  updateDonorDetails;
    }


    @DeleteMapping("{delete/id}")
    public void deleteDonor(@PathVariable Integer id){
        donorRepository.deleteById(id);
    }


}

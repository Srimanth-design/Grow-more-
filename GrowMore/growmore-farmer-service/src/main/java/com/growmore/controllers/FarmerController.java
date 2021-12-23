package com.growmore.controllers;

import com.growmore.model.Farmer;
import com.growmore.service.IFarmerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer-api")
public class FarmerController {

    IFarmerService farmerService;

    @Autowired
    public void setFarmerService(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("/farmers")
    Farmer addFarmer(@RequestBody Farmer farmer) {
        return farmerService.addFarmer(farmer);
    }

    @PutMapping("/farmers")
    void updateFarmer(@RequestBody Farmer farmer) {
        farmerService.updateFarmer(farmer);
    }

    @DeleteMapping("/farmers/farmerId/{farmerId}")
    void deleteFarmer(@PathVariable("farmerId") int farmerId) {
        farmerService.deleteFarmer(farmerId);
    }

    @GetMapping("/farmers/gender/{gender}")
    Farmer getByGender(@PathVariable("gender") String gender) {
        return farmerService.getByGender(gender);
    }
}

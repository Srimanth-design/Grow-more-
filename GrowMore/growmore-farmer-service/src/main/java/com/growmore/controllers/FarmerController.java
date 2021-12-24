package com.growmore.controllers;

import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Farmer;
import com.growmore.service.IFarmerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    List<Farmer> getByGender(@PathVariable("gender") String gender) throws FarmerNotFoundException {
        return farmerService.getByGender(gender);
    }

    @GetMapping("/farmers/age/{age}")
    List<Farmer> getByAge(@PathVariable("age") int age) throws FarmerNotFoundException{
        return farmerService.getByAge(age);
    }

    @GetMapping("/farmers/farmerId/{farmerId}")
    Farmer getById(@PathVariable("farmerId") int farmerId) throws FarmerNotFoundException{
        return farmerService.getById(farmerId);
    }

    @GetMapping("/farmers")
    List<Farmer> getAll(){
        return farmerService.getAll();
    }

    @GetMapping("/farmers/soil/{soil}/city/{city}")
    List<Farmer> getBySoilCity(@PathVariable("soil") String soil, @PathVariable("city") String city) throws FarmerNotFoundException{
        return farmerService.getBySoilCity(soil, city);
    }

    @GetMapping("/farmers/soil/{soil}")
    List<Farmer> getBySoil(@PathVariable("soil") String soil) throws FarmerNotFoundException{
        return  farmerService.getBySoil(soil);
    }


}

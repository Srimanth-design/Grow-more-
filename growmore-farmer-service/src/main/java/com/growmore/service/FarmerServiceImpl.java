package com.growmore.service;

import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Farmer;
import com.growmore.model.Intensity;
import com.growmore.repository.IFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements IFarmerService {

 IFarmerRepository farmerRepository;
//
    @Autowired
    public void setFarmerRepository(IFarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }
//
    @Override
    public Farmer addFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }
//
    @Override
    public void updateFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    @Override
    public void deleteFarmer(int farmerId) {
        farmerRepository.deleteById(farmerId);
    }

    @Override
    public List<Farmer> getByGender(String gender) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.getByGender(gender);
        if (farmers.isEmpty()) {
            throw new FarmerNotFoundException("Gender not found");

        }
        return farmers;
    }

    @Override
    public List<Farmer> getByAge(int age) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.getByAge(age);
        if (farmers.isEmpty()) {
            throw new FarmerNotFoundException("Age error");
        }
        return farmers;
    }

    @Override
    public Farmer getById(int farmerId) throws FarmerNotFoundException {
        return farmerRepository.findById(farmerId).orElseThrow(() -> {
            throw new FarmerNotFoundException("Invalid id");
        });
    }

    @Override
    public List<Farmer> getAll() {
        return farmerRepository.findAll();
    }

    @Override
    public List<Farmer> getBySoilCity(String soil, String city) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.getBySoilCity(soil, city);
        if (farmers.isEmpty()) {
            throw new FarmerNotFoundException("soil and city error");
        }
        return farmers;
    }

    @Override
    public List<Farmer> getBySoil(String soil) throws FarmerNotFoundException {

        List<Farmer> farmers = farmerRepository.getBySoil(soil);
        if (farmers.isEmpty()) {
            throw new FarmerNotFoundException("soil not found");
        }
        return farmers;
    }


}

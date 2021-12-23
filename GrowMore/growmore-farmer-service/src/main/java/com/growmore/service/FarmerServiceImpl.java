package com.growmore.service;

import com.growmore.model.Farmer;
import com.growmore.repository.IFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements IFarmerService{

    IFarmerRepository farmerRepository;

    @Autowired
    public void setFarmerRepository(IFarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public Farmer addFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    @Override
    public void updateFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    @Override
    public void deleteFarmer(int farmerId) {
        farmerRepository.deleteById(farmerId);
    }

    @Override
    public Farmer getByGender(String gender) {
        return farmerRepository.getByGender(gender);
    }
}

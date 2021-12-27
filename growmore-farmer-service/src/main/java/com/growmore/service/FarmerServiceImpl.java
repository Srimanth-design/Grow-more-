package com.growmore.service;

import com.growmore.exception.FarmerNotFoundException;
import com.growmore.feign.IProblemFeign;
import com.growmore.model.Farmer;
import com.growmore.model.Problem;
import com.growmore.repository.IFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements IFarmerService, IProblemFeign {

 IFarmerRepository farmerRepository;
//
    @Autowired
    public void setFarmerRepository(IFarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }


    @Autowired
    private IProblemFeign problemFeign;

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

    @Override
    public List<Farmer> getByCity(String city) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.getByCity(city);
        if (farmers.isEmpty()) {
            throw new FarmerNotFoundException("city not found");
        }
        return farmers;
    }


    @Override
    public List<Problem> getAllPro() {
        return problemFeign.getAllPro();
    }

    @Override
    public List<Problem> getByIntensity(String intensity) throws FarmerNotFoundException {
        List<Problem> problems = problemFeign.getByIntensity(intensity);
        if (problems.isEmpty()) {
            throw new FarmerNotFoundException("intensity did not match the condition");
        }
        return problems;
    }

    @Override
    public List<Problem> getByFertilizer(String fertilizer) throws FarmerNotFoundException {
        List<Problem> problems = problemFeign.getByFertilizer(fertilizer);
        if (problems.isEmpty()) {
            throw new FarmerNotFoundException("No farmer used this fertilizer");
        }
        return problems;
    }

}

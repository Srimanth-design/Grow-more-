package com.growmore.service;

import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Farmer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFarmerService {

    Farmer addFarmer(Farmer farmer);

    void updateFarmer(Farmer farmer);

    void deleteFarmer(int farmerId);

    List<Farmer> getByGender(String gender) throws FarmerNotFoundException;

    List<Farmer> getByAge(int age) throws FarmerNotFoundException;

    Farmer getById(int farmerId) throws FarmerNotFoundException;

    List<Farmer> getAll();

    List<Farmer> getBySoil(String soil) throws FarmerNotFoundException;

    List<Farmer> getByCity(String city) throws FarmerNotFoundException;

    List<Farmer> getBySoilCity(String soil, String city) throws FarmerNotFoundException;

}

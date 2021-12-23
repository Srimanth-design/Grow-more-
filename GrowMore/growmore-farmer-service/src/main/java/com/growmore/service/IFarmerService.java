package com.growmore.service;

import com.growmore.model.Farmer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFarmerService {

    Farmer addFarmer(Farmer farmer);

    void updateFarmer(Farmer farmer);

    void deleteFarmer(int farmerId);

    Farmer getByGender(String gender);

    List<Farmer> getByAge(int age);

    Farmer getById(int farmerId);

    List<Farmer> getAll();

    List<Farmer> getBySoilCity(String soil, String city);


}

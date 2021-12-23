package com.growmore.service;

import com.growmore.model.Farmer;

public interface IFarmerService {

    Farmer addFarmer(Farmer farmer);
    void updateFarmer(Farmer farmer);
    void deleteFarmer(int farmerId);

    Farmer getByGender(String gender);


}

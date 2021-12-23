package com.growmore.repository;

import com.growmore.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer,Integer> {



    Farmer getByGender(String gender);
}

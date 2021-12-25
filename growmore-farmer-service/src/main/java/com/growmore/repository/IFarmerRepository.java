package com.growmore.repository;

import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Farmer;
import com.growmore.model.Intensity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {

    List<Farmer> getByGender(String gender) throws FarmerNotFoundException;

    @Query("from Farmer where age>?1")
    List<Farmer> getByAge(int age) throws FarmerNotFoundException;

    @Query("from Farmer f inner join f.farmDetails d where d.soil=?1")
    List<Farmer> getBySoil(String soil) throws FarmerNotFoundException;

    @Query("from Farmer f inner join f.farmDetails d where d.soil=?1 and d.city=?2 ")
    List<Farmer> getBySoilCity(String soil, String city) throws FarmerNotFoundException;



}

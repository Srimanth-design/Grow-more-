package com.growmore.repository;

import com.growmore.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer,Integer> {

    Farmer getByGender(String gender);
    @Query("from Farmer where age>?1")
    List<Farmer> getByAge(int age);
    @Query("from Farmer f inner join f.farmDetails d where d.soil=?1 and d.city=?2 ")
    List<Farmer> getBySoilCity(String soil, String city);
}

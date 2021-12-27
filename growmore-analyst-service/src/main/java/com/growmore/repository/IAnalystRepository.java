package com.growmore.repository;

import com.growmore.exceptions.AnalystNotFoundException;
import com.growmore.model.Analyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnalystRepository extends JpaRepository<Analyst,Integer> {

    List<Analyst> getByGender(String gender) throws AnalystNotFoundException;

    List<Analyst> getByAgeLessThan(int age) throws AnalystNotFoundException;

    @Query("from Analyst where degree like '%?1%' and experience>?2")
    List<Analyst> getByDegreeAndExperience(String degree, int experience) throws AnalystNotFoundException;

    @Query("from Analyst where rating<?1")
    List<Analyst> getByRating(double rating) throws AnalystNotFoundException;

}

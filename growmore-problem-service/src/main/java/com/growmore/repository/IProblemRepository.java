package com.growmore.repository;

import com.growmore.exception.ProblemNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Fertilizers;
import com.growmore.model.Intensity;
import com.growmore.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProblemRepository extends JpaRepository<Problem, Integer> {


    List<Problem> getByIntensity(Intensity intensity) throws ProblemNotFoundException;

    List<Problem> getByFertilizers(Fertilizers fertilizer) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.solutions s where s.alternative = ?1")
    List<Problem> getByAlternate(String alternative) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.solutions s where s.alternative = ?1 or s.alternative= ?2")
    List<Problem> getByAlternatives(String alternative, String alternative2) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.solutions s where p.fertilizers=?1 and s.alternative =?2 ")
    List<Problem> getByPrevFertAlter(Fertilizers fertilizer, String alternative) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.analyst a where a.analystId=?1 ")
    Problem getAnalystById(int analystId) throws ProblemNotFoundException;

    @Query(value = "select * from problem inner join farmer_problems on problem.problemid = farmer_problems.problems_problemid inner join " +
            "farmer on farmer_problems.farmer_farmerid = farmer.farmerid where farmer.farmerid=?1", nativeQuery = true)
    List<Problem> getProDetById(int farmerId) throws ProblemNotFoundException;

}

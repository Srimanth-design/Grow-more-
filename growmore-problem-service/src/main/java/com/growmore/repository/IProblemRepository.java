package com.growmore.repository;

import com.growmore.exception.ProblemNotFoundException;
import com.growmore.model.Fertilizers;
import com.growmore.model.Intensity;
import com.growmore.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProblemRepository extends JpaRepository<Problem, Integer> {

    /*
        Problem
     */

    List<Problem> getByIntensity(Intensity intensity) throws ProblemNotFoundException;

    List<Problem> getByFertilizers(Fertilizers fertilizer) throws ProblemNotFoundException;



    @Query("from Problem p inner join p.solutions s where s.alternative = ?1")
    List<Problem> getByAlternate(String alternative) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.solutions s where s.alternative = ?1 or s.alternative= ?2")
    List<Problem> getByAlternatives(String alternative, String alternative2) throws ProblemNotFoundException;

    @Query("from Problem p inner join p.solutions s where p.fertilizers=?1 and s.alternative =?2 ")
    List<Problem> getByPrevFertAlter(Fertilizers fertilizer, String alternative) throws ProblemNotFoundException;


//
//    @Query("from ExamCenter e inner join e.examList a  inner join a.questionList r where r.university=?2 and a.examName=?1")
//    List<Problem> getByExamUni(String examName, String university) throws ProblemNotFoundException;
//
//    @Query("from ExamCenter e inner join e.examList a  inner join a.questionList r where r.marksDedicated>=?2 and a.examName=?1")
//    List<Problem> getByExamMarks(String examName, int marks) throws ProblemNotFoundException;
}

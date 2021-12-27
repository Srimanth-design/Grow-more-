package com.growmore.service;


import com.growmore.exception.ProblemNotFoundException;
import com.growmore.model.Fertilizers;
import com.growmore.model.Intensity;
import com.growmore.model.Problem;

import java.util.List;

public interface IProblemService {

    Problem addProblem(Problem problem);

    void updateProblem(Problem problem);

    void deleteProblem(int problemId);

    Problem getById(int problemId) throws ProblemNotFoundException;

    List<Problem> getAll();

    List<Problem> getByIntensity(String intensity) throws ProblemNotFoundException;

    List<Problem> getByFertilizer(String fertilizer) throws  ProblemNotFoundException;

    List<Problem> getByFertAlter(String fertilizer, String alternative) throws ProblemNotFoundException;

    List<Problem> getByAlternate(String alternative) throws ProblemNotFoundException;

    List<Problem> getByAlternatives(String alternative, String alternative2) throws ProblemNotFoundException;

}

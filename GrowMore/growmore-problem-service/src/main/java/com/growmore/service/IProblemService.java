package com.growmore.service;


import com.growmore.model.Problem;

import java.util.List;

public interface IProblemService {
    Problem addProblem(Problem problem);

    void updateProblem(Problem problem);

    void deleteProblem(int problemId);

    Problem getById(int problemId);

    List<Problem> getAll();

    List<Problem> getByIntensity(String intensity);
}

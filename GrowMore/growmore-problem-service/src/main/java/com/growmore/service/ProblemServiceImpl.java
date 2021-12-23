package com.growmore.service;

import com.growmore.model.Problem;
import com.growmore.repository.IProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements IProblemService {

    IProblemRepository problemRepository;

    @Autowired
    public void setProblemRepository(IProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public Problem addProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public void updateProblem(Problem problem) {
        problemRepository.save(problem);
    }

    @Override
    public void deleteProblem(int problemId) {
        problemRepository.deleteById(problemId);
    }


    @Override
    public Problem getById(int problemId) {
        return problemRepository.findById(problemId).get();
    }

    @Override
    public List<Problem> getAll() {
        return problemRepository.findAll();
    }

    @Override
    public List<Problem> getByIntensity(String intensity) {
        return problemRepository.getByIntensity(intensity);
    }
}

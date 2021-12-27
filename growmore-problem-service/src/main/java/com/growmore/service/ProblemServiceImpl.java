package com.growmore.service;

import com.growmore.exception.ProblemNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Fertilizers;
import com.growmore.model.Intensity;
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
    public Problem getById(int problemId) throws ProblemNotFoundException {
        return problemRepository.findById(problemId).get();
    }

    @Override
    public List<Problem> getAll() {
        return problemRepository.findAll();
    }

    @Override
    public List<Problem> getByIntensity(String intensity) throws ProblemNotFoundException {
        List<Problem> problems = problemRepository.getByIntensity(Intensity.valueOf(intensity));
        if (problems.isEmpty()) {
            throw new ProblemNotFoundException("Problem with this intensity not exists.");
        }
        return problems;
    }

    @Override
    public List<Problem> getByFertilizer(String fertilizer) throws ProblemNotFoundException {
        List<Problem> problems = problemRepository.getByFertilizers(Fertilizers.valueOf(fertilizer));
        if (problems.isEmpty()) {
            throw new ProblemNotFoundException("No such fertilizer used before");
        }
        return problems;
    }

    @Override
    public List<Problem> getByFertAlter(String fertilizer, String alternative) throws ProblemNotFoundException {
        List<Problem> problems = problemRepository.getByPrevFertAlter(Fertilizers.valueOf(fertilizer), alternative);
        if (problems.isEmpty()) {
            throw new ProblemNotFoundException("No alternative provided");
        }
        return problems;
    }

    @Override
    public List<Problem> getByAlternate(String alternative) throws ProblemNotFoundException {
        List<Problem> problems = problemRepository.getByAlternate(alternative);
        if (problems.isEmpty()) {
            throw new ProblemNotFoundException("No alternate is provided");
        }
        return problems;
    }

    @Override
    public List<Problem> getByAlternatives(String alternative, String alternative2) throws ProblemNotFoundException {
        List<Problem> problems = problemRepository.getByAlternatives(alternative, alternative2);
        if (problems.isEmpty()) {
            throw new ProblemNotFoundException("No match exists");
        }
        return problems;
    }

    @Override
    public Problem getAnalystById(int analystId) throws ProblemNotFoundException {
        return problemRepository.getAnalystById(analystId);
    }

    @Override
    public List<Problem> getProDetById(int farmerId) throws ProblemNotFoundException {
        return problemRepository.getProDetById(farmerId);
    }


}

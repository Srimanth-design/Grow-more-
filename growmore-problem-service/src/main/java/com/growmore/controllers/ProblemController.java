package com.growmore.controllers;

import com.growmore.model.Farmer;
import com.growmore.model.Problem;
import com.growmore.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem-api")
public class ProblemController {

    IProblemService problemService;

    @Autowired
    public void setProblemService(IProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping("/problems")
    Problem addProblem(@RequestBody Problem problem){
        return problemService.addProblem(problem);
    }
    @PutMapping("/problems")
    void updateProblem(@RequestBody Problem problem){
        problemService.updateProblem(problem);
    }
    @DeleteMapping("/problems/problemId/{problemId}")
    void deleteProblem(@PathVariable("problemId") int problemId){
        problemService.deleteProblem(problemId);
    }

    @GetMapping("/problems/problemId/{problemId}")
    Problem getById(@PathVariable("problemId") int problemId){
       return problemService.getById(problemId);
    }

    @GetMapping("/problems")
    List<Problem> getAll(){
       return problemService.getAll();
    }

    @GetMapping("/problems/intensity/{intensity}")
    List<Problem> getByIntensity(@PathVariable("intensity") String intensity){
        return problemService.getByIntensity(intensity);
    }
}

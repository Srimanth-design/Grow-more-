package com.growmore.feign;


import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Farmer;
import com.growmore.model.Problem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PROBLEM-SERVICE",url = "http://localhost:8082/problem-api")
public interface IProblemFeign {

    @GetMapping("/problems/farmerId/{farmerId}")
    List<Problem> getProDetById(@PathVariable("farmerId") int farmerId);

//    @PostMapping("/problems")
//    Problem addProblem(@RequestBody Problem problem);
//
//    @PutMapping("/problems")
//    void updateProblem(@RequestBody Problem problem);
//
//    @DeleteMapping("/problems/problemId/{problemId}")
//    void deleteProblem(@PathVariable("problemId") int problemId);

    @GetMapping("/problems")
    List<Problem> getAllProblems();

}

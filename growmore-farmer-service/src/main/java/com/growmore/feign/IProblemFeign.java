package com.growmore.feign;


import com.growmore.exception.FarmerNotFoundException;
import com.growmore.model.Problem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PROBLEM-SERVICE",url = "http://localhost:8082/problem-api")
public interface IProblemFeign {

    @GetMapping("/problems")
    List<Problem> getAllPro();

    @GetMapping("/problems/problemId/{problemId}")
    Problem getProById(@PathVariable("problemId") int problemId) throws FarmerNotFoundException;

    @GetMapping("/problems/intensity/{intensity}")
    List<Problem> getByIntensity(@PathVariable("intensity") String intensity) throws FarmerNotFoundException;

    @GetMapping("/problems/fertilizer/{fertilizer}")
    List<Problem> getByFertilizer(@PathVariable("fertilizer") String fertilizer) throws  FarmerNotFoundException;


}

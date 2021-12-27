package com.growmore.controllers;

import com.growmore.exceptions.AnalystNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Farmer;
import com.growmore.service.IAnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyst-api")
public class AnalystController {
    IAnalystService analystService;

    @Autowired
    public void setAnalystService(IAnalystService analystService) {
        this.analystService = analystService;
    }

    @PostMapping("/analysts")
    Analyst addAnalyst(@RequestBody Analyst analyst) {
        return analystService.addAnalyst(analyst);
    }

    @PutMapping("/analysts")
    void updateAnalyst(@RequestBody Analyst analyst) {
        analystService.updateAnalyst(analyst);
    }

    @DeleteMapping("/analysts/analystIdId/{analystIdId}")
    void deleteAnalyst(@PathVariable("analystId") int analystId) {
        analystService.deleteAnalyst(analystId);
    }

    @GetMapping("/analysts/gender/{gender}")
    List<Analyst> getByGender(@PathVariable("gender") String gender) throws AnalystNotFoundException {
        return analystService.getByGender(gender);
    }

    @GetMapping("/analysts/age/{age}")
    List<Analyst> getByAgeLessThan(@PathVariable("age") int age) throws AnalystNotFoundException {
        return analystService.getByAgeLessThan(age);
    }

    @GetMapping("/analysts/analystId/{analystId}")
    Analyst getById(@PathVariable("analystId") int analystId) throws AnalystNotFoundException {
        return analystService.getById(analystId);
    }

    @GetMapping("/analysts")
    List<Analyst> getAll() {
        return analystService.getAll();
    }

    @GetMapping("/analysts/degree/{degree}/experience/{experience}")
    List<Analyst> getByDegreeAndExperience(@PathVariable("degree") String degree, @PathVariable("experience") int experience) throws AnalystNotFoundException {
        return analystService.getByDegreeAndExperience(degree, experience);
    }

    @GetMapping("/analysts/rating/{rating}")
    List<Analyst> getByRating(@PathVariable("rating") double rating) throws AnalystNotFoundException {
        return analystService.getByRating(rating);
    }
}





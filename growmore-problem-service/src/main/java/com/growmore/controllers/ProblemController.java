package com.growmore.controllers;

import com.growmore.exception.ProblemNotFoundException;
import com.growmore.model.Farmer;
import com.growmore.model.Fertilizers;
import com.growmore.model.Intensity;
import com.growmore.model.Problem;
import com.growmore.service.IProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem-api")
public class ProblemController {

    private Logger logger = LoggerFactory.getLogger(ProblemController.class);

    IProblemService problemService;

    /**
     * @param problemService
     */
    @Autowired
    public void setProblemService(IProblemService problemService) {
        this.problemService = problemService;
    }

    /**
     * @param problem
     * @return
     * @description Adding new problems farmer is facing
     */

    @PostMapping("/problems")
    ResponseEntity<Problem> addProblem(@RequestBody Problem problem) {
        Problem addProblem = problemService.addProblem(problem);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "New problem added");
        return ResponseEntity.accepted().headers(headers).body(addProblem);
    }

    /**
     * @param problem
     * @return
     * @description updating a particular farmer problem if there is any
     */

    @PutMapping("/problems")
    ResponseEntity<Void> updateProblem(@RequestBody Problem problem) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating..");
        problemService.updateProblem(problem);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    /**
     * @param problemId
     * @return
     * @description deleting problems from the problem ID
     */

    @DeleteMapping("/problems/problemId/{problemId}")
    ResponseEntity<Void> deleteProblem(@PathVariable("problemId") int problemId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting..");
        problemService.deleteProblem(problemId);
        return ResponseEntity.ok().headers(headers).build();
    }

    /**
     * @param problemId
     * @return
     * @description getting all problems from the problem ID
     */

    @GetMapping("/problems/problemId/{problemId}")
    ResponseEntity<Problem> getById(@PathVariable("problemId") int problemId) {
        logger.debug("Getting by Id.. using method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "problem Id");
        Problem problem = problemService.getById(problemId);
        logger.info("Got farmer problem details by Id:" + problem);
        return ResponseEntity.accepted().headers(headers).body(problem);
    }

    /**
     * @return
     * @description getting all problems
     */

    @GetMapping("/problems")
    ResponseEntity<List<Problem>> getAll() {
        List<Problem> problems = problemService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "showing all problems related to farmers  ");
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     * @param intensity
     * @return
     * @description getting all problems from the intensity of the issue farmer is in.
     */

    @GetMapping("/problems/intensity/{intensity}")
    ResponseEntity<List<Problem>> getByIntensity(@PathVariable("intensity") String intensity) {
        logger.debug("Get farmer by problem intensity inputs:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by problem intensity inputs");
        List<Problem> problems = problemService.getByIntensity(intensity);
        logger.info("Got farmer details by intensity of the problem :" + problems);
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     * @param fertilizer
     * @return
     * @throws ProblemNotFoundException
     * @description getting all problems from the fertilizers farmer used
     */

    @GetMapping("/problems/fertilizer/{fertilizer}")
    ResponseEntity<List<Problem>> getByFertilizer(@PathVariable("fertilizer") String fertilizer) throws ProblemNotFoundException {
        logger.debug("Get farmer by fertilizer inputs:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by farmer used fertilizer inputs");
        List<Problem> problems = problemService.getByFertilizer(fertilizer);
        logger.info("Got farmer details by intensity of the problem :" + problems);
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     * @param fertilizer
     * @param alternative
     * @return
     * @throws ProblemNotFoundException
     * @description getting all problems from the fertilizer and alternative used
     */

    @GetMapping("/problems/fertilizer/{fertilizer}/alternative/{alternative}")
    ResponseEntity<List<Problem>> getByFertAlter(@PathVariable("fertilizer") String fertilizer, @PathVariable("alternative") String alternative) throws ProblemNotFoundException {
        logger.debug("Get farmer by his/her problem and alternate solution:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by farmer problem and alternate solution");
        List<Problem> problems = problemService.getByFertAlter(fertilizer, alternative);
        logger.info("Got problem details from fertilizer details and alternative solution given by analyst :" + problems);
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     * @param alternative
     * @return
     * @throws ProblemNotFoundException
     * @description getting all problems from the alternative fertilizer farmer used
     */

    @GetMapping("/problems/alternative/{alternative}")
    ResponseEntity<List<Problem>> getByAlternate(@PathVariable("alternative") String alternative) throws ProblemNotFoundException {
        logger.debug("Got analyst suggested alternatives..");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by analyst suggested alternative");
        List<Problem> problems = problemService.getByAlternate(alternative);
        logger.info("Got problems alternative solutions given by analyst :" + problems);
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     * @param alternative
     * @param alternative2
     * @return
     * @throws ProblemNotFoundException
     * @description getting all problems from the alternative fertilizer farmer used
     */

    @GetMapping("/problems/alternative/{alternative}/altr2/{alternative2}")
    ResponseEntity<List<Problem>> getByAlternatives(@PathVariable("alternative") String alternative, @PathVariable("alternative2") String alternative2) throws ProblemNotFoundException {
        logger.debug("Got analyst suggested alternatives..");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by analyst suggested alternatives");
        List<Problem> problems = problemService.getByAlternatives(alternative, alternative2);
        logger.info("Got problems alternative solutions given by analyst :" + problems);
        return ResponseEntity.ok().headers(headers).body(problems);

    }

}

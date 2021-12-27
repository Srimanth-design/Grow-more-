package com.growmore.controllers;

import com.growmore.exceptions.AnalystNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Farmer;
import com.growmore.service.IAnalystService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyst-api")
public class AnalystController {
    private Logger logger = LoggerFactory.getLogger(AnalystController.class);
    IAnalystService analystService;

    /**
     *
     * @param analystService
     */
    @Autowired
    public void setAnalystService(IAnalystService analystService) {
        this.analystService = analystService;
    }

    /**
     *
     * @param analyst
     * @return
     * @descrption Adding new analysts whom farmer needed
     */
    @PostMapping("/analysts")
    ResponseEntity<Analyst> addAnalyst(@RequestBody Analyst analyst) {
        Analyst addAnalyst=analystService.addAnalyst(analyst);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","New Analyst Added");

        return ResponseEntity.accepted().headers(headers).body(addAnalyst);
    }

    /**
     *
     * @param analyst
     * @return
     * @descrption updating analysts for better information
     */
    @PutMapping("/analysts")
   ResponseEntity<Void> updateAnalyst(@RequestBody Analyst analyst) {
       HttpHeaders headers= new HttpHeaders();
       headers.add("desc","updating analyst....");

        analystService.updateAnalyst(analyst);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    /**
     * @param analystId
     * @return
     * @descrption deleting analysts who have not good knowledge
     */
    @DeleteMapping("/analysts/analystIdId/{analystIdId}")
    ResponseEntity<Void> deleteAnalyst(@PathVariable("analystId") int analystId) {
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Deleting analyst....");
        analystService.deleteAnalyst(analystId);
       return ResponseEntity.ok().headers(headers).build();
    }

    /**
     * @descrption getting analyst by giving gender
     * @param gender
     * @return
     * @throws AnalystNotFoundException
     */
    @GetMapping("/analysts/gender/{gender}")
   ResponseEntity<List<Analyst>> getByGender(@PathVariable("gender") String gender) throws AnalystNotFoundException {
     logger.debug("Get analyst by gender input");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting analyst by giving gender input....");
        List<Analyst>analysts=analystService.getByGender(gender);
        logger.info("Got the analyst details by his gender :" +analysts);
        return ResponseEntity.ok().headers(headers).body(analysts);



    }

    /**
     *  @descrption     getting analyst by giving age input
     * @param age
     * @return
     * @throws AnalystNotFoundException
     */
    @GetMapping("/analysts/experience/{experience}")
   ResponseEntity<List<Analyst>> getByExperience(@PathVariable("experience") int experience) throws AnalystNotFoundException {
        logger.debug("Get analyst by experience input");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting analyst by giving experience input....");
        List<Analyst>analysts=analystService.getByExperience(experience);
        logger.info("Got the analyst details by his experience :" +analysts);
        return ResponseEntity.ok().headers(headers).body(analysts);

    }

    /**
     *  @descrption getting analyst by giving id
     * @param analystId
     * @return
     * @throws AnalystNotFoundException
     */
    @GetMapping("/analysts/analystId/{analystId}")
   ResponseEntity<Analyst> getById(@PathVariable("analystId") int analystId) throws AnalystNotFoundException {
        logger.debug("Get analyst by Id input");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting analyst by giving Id input....");
       Analyst analyst = analystService.getById(analystId);
        logger.info("Got the analyst details by his Id :"+analyst);
        return ResponseEntity.accepted().headers(headers).body(analyst);

    }

    /**
     *  @descrption getting all analyst
     * @return
     */
    @GetMapping("/analysts")
    ResponseEntity<List<Analyst>> getAll() {
        List<Analyst>analysts=analystService.getAll();
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting all analyst ....");
        return ResponseEntity.ok().headers(headers).body(analysts);
    }

    /**
     * @descrption getting analyst by degree and experience
     * @param degree
     * @param experience
     * @return
     * @throws AnalystNotFoundException
     */
    @GetMapping("/analysts/degree/{degree}/experience/{experience}")
    ResponseEntity<List<Analyst>> getByDegreeAndExperience(@PathVariable("degree") String degree, @PathVariable("experience") int experience) throws AnalystNotFoundException {
        logger.debug("Get analyst by degree and experience input");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting analyst by degree and experience input....");
        List<Analyst>analysts=analystService.getByDegreeAndExperience(degree, experience);
        logger.info("Got the analyst details by degree and experience input  :" +analysts);
        return ResponseEntity.ok().headers(headers).body(analysts);
    }

    /**
     * @descrption getting analyst by rating
     * @param rating
     * @return
     * @throws AnalystNotFoundException
     */
    @GetMapping("/analysts/rating/{rating}")
    ResponseEntity<List<Analyst>> getByRating(@PathVariable("rating") double rating) throws AnalystNotFoundException {
        logger.debug("Get analyst by rating input");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","getting analyst by rating input....");
        List<Analyst>analysts=analystService.getByRating(rating);
        logger.info("Got the analyst details by rating input  :" +analysts);
        return ResponseEntity.ok().headers(headers).body(analysts);
    }
}





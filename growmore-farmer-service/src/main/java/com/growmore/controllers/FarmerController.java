package com.growmore.controllers;
import com.growmore.exception.FarmerNotFoundException;
import com.growmore.feign.IProblemFeign;
import com.growmore.model.Farmer;
import com.growmore.model.Problem;
import com.growmore.service.IFarmerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmer-api")
public class FarmerController {

    private Logger logger = LoggerFactory.getLogger(FarmerController.class);
    IFarmerService farmerService;

    @Autowired
    IProblemFeign problemFeign;

    /**
     *
     * @param farmerService
     * @description setter based dependency
     */
    @Autowired
    public void setFarmerService(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    /**
     * @param farmer
     * @return
     * @description adding farmer details
     */
    @PostMapping("/farmers")
    ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer) {
        Farmer addFarmer = farmerService.addFarmer(farmer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "New farmer addded");
        return ResponseEntity.accepted().headers(headers).body(addFarmer);
    }



    /**
     * @param farmer
     * @description updating farmer details
     */
    @PutMapping("/farmers")
    ResponseEntity<Void> updateFarmer(@RequestBody Farmer farmer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating..");
        farmerService.updateFarmer(farmer);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    /**
     * @param farmerId
     * @description Deleting farmer details from the farmer ID
     */
    @DeleteMapping("/farmers/farmerId/{farmerId}")
    ResponseEntity<Void> deleteFarmer(@PathVariable("farmerId") int farmerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting..");
        farmerService.deleteFarmer(farmerId);
        return ResponseEntity.ok().headers(headers).build();
    }

    /**
     * @param gender
     * @return
     * @throws FarmerNotFoundException
     * @description getting farmer details from the gender
     */
    @GetMapping("/farmers/gender/{gender}")
    ResponseEntity<List<Farmer>> getByGender(@PathVariable("gender") String gender) throws FarmerNotFoundException {
        logger.debug("Get by gender:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "gender");
        List<Farmer> farmers = farmerService.getByGender(gender);
        logger.info("Got farmer details by gender: " + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    /**
     * @param age
     * @return
     * @throws FarmerNotFoundException
     * @description Getting all the farmer details from the age
     */
    @GetMapping("/farmers/age/{age}")
    ResponseEntity<List<Farmer>> getByAge(@PathVariable("age") int age) throws FarmerNotFoundException {
        logger.debug("Get farmer by age:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "age");
        List<Farmer> farmers = farmerService.getByAge(age);
        logger.info("Got farmer details by age :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    /**
     * @param farmerId
     * @return
     * @throws FarmerNotFoundException
     * @description Getting farmer details from the farmer ID
     */
    @GetMapping("/farmers/farmerId/{farmerId}")
    ResponseEntity<Farmer> getById(@PathVariable("farmerId") int farmerId) throws FarmerNotFoundException {
        logger.debug("Getting by Id.. using method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "farmer Id");
        Farmer farmer = farmerService.getById(farmerId);
        logger.info("Got farmer details by Id:" + farmer);
        return ResponseEntity.accepted().headers(headers).body(farmer);

    }

    /**
     *
     * @return
     * @description Getting all farmers listed
     *
     */

    @GetMapping("/farmers")
    ResponseEntity<List<Farmer>> getAll() {
        List<Farmer> farmers = farmerService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "showing all farmers  ");
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    /**
     *
     * @param city
     * @return
     * @throws FarmerNotFoundException
     * @description Getting farmer details from the city
     *
     */

    @GetMapping("/farmers/city/{city}")
    ResponseEntity<List<Farmer>> getByCity(@PathVariable("city") String city) throws FarmerNotFoundException{
        logger.debug("Get farmer by city inputs:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by city inputs");
        List<Farmer> farmers = farmerService.getByCity(city);
        logger.info("Got farmer details by city :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }


    /**
     * @param soil
     * @param city
     * @return
     * @throws FarmerNotFoundException
     * @description getting farmer details from the soil and the city
     */
    @GetMapping("/farmers/soil/{soil}/city/{city}")
    ResponseEntity<List<Farmer>> getBySoilCity(@PathVariable("soil") String soil, @PathVariable("city") String city) throws FarmerNotFoundException {
        logger.debug("Get farmer by soil and city inputs:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by soil and city inputs");
        List<Farmer> farmers = farmerService.getBySoilCity(soil, city);
        logger.info("Got farmer details by soil and city :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    /**
     * @param soil
     * @return
     * @throws FarmerNotFoundException
     * @description checking farmer details from the soil details
     */

    @GetMapping("/farmers/soil/{soil}")
    ResponseEntity<List<Farmer>> getBySoil(@PathVariable("soil") String soil) throws FarmerNotFoundException {
        logger.debug("Get farmer by soil inputs:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by soil inputs");
        List<Farmer> farmers = farmerService.getBySoil(soil);
        logger.info("Got farmer details by soil :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    /**
     * ----------- Using feign Client ----------
     */

    /**
     *
     * @return
     * @description checking all problems from the farmer service
     *
     */

    @GetMapping("/farmers/problems")
    ResponseEntity<List<Problem>> getAllPro(){
        List<Problem> problems = problemFeign.getAllPro();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "showing all farmer problems  ");
        return ResponseEntity.ok().headers(headers).body(problems);
    }

    /**
     *
     * @param intensity
     * @return
     * @throws FarmerNotFoundException
     * @description checking problem intensity from the farmer service
     *
     */
    @GetMapping("farmers/problems/intensity/{intensity}")
    ResponseEntity<List<Problem>> getByIntensity(@PathVariable("intensity") String intensity) throws FarmerNotFoundException{
        logger.debug("Get farmer details by problem intensity details:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "from farmer service to problem inputs");
        List<Problem> farmers = problemFeign.getByIntensity(intensity);
        logger.info("Got farmer details by problem intensity :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

    @GetMapping("farmers/problems/fertilizer/{fertilizer}")
    ResponseEntity<List<Problem>> getByFertilizer(@PathVariable("fertilizer") String fertilizer){
        logger.debug("Get farmer details by fertilizers they used:");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "from farmer service to problem inputs");
        List<Problem> farmers = problemFeign.getByFertilizer(fertilizer);
        logger.info("Got farmer details by fertilizers they used :" + farmers);
        return ResponseEntity.ok().headers(headers).body(farmers);
    }

}

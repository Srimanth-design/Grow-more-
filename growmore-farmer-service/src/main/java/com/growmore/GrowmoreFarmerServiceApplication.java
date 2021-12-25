package com.growmore;

import com.growmore.model.*;
import com.growmore.service.IFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GrowmoreFarmerServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrowmoreFarmerServiceApplication.class, args);
    }

    IFarmerService farmerService;

    @Autowired
    public void setFarmerService(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @Override
    public void run(String... args) throws Exception {

        Analyst analyst = new Analyst("DR.Sigmon", "Male", "B.S.C Agriculture", 30, 4.5);

        Analyst analyst2 = new Analyst("Dr.Rohan", "Male", "Horticulture", 28, 3);

        Analyst analyst3 = new Analyst("Ramya", "Female", "B.S.C Agriculture", 10, 4);

        Solution solution = new Solution("Apply organic ZEDO fertilizer", "https://tse3.mm.bing.net/th/id/OIP.JC7SMgFXO7H9Wsn_899IAwAAAA?pid=ImgDet&rs=1", "Apply afternoons and nights 3 times a week", "Nitrex");

        Solution solution2 = new Solution("Apply organic Ketornol fertilizer", "https://tse3.mm.bing.net/th/id/OIP.JC7SMgFXO7H9Wsn_899IAwAAAA?pid=ImgDet&rs=1", "Apply mornings 3 times a week", "Kimopal");

        Solution solution3 = new Solution("Apply organic Kinde fertilizer", "https://tse3.mm.bing.net/th/id/OIP.JC7SMgFXO7H9Wsn_899IAwAAAA?pid=ImgDet&rs=1", "Apply 2 times a week", "Zindro");

        Solution solution4 = new Solution("Apply organic Lonmaoi fertilizer", "https://tse3.mm.bing.net/th/id/OIP.JC7SMgFXO7H9Wsn_899IAwAAAA?pid=ImgDet&rs=1", "Apply 4 times a week", "Lopioc");

        Solution solution5 = new Solution("Apply organic Seripo fertilizer", "https://tse3.mm.bing.net/th/id/OIP.JC7SMgFXO7H9Wsn_899IAwAAAA?pid=ImgDet&rs=1", "Apply 1 time a week", "Liop");

        Set<Solution> solutions = new HashSet<>(Arrays.asList(solution, solution2));
        Set<Solution> solutions1 = new HashSet<>(Arrays.asList(solution, solution2, solution3, solution4, solution5));
        Set<Solution> solutions2 = new HashSet<>(Arrays.asList(solution, solution2, solution5));

        Problem problem = new Problem("Bugs and insects", Intensity.LOW, "https://tse4.mm.bing.net/th/id/OIP.E0b6sLSBAcOPtDjBkUeE8AHaFj?pid=ImgDet&rs=1", Fertilizers.NITREX, solutions, analyst);

        Problem problem1 = new Problem("Less yeild", Intensity.LOW, "https://tse4.mm.bing.net/th/id/OIP.E0b6sLSBAcOPtDjBkUeE8AHaFj?pid=ImgDet&rs=1", Fertilizers.BONIDE, solutions1, analyst2);

        Problem problem2 = new Problem("Leaf damage", Intensity.HIGH, "https://tse4.mm.bing.net/th/id/OIP.E0b6sLSBAcOPtDjBkUeE8AHaFj?pid=ImgDet&rs=1", Fertilizers.EUROCHEM, solutions2, analyst3);

		Set<Problem> problems = new HashSet<>(Arrays.asList(problem,problem1));
        Set<Problem> problems1 = new HashSet<>(Arrays.asList(problem2));
        Set<Problem> problems2 = new HashSet<>(Arrays.asList(problem1,problem2));

        FarmDetails details = new FarmDetails("Tomatoes", "10 acres", "red soil", "Ongole", 523001);
        Farmer farmer = new Farmer("Ramesh", 45, "Male", problems, details);


        FarmDetails details1 = new FarmDetails("Mangoes", "40 acres", "red soil", "Himinpalli", 624001);
        Farmer farmer1 = new Farmer("Mrinali", 41, "Female", problems1, details1);

        FarmDetails details2 = new FarmDetails("Coconut", "20 acres", "black soil", "Bisanpalli", 324001);
        Farmer farmer2 = new Farmer("Kiran", 38, "Male", problems2, details2);


        //farmerService.addFarmer(farmer);
        //farmerService.addFarmer(farmer1);
        //farmerService.addFarmer(farmer2);

    }
}

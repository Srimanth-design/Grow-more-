package com.growmore.service;


import com.growmore.exceptions.AnalystNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Farmer;

import java.util.List;

public interface IAnalystService {


    Analyst addAnalyst(Analyst analyst);

    void updateAnalyst(Analyst analyst);

    void deleteAnalyst(int analystId);

    List<Analyst> getByGender(String gender) throws AnalystNotFoundException;

    List<Analyst> getByExperience(int experience) throws AnalystNotFoundException;

    Analyst getById(int analystId) throws AnalystNotFoundException;

    List<Analyst> getAll();

    List<Analyst> getByDegreeAndExperience(String degree, int experience) throws AnalystNotFoundException;

    List<Analyst> getByRating(double rating) throws AnalystNotFoundException;

}

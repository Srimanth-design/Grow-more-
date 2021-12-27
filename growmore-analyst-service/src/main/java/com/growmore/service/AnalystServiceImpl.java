package com.growmore.service;

import com.growmore.exceptions.AnalystNotFoundException;
import com.growmore.model.Analyst;
import com.growmore.model.Farmer;
import com.growmore.repository.IAnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalystServiceImpl implements IAnalystService {

    IAnalystRepository analystRepository;

    @Autowired
    public void setAnalystRepository(IAnalystRepository analystRepository) {
        this.analystRepository = analystRepository;
    }

    @Override
    public Analyst addAnalyst(Analyst analyst) {
        return analystRepository.save(analyst);
    }

    @Override
    public void updateAnalyst(Analyst analyst) {
        analystRepository.save(analyst);
    }

    @Override
    public void deleteAnalyst(int analystId) {
        analystRepository.deleteById(analystId);
    }

    @Override
    public List<Analyst> getByGender(String gender) throws AnalystNotFoundException {
        List<Analyst> analysts = analystRepository.getByGender(gender);
        if (analysts.isEmpty()) {
            throw new AnalystNotFoundException("Gender Not Found");
        }
        return analysts;
    }

    @Override
    public List<Analyst> getByExperience(int experience) throws AnalystNotFoundException {
        List<Analyst> analysts = analystRepository.getByExperience(experience);
        if (analysts.isEmpty()){
            throw new AnalystNotFoundException("Such experienced are not available");
        }
        return analysts;
    }


    @Override
    public Analyst getById(int analystId) throws AnalystNotFoundException {
        return analystRepository.findById(analystId).orElseThrow(() -> {
            throw new AnalystNotFoundException("Invalid Id");
        });
    }

    @Override
    public List<Analyst> getAll() {
        return analystRepository.findAll();
    }

    @Override
    public List<Analyst> getByDegreeAndExperience(String degree, int experience) throws AnalystNotFoundException {
        List<Analyst> analysts = analystRepository.getByDegreeAndExperience(degree, experience);
        if (analysts.isEmpty()) {
            throw new AnalystNotFoundException("Enter Correct Input");
        }
        return analysts;
    }

    @Override
    public List<Analyst> getByRating(double rating) throws AnalystNotFoundException {
        List<Analyst> analysts = analystRepository.getByRating(rating);
        if (analysts.isEmpty()) {
            throw new AnalystNotFoundException("Invalid Rating");
        }
        return analysts;
    }
}

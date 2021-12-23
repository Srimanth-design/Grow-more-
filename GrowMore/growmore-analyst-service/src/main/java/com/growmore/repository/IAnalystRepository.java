package com.growmore.repository;

import com.growmore.model.Analyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnalystRepository extends JpaRepository<Analyst,Integer> {

}

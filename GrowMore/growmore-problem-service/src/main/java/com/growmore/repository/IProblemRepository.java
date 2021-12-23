package com.growmore.repository;

import com.growmore.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProblemRepository extends JpaRepository<Problem,Integer> {


}

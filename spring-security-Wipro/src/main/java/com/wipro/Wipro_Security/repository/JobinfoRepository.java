package com.wipro.Wipro_Security.repository;

import com.wipro.Wipro_Security.model.Jobinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobinfoRepository extends JpaRepository<Jobinfo, Integer> {
}

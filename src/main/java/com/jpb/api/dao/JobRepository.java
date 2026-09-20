package com.jpb.api.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpb.api.entity.Company;
import com.jpb.api.entity.Job;

public interface JobRepository extends JpaRepository<Job,Long> {

	List<Job> findByTitleContainingIgnoreCase(String keyword);


	List<Job> findByLocationIgnoreCase(String location);


	List<Job> findByCompany(Company company);

}

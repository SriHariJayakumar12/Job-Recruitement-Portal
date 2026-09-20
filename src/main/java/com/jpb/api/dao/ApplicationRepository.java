package com.jpb.api.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpb.api.entity.Application;
import com.jpb.api.entity.Candidate;
import com.jpb.api.entity.Job;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

	List<Application> findByJob(Job job);

	List<Application> findByCandidate(Candidate candidate);

}

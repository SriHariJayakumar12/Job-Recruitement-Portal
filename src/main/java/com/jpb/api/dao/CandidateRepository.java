package com.jpb.api.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jpb.api.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

}

package com.jpb.api.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpb.api.dao.CandidateRepository;
import com.jpb.api.entity.Candidate;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate saveCandidate(Candidate candidate) {
        System.out.println("CandidateService.saveCandidate()");
        candidate.setCreatedAt(LocalDateTime.now());
        candidate.setUpdatedAt(LocalDateTime.now());
        candidate.setActive(true);
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        System.out.println("CandidateService.getAllCandidates()");
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        System.out.println("CandidateService.getCandidateById()");
        return candidateRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Candidate not found"));
    }

    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        System.out.println("CandidateService.updateCandidate()");
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Candidate not found with id : " + id));

        candidate.setFirstName(updatedCandidate.getFirstName());
        candidate.setLastName(updatedCandidate.getLastName());
        candidate.setEmail(updatedCandidate.getEmail());
        candidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
        candidate.setCity(updatedCandidate.getCity());
        candidate.setSkills(updatedCandidate.getSkills());
        candidate.setExperienceYears(updatedCandidate.getExperienceYears());
        candidate.setQualification(updatedCandidate.getQualification());
        candidate.setResumeUrl(updatedCandidate.getResumeUrl());
        candidate.setLinkedinUrl(updatedCandidate.getLinkedinUrl());
        candidate.setGithubUrl(updatedCandidate.getGithubUrl());
        candidate.setUpdatedAt(LocalDateTime.now());
        
        return candidateRepository.save(candidate);
    }

   public void deleteCandidate(Long id) {
    System.out.println("CandidateService.deleteCandidate()");
    Candidate candidate = candidateRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Candidate not found"));
    candidate.setActive(false);
    candidate.setUpdatedAt(LocalDateTime.now());
    candidateRepository.save(candidate);
}
}

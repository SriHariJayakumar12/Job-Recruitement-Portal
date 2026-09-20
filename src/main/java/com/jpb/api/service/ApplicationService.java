package com.jpb.api.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpb.api.dao.ApplicationRepository;
import com.jpb.api.dao.CandidateRepository;
import com.jpb.api.dao.JobRepository;
import com.jpb.api.entity.Application;
import com.jpb.api.entity.Candidate;
import com.jpb.api.entity.Job;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    public Application createApplication(Long candidateId,Long jobId,String coverLetter) {
        System.out.println("ApplicationService.createApplication()");
        
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() ->
                        new RuntimeException("Candidate not found"));
        Job job = jobRepository.findById(jobId).orElseThrow(() ->
                        new RuntimeException("Job not found"));
        
        Application application = new Application();

        application.setCandidate(candidate);
        application.setJob(job);
        application.setCoverLetter(coverLetter);
        application.setAppliedDate(LocalDate.now());
        application.setStatus("APPLIED");
        application.setCreatedAt(LocalDateTime.now());
        application.setUpdatedAt(LocalDateTime.now());
        application.setActive(true);
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
    	 System.out.println("ApplicationService.getAllApplications()");
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id) {
    	System.out.println("ApplicationService.getApplicationById()");
        return applicationRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Application not found"));
    }

    public List<Application> getApplicationsByJob(Long jobId) {
    	System.out.println("ApplicationService.getApplicationsByJob()");
        Job job = jobRepository.findById(jobId).orElseThrow(() ->
                        new RuntimeException("Job not found"));
        return applicationRepository.findByJob(job);
    }

    public List<Application> getApplicationsByCandidate(Long candidateId) {
    	System.out.println("ApplicationService.getApplicationsByCandidate()");
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() ->
                        new RuntimeException("Candidate not found"));
        return applicationRepository.findByCandidate(candidate);
    }

    public Application updateApplication(Long id,String status,String coverLetter) {
    	System.out.println("ApplicationService.updateApplication()");
        Application application = applicationRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Application not found"));

        application.setStatus(status);
        application.setCoverLetter(coverLetter);
        application.setUpdatedAt(LocalDateTime.now());
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
    	System.out.println("ApplicationService.deleteApplication()");
        Application application = applicationRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Application not found"));
        application.setActive(false);
        application.setUpdatedAt(LocalDateTime.now());
        applicationRepository.save(application);
    }
}
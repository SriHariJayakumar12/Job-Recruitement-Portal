package com.jpb.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpb.api.dao.CompanyRepository;
import com.jpb.api.dao.JobRepository;
import com.jpb.api.entity.Company;
import com.jpb.api.entity.Job;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Job saveJob(Job job, Long companyId) {
        System.out.println("JobService.saveJob()");
        Company company = companyRepository.findById(companyId).orElseThrow(() ->
                        new RuntimeException("Company not found"));

        job.setCompany(company);
        job.setCreatedAt(LocalDateTime.now());
        job.setUpdatedAt(LocalDateTime.now());
        job.setActive(true);
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
    	System.out.println("JobService.getAllJobs() ");
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
    	System.out.println("JobService.getJobById()");
        return jobRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Job not found"));
    }

    public Job updateJob(Long id, Job updatedJob) {
        System.out.println("JobService.updateJob()");
        Job job = jobRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Job not found"));

        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setSalary(updatedJob.getSalary());
        job.setLocation(updatedJob.getLocation());
        job.setVacancies(updatedJob.getVacancies());
        job.setExperienceRequired(updatedJob.getExperienceRequired());
        job.setSkillsRequired(updatedJob.getSkillsRequired());
        job.setJobType(updatedJob.getJobType());
        job.setApplicationDeadline(updatedJob.getApplicationDeadline());
        job.setUpdatedAt(LocalDateTime.now());

        return jobRepository.save(job);
    }
    
    public void deleteJob(Long id) {
    	System.out.println("JobService.deleteJob()");
        Job job = jobRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Job not found"));
        job.setActive(false);
        job.setUpdatedAt(LocalDateTime.now());
        jobRepository.save(job);
    }

    public List<Job> searchJobs(String keyword) {
    	System.out.println("JobService.searchJobs()");
        return jobRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Job> getJobsByLocation(String location) {
    	System.out.println("JobService.getJobsByLocation()");
        return jobRepository.findByLocationIgnoreCase(location);
    }

    public List<Job> getJobsByCompany(Long companyId) {
    	System.out.println("JobService.getJobsByCompany()");
        Company company = companyRepository.findById(companyId).orElseThrow(() ->
                        new RuntimeException("Company not found"));
        return jobRepository.findByCompany(company);
    }
}

package com.jpb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpb.api.entity.Job;
import com.jpb.api.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job saveJob(@RequestBody Job job,@RequestParam Long companyId) {
        System.out.println("JobController.saveJob()");
        return jobService.saveJob(job, companyId);
    }

    @GetMapping
    public List<Job> getAllJobs() {
    	System.out.println("JobController.getAllJobs()");
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
    	System.out.println("JobController.getJobById()");
        return jobService.getJobById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,@RequestBody Job job) {
    	System.out.println("JobController.updateJob()");
        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
    	System.out.println("JobController.deleteJob()");
        jobService.deleteJob(id);
        return "Job deleted successfully";
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String keyword) {
    	System.out.println("JobController.searchJobs()");
        return jobService.searchJobs(keyword);
    }

    @GetMapping("/location/{city}")
    public List<Job> getJobsByLocation(@PathVariable String city) {
    	System.out.println("JobController.getJobsByLocation()");
        return jobService.getJobsByLocation(city);
    }

    @GetMapping("/company/{companyId}")
    public List<Job> getJobsByCompany( @PathVariable Long companyId) {
    	System.out.println("JobController.getJobsByLocation()");
        return jobService.getJobsByCompany(companyId);
    }
}

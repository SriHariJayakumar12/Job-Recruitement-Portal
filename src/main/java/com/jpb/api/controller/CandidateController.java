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
import org.springframework.web.bind.annotation.RestController;
import com.jpb.api.entity.Candidate;
import com.jpb.api.service.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        System.out.println("CandidateController.saveCandidate()");
        return candidateService.saveCandidate(candidate);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
    	System.out.println("CandidateController.getAllCandidates()");
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
    	System.out.println("CandidateController.getCandidateById()");
        return candidateService.getCandidateById(id);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id,@RequestBody Candidate candidate) {
    	System.out.println("CandidateController.updateCandidate()");
        return candidateService.updateCandidate(id, candidate);
    }

    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable Long id) {
    	System.out.println("CandidateController.deleteCandidate()");
        candidateService.deleteCandidate(id);
        return "Candidate deleted successfully";
    }
}
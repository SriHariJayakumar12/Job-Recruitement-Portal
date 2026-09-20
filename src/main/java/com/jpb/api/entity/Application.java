package com.jpb.api.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Application {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Boolean active;
	
    private LocalDate appliedDate;

    private String status;

    @Column(length = 2000)
    private String coverLetter;
    
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}

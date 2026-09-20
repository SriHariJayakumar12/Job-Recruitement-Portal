package com.jpb.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Boolean active;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private String city;

	private String skills;

	private Integer experienceYears;

	private String qualification;

	private String resumeUrl;

	private String linkedinUrl;

	private String githubUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Application> applications;
}
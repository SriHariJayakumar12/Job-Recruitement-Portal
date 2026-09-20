package com.jpb.api.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Boolean active;
	
    private String name;

    private String email;

    private String phoneNumber;
}

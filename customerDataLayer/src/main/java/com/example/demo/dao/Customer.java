package com.example.demo.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -8382153958248881509L;

	@Id
	private String email;
	
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	
	private String dob;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<String> addresses;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime registeredDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

}

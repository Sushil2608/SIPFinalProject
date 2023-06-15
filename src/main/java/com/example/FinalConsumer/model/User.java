package com.example.FinalConsumer.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "First_Name", nullable = false)
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Skillset")
	private List<String> skillset;
	
	@Column(name = "College_Name")
	private String collegeName;
	
	@Column(name = "Organisation")
	private String organisation;
	
	@Column(name = "Duration")
	private int duration;

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", skillset=" + skillset
				+ ", collegeName=" + collegeName + ", organisation=" + organisation + ", duration=" + duration + "]";
	}
	
}

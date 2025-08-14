package com.sample.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String password;
	private String fullname;
	private String gender;
	private String profilePic;
	private String role;
	private boolean isactive;
	private LocalDateTime passwordLastUpdated;
}

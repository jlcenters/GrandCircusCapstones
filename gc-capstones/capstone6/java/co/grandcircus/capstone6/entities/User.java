package co.grandcircus.capstone6.entities;

import java.util.*;
import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Task> tasks;

	
	
//GETSET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	
	
//CONSTRUCTOR
	public User() {
		
	}
	public User(Long id) {
		this.id = id;
	}
	
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
//TOSTRING
	@Override
	public String toString() {
		return "User ID:" + id + ", Username:" + username + "Password:" + password + ", Tasks:" + tasks;
	}
}

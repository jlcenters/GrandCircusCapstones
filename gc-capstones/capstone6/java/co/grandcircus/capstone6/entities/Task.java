package co.grandcircus.capstone6.entities;

import java.util.Optional;

import javax.persistence.*;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private String date;
	private String completion;

	@ManyToOne
	private User user;
 


//GETSET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//CONSTRUCTORS
	public Task() {
		
	}
	public Task(String description, String date, User optional) {
		this.date = date;
		this.description = description;
		this.user = optional;
	}

//TOSTRING
	@Override
	public String toString() {
		return String.format("%-14s %-14s |%s", date, completion, description);
	}
}

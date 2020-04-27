package week2capstone;


public class Task {

//DECLARE, GET AND SET
	private String description;
	private String name;
	private String date;
	private String completion;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
//CONSTRUCTORS
	public Task() {
		this.completion = "Incomplete";
	}
	
	public Task(Task task,String completion) {
		name = task.getName();
		date = task.getDate();
		description = task.getDescription();
		this.completion = completion;
	}
	
	public Task(String date, String name, String description) {
		this.name = name;
		this.description = description;
		this.completion = "Incomplete";
		this.date = date;
	}
	
	
	
//TO STRING
	@Override
	public String toString() {
		return String.format("%-10s %-14s %-14s |%s", name,date,completion,description);
	}
	
	
}

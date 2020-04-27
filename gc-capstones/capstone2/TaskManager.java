package week2capstone;
/**
 * 
 * @author JillianCenters
 *
 * 
 */
import java.util.*;

public class TaskManager {

	public static void main(String[] args) {
		String userInput = "";
		int userNum = 10;
		Scanner scnr = new Scanner(System.in);
		
//ADD A DEFAULT TASK TO LIST
		Task jill = new Task("02/10/2020","Jill","Program a working Task Manager");
		Map<Integer,Task> tasks = new HashMap<>();
		tasks.put(1, jill);

		List<String> menu = new ArrayList<>();
		menu.add("See List");
		menu.add("Add Task");
		menu.add("Edit Completion Status");
		menu.add("Delete Task");
		
		
		
//START
		System.out.println("Welcome to the Company Task Manager! [PATENT PENDING]");
		while(userNum != 0) {
			System.out.println("\nEnter a number from the list below to begin.\n");
			
//PRINT OUT MENU AND GET USER INPUT
			for(int i = 0; i < menu.size(); ++i) {
				System.out.println(i + 1 + ":" + menu.get(i));
			}
			System.out.println("Enter \"QUIT\" to quit the program.");
			userNum = Validator.getMenuNum(scnr, "Please enter a number from the list: ", 1, 4);
			if(userNum == 0) {
				break;
			}
			
		
			
//PERFORM SELECTED TASK
			System.out.println(menu.get(userNum - 1).toUpperCase() + ": ");
			if(userNum == 1) {
				getList(tasks);
			}else if(userNum == 2) {
				addTask(tasks, scnr, userInput,userNum);
			}else if(userNum == 3) {
				changeCompletion(tasks, scnr, userInput, userNum);
			}else {
				removeTask(tasks, scnr, userInput, userNum);
			}
			
		}
		
//STOP
		System.out.println("Goodbye!");
		scnr.close();
	}

	

	
	
	
//METHODS
	
	

//PRINT LIST	
	public static void getList(Map<Integer,Task> tasks) {
		System.out.println("");
		if(tasks.size() == 0) {
			System.out.println("You currently have no active tasks. Good job keeping up!");
		}else {
			System.out.println("|-------------------------------------------------------------------------------------|\n");
			System.out.println(String.format("%-5s%-11s%-15s%-15s|%s", " #|","NAME","DUE DATE","COMPLETION","TASK"));
			System.out.println("|-------------------------------------------------------------------------------------|");
			for(int i = 1; i <= tasks.size(); ++i) {
				System.out.println(String.format("%-5s", " " + i + "| ") + tasks.get(i));
				System.out.println("|-------------------------------------------------------------------------------------|");
			}
		}
	
	}
		
//ADD TASK ITEM	
	public static void addTask(Map<Integer, Task> tasks,Scanner scnr, String userInput, int userNum) {
		System.out.print("\nHow many tasks would you like to add?");
		userNum = Validator.getInt(scnr, "Please enter a whole number only: ");
		
		for(int i = 1; i <= userNum; ++i) {
			Task userTask = new Task();
			System.out.println("\nTASK " + i + ":");
			System.out.print("\nWhen's the due date? [MM/DD/YYYY format] ");
			userInput = Validator.getDate(scnr, "");
			userTask.setDate(userInput);
			userInput = Validator.getString(scnr, "Who needs to complete this task?");
			userTask.setName(userInput);
			userInput = Validator.getString(scnr, "What does " + userInput + " need to do?");
			userTask.setDescription(userInput);
			tasks.put(tasks.size() + 1, userTask);
		}
	}
		
//SET COMPLETION STATUS
	public static void changeCompletion(Map<Integer,Task> tasks, Scanner scnr,String userInput, int userNum) {
		System.out.print("\nEnter the index number of who you would like to mark: ");
		userNum = Validator.getMenuNum(scnr, "Please enter a number from the List: ", 1, tasks.size());
		Task update = new Task(tasks.get(userNum),"Complete");
		tasks.replace(userNum, tasks.get(userNum), update);
		System.out.println("\n" + tasks.get(userNum).getName() + "'s task is now set to Complete. Good Work!");
	}
	
	
	
//REMOVE TASK ITEM
	public static void removeTask(Map<Integer,Task> tasks, Scanner scnr,String userInput, int userNum) {
		System.out.print("\nEnter the index number of who you would like to remove: ");
		userNum = Validator.getMenuNum(scnr, "Please enter a number from the list: ", 1, tasks.size());
		System.out.println("\nRemoved " + tasks.get(userNum).getName() + "'s task from the list.");
		
		tasks.replace(userNum, tasks.get(userNum + 1));
		for(int i = 1; i <= tasks.size(); ++i) {
			if(i == (tasks.size())) {
				tasks.remove(i);
				break;			
			}else {
				tasks.replace((userNum + i), tasks.get(userNum + i + 1));
			}
		}
	}
	
	
	
}

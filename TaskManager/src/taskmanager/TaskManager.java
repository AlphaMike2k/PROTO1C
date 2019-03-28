
package taskmanager;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

	public static ArrayList<Task> tasks = new ArrayList<Task>();
	
	public static void main(String[] args) {
		
		int choice = 1;
		Scanner input = new Scanner(System.in);
		
		do {
			printMenu();
			choice = input.nextInt();
			input.nextLine();
			System.out.println();
			
			if(choice == 1) {
				System.out.print("Enter Task Name:");
				String taskName = input.nextLine();
				System.out.print("Enter Event Description:");
				String eventDescription = input.nextLine();
				
				tasks.add(new Task(taskName, eventDescription));
			}
			else if(choice == 2) {
				System.out.print("Enter the ID of the Task you want to delete: ");
				int id = input.nextInt();
				
				Task task = removeTask(id);
				
				if(task == null) {
					System.out.println("No task with that id exists!");
				}
				else {
					System.out.println("Deleted Task");
					System.out.println(task.toString());
				}
			}
			else if(choice == 3) {
				
				for(int i = 0; i < tasks.size(); i++) {
					System.out.println(tasks.get(i).toString());
				}
			}
			
			
		}while(choice != 4);
	}
	
	public static void printMenu() {
		System.out.println();
		System.out.println("Press 1 to Add a task");
		System.out.println("Press 2 to Delete a task");
		System.out.println("Press 3 to Display all tasks");
		System.out.println("Press 4 to Quit");
		System.out.print("Enter your choice: ");
	}
	
	public static Task removeTask(int taskID) {
		
		for(int i = 0; i < tasks.size(); i++) {
			
			if(tasks.get(i).getTaskID() == taskID) {
				
				return tasks.remove(i);
			}
		}
		
		return null;
	}

}


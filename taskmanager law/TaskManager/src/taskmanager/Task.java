
package taskmanager;


public class Task {

	private int taskID;
	private String taskName;
	private String eveDesc;
	private static int taskIDCounter = 1;
	
	public Task(String taskName, String eveDesc) {
		setTaskID(taskIDCounter);
		setTaskName(taskName);
		setEveDesc(eveDesc);
		taskIDCounter++;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getEveDesc() {
		return eveDesc;
	}

	public void setEveDesc(String eveDesc) {
		this.eveDesc = eveDesc;
	}

	public static int getTaskIDCounter() {
		return taskIDCounter;
	}

	public static void setTaskIDCounter(int taskIDCounter) {
		Task.taskIDCounter = taskIDCounter;
	}
	
	public String toString() {
		
		return "Task ID: " +  getTaskID() + ", Task Name: " + getTaskName() + ", Event Description: " + getEveDesc();
	}
	 
}


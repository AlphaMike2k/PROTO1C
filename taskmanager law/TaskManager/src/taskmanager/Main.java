package taskmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group();
		addComponent(root);
		Scene mainScene = new Scene(root, 700, 500, Color.LIGHTCYAN);
		stage.setScene(mainScene);
		stage.setTitle("Task Manager");
		stage.setHeight(500);
		stage.setWidth(700);
		stage.show();
	}
	
	
	private void addComponent(Group root) {
		
		Text title_lbl = new Text("Task Manager");
		title_lbl.setLayoutX(250);
		title_lbl.setLayoutY(50);
		title_lbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		title_lbl.setUnderline(true);
		
		Label add_lbl = new Label("Add Task");
		add_lbl.setLayoutX(170);
		add_lbl.setLayoutY(105);
		add_lbl.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		Label task_name_lbl = new Label("Task Name:");
		task_name_lbl.setLayoutX(80);
		task_name_lbl.setLayoutY(150);
		task_name_lbl.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		
		Label event_description_lbl = new Label("Event Description:");
		event_description_lbl.setLayoutX(40);
		event_description_lbl.setLayoutY(200);
		event_description_lbl.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		
		TextField task_name_txt = new TextField();
		task_name_txt.setLayoutX(170);
		task_name_txt.setLayoutY(150);
		
		TextField event_description_txt = new TextField();
		event_description_txt.setLayoutX(170);
		event_description_txt.setLayoutY(200);
		
		Button add_task_btn = new Button("      ADD      ");
		add_task_btn.setLayoutX(170);
		add_task_btn.setLayoutY(250);
		add_task_btn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		
		Label view_lbl = new Label("View Task");
		view_lbl.setLayoutX(460);
		view_lbl.setLayoutY(100);
		view_lbl.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		ListView<String> list = new ListView<String>();
		list.setLayoutX(400);
		list.setLayoutY(150);
		list.setPrefHeight(200);
		
		Button delete_task_btn = new Button("  Delete  ");
		delete_task_btn.setLayoutX(470);
		delete_task_btn.setLayoutY(370);
		delete_task_btn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		
		delete_task_btn.disableProperty().bind(list.getSelectionModel().selectedItemProperty().isNull());
		
		add_task_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				String taskName = task_name_txt.getText();
				String eventDescription = event_description_txt.getText();
				
				if(taskName.equals("") || eventDescription.equals("")) {
					return;
				}
				
				Task task = new Task(taskName, eventDescription);
				list.getItems().add("TaskID: " + task.getTaskID()  + "\nTask Name: " + taskName + "\nEvent Description: " + eventDescription);
				
                                task_name_txt.setText("");
                                event_description_txt.setText("");
			}
			
		});
		
		delete_task_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				list.getItems().remove(list.getSelectionModel().getSelectedIndex());
				
			}
			
		});
		
		
		root.getChildren().addAll(title_lbl, add_lbl, task_name_lbl,event_description_lbl,
				task_name_txt, event_description_txt, add_task_btn, view_lbl,list, delete_task_btn);
		
	}
	

}

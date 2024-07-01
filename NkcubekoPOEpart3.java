/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.nkcubekopoepart2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nkcubeko
 */
public class NkcubekoPOEpart3 {

   public static class ToLogin {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final ArrayList<Task> tasks;
    private String[] developers;
    private String[] taskNames;
    private int[] taskIDs;
    private int[] taskDuration;
    private String[] taskStatus;
    

    public ToLogin(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tasks = new ArrayList<>();
        this.developers = new String[100]; // Adjust the size as needed
        this.taskNames = new String[100]; // Adjust the size as needed
        this.taskIDs = new int[100]; // Adjust the size as needed
        this.taskDuration = new int[100]; // Adjust the size as needed
        this.taskStatus = new String[100]; // Adjust the size as needed

        
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }
        }

        return password.length() >= 8 && hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    public String registerUser() {
        if (checkUserName() && checkPasswordComplexity()) {
            return "Username successfully captured\nPassword successfully captured";
        } else {
            StringBuilder errorMessage = new StringBuilder();
            if (!checkUserName()) {
                errorMessage.append("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.\n");
            }
            if (!checkPasswordComplexity()) {
                errorMessage.append("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.\n");
            }
            return errorMessage.toString();
        }
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
    
    public void displayTasksWithStatusDone() {
    for (int i = 0; i < tasks.size(); i++) {
        if (taskStatus[i].equalsIgnoreCase("done")) {
            JOptionPane.showMessageDialog(null,"Developer: " + developers[i]
                                                        + "Task Name: " + taskNames[i]
                                                         );
            System.out.println("Task Name: " + taskNames[i]);
            System.out.println("Task Duration: " + taskDuration[i]);
            System.out.println();
        }
    }
}
    
    public void displayTaskWithLongestDuration() {
    int longestDuration = 0;
    int longestDurationIndex = -1;

    for (int i = 0; i < tasks.size(); i++) {
        if (taskDuration[i] > longestDuration) {
            longestDuration = taskDuration[i];
            longestDurationIndex = i;
        }
    }

    if (longestDurationIndex != -1) {
        JOptionPane.showMessageDialog(null,"Developer: " + developers[longestDurationIndex]);
        JOptionPane.showMessageDialog(null,"Task Duration: " + taskDuration[longestDurationIndex]);
    }
}

    
    public void searchTaskByName(String taskName) {
    for (int i = 0; i < tasks.size(); i++) {
        if (taskNames[i].equalsIgnoreCase(taskName)) {
           JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i]
                   + "Developer: " + developers[i]
                    +"Task Status: " + taskStatus[i]);
           
            return;
        }
    }
    System.out.println("Task not found.");
}

    public void searchTasksByDeveloper(String developer) {
    boolean foundTasks = false;

    for (int i = 0; i < tasks.size(); i++) {
        if (developers[i].equalsIgnoreCase(developer)) {
            JOptionPane.showMessageDialog(null,"Task Name: " + taskNames[i] +"Task Status: " + taskStatus[i]) ;
            
            foundTasks = true;
        }
    }

    if (!foundTasks) {
        System.out.println("No tasks found for the given developer.");
    }
}



    public void runTaskManager() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        boolean isRunning = true;
        while (isRunning) {
            String input = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");
            if (input != null && input.matches("\\d+")) {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1 -> addTasks();
                    case 2 -> showReport();
                    case 3 -> {
                        isRunning = false;
                        JOptionPane.showMessageDialog(null, "Exiting...");
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
            }
        }
    }
    
    public void deleteTaskByName(String taskName) {
    for (int i = 0; i < tasks.size(); i++) {
        if (taskNames[i].equalsIgnoreCase(taskName)) {
            // Delete the task by shifting elements in the arrays
            for (int j = i; j < tasks.size() - 1; j++) {
                taskNames[j] = taskNames[j + 1];
                // Similarly, shift other arrays
            }

            tasks.remove(i);
            JOptionPane.showMessageDialog(null,"Task \"" + taskName + "\" successfully deleted.");
            return;
        }
    }

    System.out.println("Task not found.");
}

    
    public void displayTaskReport() {
    for (int i = 0; i < tasks.size(); i++) {
        JOptionPane.showInternalMessageDialog(null,"Task Name: " + taskNames[i]
        +"Developer: " + developers[i] 
        +"Task Duration: " + taskDuration[i]
        +"Task Status: " + taskStatus[i] );
        
    }
}


    private Task createTask(int taskNumber) {
        String taskName = JOptionPane.showInputDialog("Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Task Description (max 50 characters):");
        String developerDetails = JOptionPane.showInputDialog("Developer Details (First Last):");
        String TaskDuration = JOptionPane.showInputDialog("Task Duration (in hours):");
        String TaskStatus = JOptionPane.showInputDialog("Task Status:\n1) To Do\n2) Done\n3) Doing");

        if (taskDescription != null && taskDescription.length() <= 50) {
            return new Task(taskName, taskNumber, taskDescription, developerDetails, Integer.parseInt(TaskDuration), taskStatus);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return null;
        }
    }

    private void addTasks() {
        String input = JOptionPane.showInputDialog("How many tasks do you want to enter?");
        if (input != null && input.matches("\\d+")) {
            int taskCount = Integer.parseInt(input);
            for (int i = 0; i < taskCount; i++) {
                Task task = createTask(i);
                if (task != null) {
                    tasks.add(task);
                    String taskDetails = task.printTaskDetails();
                    JOptionPane.showMessageDialog(null, "Task Details:\n" + taskDetails);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Exiting...");
        }
    }

    private void showReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}

public static void start() {
    String username = JOptionPane.showInputDialog("Enter your username:");
    String password = JOptionPane.showInputDialog("Enter your password:");
    String firstName = JOptionPane.showInputDialog("Enter your first name:");
    String lastName = JOptionPane.showInputDialog("Enter your last name:");

    ToLogin obj = new ToLogin(username, password, firstName, lastName);
    obj.runTaskManager();
    // Populate the arrays with test data
    obj.developers[0] = "Mike Smith";
    obj.taskNames[0] = "Create Login";
    obj.taskDuration[0] = 5;
    obj.taskStatus[0] = "To Do";

    // Perform the desired operations using the arrays
    obj.displayTasksWithStatusDone();
    obj.displayTaskWithLongestDuration();
    obj.searchTaskByName("Create Login");
    obj.searchTasksByDeveloper("Mike Smith");
    obj.deleteTaskByName("Create Login");
    obj.displayTaskReport();
}


public static void main(String[] args){
    start();
    
    
}


}
    


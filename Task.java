/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nkcubekopoepart2;

/**
 *
 * @author Nckubeko
 */
class Task {
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int parseInt, String[] taskStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String taskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3);
        return taskID.toUpperCase();
    }

    public String printTaskDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Task Status: ").append(taskStatus).append("\n");
        details.append("Developer Details: ").append(developerDetails).append("\n");
        details.append("Task Number: ").append(taskNumber).append("\n");
        details.append("Task Name: ").append(taskName).append("\n");
        details.append("Task Description: ").append(taskDescription).append("\n");
        details.append("Task ID: ").append(createTaskID()).append("\n");
        details.append("Task Duration: ").append(taskDuration).append(" hours");
        return details.toString();
    }

    public int returnTotalHours() {
        int totalHours = 0;
        Iterable<Task> tasks = null;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
    
}

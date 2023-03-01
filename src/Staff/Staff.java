package Staff;

import java.util.Scanner;

public abstract class Staff {

    private String id;
    private String task;
    private Integer workingHours;

    private float salary;

    //It gives staff some additional money for the road
    private double roadToll;

    public Staff(String id, String task, Integer workingHours) {
        this.id = id;
        this.task = task;
        this.workingHours = workingHours;
    }

    //Public getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public double getRoadToll() {
        return roadToll;
    }

    public void setRoadToll(double roadToll) {
        this.roadToll = roadToll;
    }

    //Staff takes lunch break
    public void lunchBreak(String duration){
        System.out.println("Staff member with ID " + getId() + " is taking a lunch break for " + duration + " minutes.");
    }

    //Applying road toll for additional transportation money
    public double apllyRoadToll(){
        //Getting the distance that person travelled
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the distance that you travelled:");
        double distance = scanner.nextFloat();
        return distance;
    }

}

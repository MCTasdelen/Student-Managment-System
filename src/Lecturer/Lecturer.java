package Lecturer;

import Courses.Courses;
import Student.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lecturer {

    private String id;
    private String name_surname;
    //For head of the department
    private Boolean head;
    //Salary of lecturer
    private float salary;
    //Holds course codes that instructor teaches
    ArrayList<String> courses = new ArrayList<String>();

    private Integer courseCounter = 0;

    //Office hours for lecturer each lecturer has maximum 2 different hour
    String[] officeHours = new String[2];

    //Counts and points officeHours array
    private int officeHourCounter = 0;

    public Lecturer(String id, String name_surname, Boolean head) {
        this.id = id;
        this.name_surname = name_surname;
        this.head = head;
    }

    //public getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Integer getCourseCounter() {
        return courseCounter;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String[] getOfficeHours() {
        return officeHours;
    }

    //Setting office hour
    public void setOfficeHour(String hour) {
        if(officeHourCounter >= 2){ //If instructor is already have two different hours
            System.out.println("Lecturer can only have maximum two different office hours.\n");
        }
        else{

            boolean alreadyHave = false; //Checker for checking does instructor already have this hour

            //Traverse the officeHourCounter array
            for(int i=0; i < officeHourCounter; ++i){
                //If instructor has this office hour
                //assign true
                if(officeHours[i] == hour){
                   alreadyHave = true;
                }
            }

            //If alreadyHave is true
            if(alreadyHave == true){
                System.out.println("This hour have already assigned to the lecturer.\n");
            }
            else{
                officeHours[officeHourCounter] = hour; //set office hour to the officeHours array
                ++officeHourCounter; //increment officeHourCounter for checking maximum number of office hour
                System.out.println("Office hour has assigned to the lecturer.\n");
            }
        }
    }

    //Adds courses to instructors
    public void addCourse(String courseCode){
        //Checks whether this instructor has already had this course or not
        boolean hasCourse = false;
        //Iteration number
        int i=0;

        for(; i < courses.size(); ++i) {
            //If instructor has already had this course
            if(courses.get(i) == courseCode){
                hasCourse = true;// assign true
                break;
            }
            ++i;
        }

        //If instructor has already had this course
        if(hasCourse == true){
            System.out.println("Instructor has already had this course!");
        }
        else{
            courses.add(courseCode);//add course code to the courses arraylist
            courseCounter++; //Increment course counter for checking maximum number of course
            System.out.println("New course has been added to lecturer");
        }
    }

    //It removes lecturer from the course
    public void removeCourse(int index){
            courses.remove(index);
    }



    //It checks two sides for having course. If ınstructor has course and student has course, it assigns the grade.
    public void enterGrade(Courses course, Student student, int grade){

        boolean instructorHasCourse = false; //Variable for checking does instructor have the course

        try{

            //If course is contains instructors id set true
            if(course.getLecturer().id == this.id){
                instructorHasCourse = true;
            }

            //If student courses arraylist has this course and instructor has this course assign grade to the student
            if(student.getCourses().contains(course)&& instructorHasCourse == true){
                student.setGradeToStudent(course.getCourseCode(), grade);
                System.out.println("Assignment is performed successfully\n");
            }
            else{
                System.out.println("Assignment can not be performed\n");
            }
        }
        catch (Exception exception){
            System.out.println("Assignment can not be performed\n");
        }
    }

    //Giving undergraduate students a certificate
    public void giveUnderGraduateCertificate(underGraduate student){
        //If the ınstructor is the head of the department
        if(head == true){
            //If student has more than or equal to fourty course and student's hpa is more than or equal to 2.0
            if((student.getCourseCounter() >= 40) && (student.getGPA() >= 2.0)){
                student.setHasCertificate(true); //set hasCertificate true
                System.out.println(student.getName_surname() + " is qualified to receive the graduate certificate.\n");
            }
            else{
                System.out.println(student.getName_surname() + " is not qualified to receive the graduate certificate.\n");
            }
        }
        else{
            System.out.println("This lecturer can not give certificate!\n");
        }
    }

    //Giving graduate students a certificate
    public void giveGraduateCertificate(Graduate student){
        //If the ınstructor is the head of the department
        if(head == true){

            //If the student is a master student
            if(student.getDoctoral() == false){
                //If student has more than or equal to seven course and student's hpa is more than or equal to 2.5
                if((student.getCourseCounter() >= 7) && (student.getGPA() >= 2.5)){
                    student.setHasCertificate(true); //set hasCertificate true
                    System.out.println(student.getName_surname() + " is qualified to receive the graduate certificate.\n");
                }
                else{
                    System.out.println(student.getName_surname() + " is not qualified to receive the graduate certificate.\n");
                }
            }
            //If the student is a doctorate student
            else{
                //If student has more than or equal to eight course and student's hpa is more than or equal to 3.0
                if((student.getCourseCounter() >= 8) && (student.getGPA() >= 3.0)){
                    student.setHasCertificate(true);//set hasCertificate true
                    System.out.println(student.getName_surname() + " is qualified to receive the graduate certificate.\n");
                }
                else{
                    System.out.println(student.getName_surname() + " is not qualified to receive the graduate certificate.\n");
                }
            }
        }
        else{
            System.out.println("This lecturer can not give certificate!\n");
        }
    }

    //If the student GPA is sufficient and student goes to  sports then he/she qualified for scholarship
    public boolean decideScholarship(double GPA, boolean doSports){

        //If student gpa is greater pr equal to 3.5 and student is doing sports return true else return false
        if(GPA >= 3.5 && doSports == true){
            return true;
        }
        else{
            return false;
        }
    }

    //Lecturer gives assignment to course
    public void giveAssignment(String assignmentName, Courses course){
        course.takeAssignment(id, assignmentName); //call takeAssignment function
    }

    //It assigns a book to the course
    public void assignBookToCourse(Courses course, String bookName){

        if(course.getLecturer() != null){
            //If instructor is teaching the course
            if(course.getLecturer().id == this.id){
                course.setBook(bookName); //call setBook setter
                System.out.println(bookName +" book is assigned to the course.\n");
            }
            else{
                System.out.println("This instructor is not teaching this course!\n");
            }
        }
        else{
            System.out.println("This instructor is not teaching this course!\n");
        }
    }

    //Gives graduation project for undergraduate students
    public void giveGraduationProject(Project project){
        //Takes project name and project's due date
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter project name: ");
        String projectName = scanner.next();
        System.out.println("Enter due date: ");
        String dueDate = scanner.next();

        try{
            project.setProjectName(projectName); //set project name
            project.setProjectsDueDate(dueDate); // set project's due date

            System.out.println(projectName + " is set due to " + dueDate);
        }
        catch(Exception exception){
            System.out.println("Project can not be given.\n");
        }
    }
}
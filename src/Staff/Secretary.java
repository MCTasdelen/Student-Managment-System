package Staff;

import Courses.Courses;
import Lecturer.Lecturer;
import Areas.Areas;
import Student.*;

import java.util.ArrayList;

public class Secretary extends Staff {

    private String phoneNumber;//Secretary's phone number
    private String position;//Secretary's position for example faculty etc.

    public Secretary(String id, String task, Integer workingHours, String position, String phoneNumber) {
        super(id, task, workingHours);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //Assigns lecturer to the course
    public void setLecturer(Courses course, Lecturer lecturer){

        if(lecturer.getCourseCounter() >= 10){
            System.out.println("Adding new lecturer has failed due to max number of courses an instructor has\n");
        }
        else{
            lecturer.addCourse(course.getCourseCode());
            course.setLecturer(lecturer);
        }
    }

    //Removes lecturer from the course
    public void removeLecturer(Courses course, Lecturer lecturer){
        ArrayList<String> courses1 = lecturer.getCourses();

        //Checks whether this instructor has this course or not
        boolean hasCourse = false;
        //Iteration number
        int i=0;

        //Traverse all the array for finding the course
        for(; i < courses1.size(); ++i) {
            if(courses1.get(i) == course.getCourseCode()){
                hasCourse = true;
                break;
            }
            ++i;
        }

        //If lecturer has the course and course counter is greater than zero
        if(course.getLecturerCounter() >0 && hasCourse == true){
            course.deleteLecturer(); //remove lecturer from course
            lecturer.removeCourse(i); //remove course from lecturer

            System.out.println("Lecturer has been removed successfully.\n");
        }
        else{
            System.out.println("There is no instructor assigned this course.\n");
        }
    }

    //It assings students to the sportshall
    public void setStudentToSportshall(Areas areas, Student student){
        //If student is not registered any sports, enroll the student.
        if(!areas.getSportshall().contains(student.getId()) && !student.isDoSports()){
            areas.setSportshall(student.getId());
            student.setDoSports(true);
            System.out.println("Student has successfully added to the course.\n");
        }
        else{
            System.out.println("Registration has failed.\n");
        }
    }

    // Schedule a meeting
    public void scheduleMeetingWithLecturer(String[] officeHours, String name, String desiredTime) {

        boolean available = false; //variable for checking whether instructor is available or not

        int i=0;

        for(; i< officeHours.length; ++i){
            //If the desired time is appropriate for lecturer's office hours
            if(officeHours[i].equals(desiredTime)){
                available = true; //set available true
                break;
            }
        }

        //If instructor is available
        if(available == true){
            System.out.println("The secretary scheduled a meeting at " + officeHours[i] + ", with " + name);
        }
        else{
            System.out.println(desiredTime + " is not appropriate for " + name);
        }
    }

    // Mail sending function.
    public void sendEmail(String recipient, String subject, String message) {
        System.out.println("The secretary sends an e-mail to " + recipient);
        System.out.println("Email subject: " + subject);
        System.out.println("Email message: " + message);
    }
}

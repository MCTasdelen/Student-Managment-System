package Student;

import Courses.Courses;
import Lecturer.Lecturer;
import Student.Student;

public class underGraduate extends Student {

    //Project for undergraduate student
    Project project;

    //A student can only take one project. This condition will be checked by projectCounter.
    int projectCounter = 0;

    //5 args constructor
    public underGraduate(String id, String name_surname, Integer year, Integer credit_Card_Balance, String credit_Card_Number) {
        super(id, name_surname, year, credit_Card_Balance, credit_Card_Number);
    }

    //Overrides the enrollToCourse function in student to check whether this course is graduate course or not.
    //If it is appropriate then calls the super clas's enrollToCourse function to enroll
    public void enrollToCourse(Courses course){
        if(course.isGraduate() == false){
            super.enrollToCourse(course);
        }
        else{
            System.out.println("This course is not appropriate for undergraduate students!");
        }
    }

    //Student taking graduation project
    public void takeGraduationProject(Lecturer lecturer){

        //Each student can only have one project
        if(projectCounter == 1){
            System.out.println("Student can only have one project.");
        }
        else{
            project = new Project(); //Create new project object
            lecturer.giveGraduationProject(project); //call lecturer's giveGraduationProject function
            ++projectCounter;//Increment project counter for later checks
        }
    }
}
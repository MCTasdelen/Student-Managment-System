package Student;

import Courses.Courses;
import Student.Student;

public class Graduate extends Student {

    //If its true then it means that this student is doctoral if its false this means that this student is master
    private Boolean doctoral;

    //6 args constructor
    public Graduate(String id, String name_surname, Integer year, Integer credit_Card_Balance, String credit_Card_Number, Boolean doctoral) {
        super(id, name_surname, year, credit_Card_Balance, credit_Card_Number);
        this.doctoral = doctoral;
    }

    //Overrides the enrollToCourse function in student to check whether this course is graduate course or not.
    //If it is appropriate then calls the super clas's enrollToCourse function to enroll
    public void enrollToCourse(Courses course){
        if(course.isGraduate() == true){
            super.enrollToCourse(course);
        }
        else{
            System.out.println("This course is not appropriate for graduate students!");
        }
    }

    //public getter
    public Boolean getDoctoral() {
        return doctoral;
    }
}

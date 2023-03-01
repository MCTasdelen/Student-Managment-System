import Areas.Areas;
import Courses.Courses;
import Lecturer.Lecturer;
import Staff.Accountant;
import Staff.Cleaning;
import Staff.Secretary;
import Staff.Technical;
import Student.Graduate;
import Student.underGraduate;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Instantiating new area object
        Areas areas = new Areas();

        //Setting area
        areas.setSocial("Dining hall");

        //Instantiating staffs
        Accountant accountant = new Accountant("4", "account", 7);
        Technical technical = new Technical("1", "repair", 5, "engineer", "certificate");
        Cleaning cleaning = new Cleaning("2", "clean", 5, "4", "morning");
        Secretary secretary = new Secretary("3","secretary", 5, "faculty", "5053323352");

        //set classroom to the classrooms arraylist
        areas.setClassrooms("classroom1");
        areas.setClassrooms("classroom2");
        areas.setClassrooms("classroom3");

        //Instantiating lecturer objects
        Lecturer lecturer1 = new Lecturer("1", "John Travolta", false);
        Lecturer lecturer2 = new Lecturer("2", "Frank Sinatra", true);

        //Instantiating course objects
        Courses course1 = new Courses("CENG1", "Discrete Math", 3, true);
        Courses course2 = new Courses("CENG2", "Data Structures", 6, true, "CENG1");
        Courses course3 = new Courses("CENG3", "Linear algebra", 3, false);
        Courses course4 = new Courses("CENG4", "Programming 1", 3, false);
        Courses course5 = new Courses("CENG5", "Programming 2", 3, false);
        Courses course6 = new Courses("CENG6", "Java programming", 3, false);
        Courses course7 = new Courses("CENG7", "Database", 3, false);
        Courses course8 = new Courses("CENG8", "OOP", 3, false);
        Courses course9 = new Courses("CENG9", "Embedded Systems", 3, false);
        Courses course10 = new Courses("CENG10", "Microservices", 3, false);
        Courses course11 = new Courses("CENG11", "API", 3, false);

        //Instantiating student objects
        Graduate student1 = new Graduate("1", "Elvis Presley", 4, 400, "3333", false);
        underGraduate student2 = new underGraduate("1", "Peggy Lee", 5, 300, "5677");

        //Setting lecturer1 to the course1 and course2
        secretary.setLecturer(course1, lecturer1);
        secretary.setLecturer(course1, lecturer1);
        secretary.setLecturer(course2, lecturer1);

        //student1 enrolls course1 and course2
        student1.enrollToCourse(course1);
        student1.enrollToCourse(course2);
        //For checking exception student try to enroll to the same course
        student1.enrollToCourse(course2);

        //Setting lecturer2 to the course3
        secretary.setLecturer(course3, lecturer2);

        //student1 enrolls course3 and course4
        student2.enrollToCourse(course3);
        student2.enrollToCourse(course4);
        //For checking exception undergraduate student tries to enroll graduate course
        student2.enrollToCourse(course2);

        //Setting grade to the student1
        lecturer1.enterGrade(course1, student1,100);
        lecturer1.enterGrade(course2, student1,100);

        //Setting grade to the student2
        lecturer2.enterGrade(course3, student1, 50);
        lecturer2.enterGrade(course3, student2, 50);
        System.out.println("gpa:"+student1.getGPA());
        System.out.println("gpa:"+student2.getGPA());

        //Removing lecturer from the course
        secretary.removeLecturer(course1, lecturer1);
        //For testing if it gives true response when system tries to remove lecturer from the course that lecturer is not take
        secretary.removeLecturer(course4, lecturer1);

        //Giving graduate certificate
        lecturer1.giveGraduateCertificate(student1);
        lecturer2.giveGraduateCertificate(student1);
        lecturer2.giveUnderGraduateCertificate(student2);

        //Assigning classrooms to the course
        course1.assignClassroom(areas.getClassrooms(), "classroom1");
        course1.assignClassroom(areas.getClassrooms(), "classroom4");

        //Calling weekly maintenance function
        technical.weeklyMaintenance();

        //Calculating staff salary
        accountant.calculateStaffSalary(cleaning);
        accountant.calculateStaffSalary(technical);
        accountant.calculateStaffSalary(secretary);
        System.out.println(cleaning.getSalary() + "\n");
        System.out.println(technical.getSalary() + "\n");
        System.out.println(secretary.getSalary() + "\n");

        //Calculating lecturer salary
        accountant.calculateLecturerSalary(lecturer1);
        System.out.println(lecturer1.getSalary() + "\n");

        //Enrolling student to the sportshall
        secretary.setStudentToSportshall(areas, student1);
        secretary.setStudentToSportshall(areas, student1);

        //Applying scholarship
        student1.applyScholarship(lecturer1);
        student1.applyScholarship(lecturer2);
        student2.applyScholarship(lecturer2);

        //Checking card number for loading money from atm
        student2.cardCheck(areas);

        //Setting lecturer office hour
        lecturer1.setOfficeHour("14.00");
        lecturer1.setOfficeHour("15.00");

        //Scheduling meeting with lecturer
        secretary.scheduleMeetingWithLecturer(lecturer1.getOfficeHours(), lecturer1.getName_surname(), "14.00");

        //Student is going to dine
        areas.goingDiningHall(student2);

        //Taking graduation project
        student2.takeGraduationProject(lecturer1);
        student2.takeGraduationProject(lecturer1);

        //Assigning book to the course
        lecturer1.assignBookToCourse(course1, "Math");

        //Gives the courses book to the library
        areas.takeBookFromCouse(course1);
        areas.takeBookFromCouse(course2);

        //Student borrowing book from library
        student1.borrowBook(areas, "Math");
        student1.borrowBook(areas, "English");

        //Controlling tuition for students
        accountant.controlTuition(student1);
        accountant.controlTuition(student2);

        //Giving assignment information in to the course
        lecturer1.giveAssignment("Code", course1);
        lecturer1.giveAssignment("Code", course3);

        //Evaluating road toll for the staff
        accountant.evaluateRoadToll(secretary);
    }
}
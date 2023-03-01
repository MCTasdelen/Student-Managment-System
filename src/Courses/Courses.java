package Courses;

import Areas.Library;
import Lecturer.Lecturer;

import java.util.ArrayList;

public class Courses {

    private String courseCode;
    private String name;
    private Integer credit;
    private String courseLocation;
    //For checking whether this course is graduate or undergraduate
    private boolean graduate;
    private Lecturer lecturer;
    //Each course has one instructor to check this we use lecturerCounter
    private int lecturerCounter = 0;
    private ArrayList<String> studentId = new ArrayList<String>();

    //Book of the course
    private String book;

    //It holds course code if this course is prerequisite
    private String prerequisiteCourseCode;

    //Assignment for course
    private String assignment;


    public Courses(String courseCode, String name, Integer credit, boolean graduate) {
        this.courseCode = courseCode;
        this.name = name;
        this.credit = credit;
        this.graduate = graduate;
    }

    public Courses(String courseCode, String name, Integer credit, boolean graduate, String prerequisiteCourseCode) {
        this.courseCode = courseCode;
        this.name = name;
        this.credit = credit;
        this.graduate = graduate;
        this.prerequisiteCourseCode = prerequisiteCourseCode;
    }

    //public getters and setters
    public ArrayList<String> getStudentId() {
        return studentId;
    }

    public void setStudentId(String id){
        studentId.add(id);
    }

    public boolean isGraduate() {
        return graduate;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLecturerCounter() {
        return lecturerCounter;
    }

    public void setLecturerCounter(int lecturerCounter) {
        this.lecturerCounter = lecturerCounter;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public String getPrerequisiteCourseCode() {
        return prerequisiteCourseCode;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setPrerequisiteCourseCode(String prerequisiteCourseCode) {
        //If there is no course assigned as prerequisite course then assign
        if(prerequisiteCourseCode == null){
            this.prerequisiteCourseCode = prerequisiteCourseCode;
        }
        else{
            System.out.println("Only one course code can be assigned!");
        }
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    //sets lecturer to the course
    public void setLecturer(Lecturer lecturer) {
        //If there is no lecturer assigned to the course
        if(lecturerCounter<1){
            this.lecturer = lecturer;
            ++lecturerCounter;
            System.out.println("New lecturer has been added to course\n");
        }
        else{
            System.out.println("Each course has one instructor! New instructor can not be added.\n");
        }
    }

    //removes lecturer from the course
    public void deleteLecturer(){
        this.lecturer = null;
    }

    //It takes list of clasrooms from the area class and classroomName parameter then checks whether the classroom exists or not.
    public void assignClassroom(ArrayList<String> classrooms, String classroomName){
        boolean classroomExist = false; //Variable for checking if there is any classroom named classroomName in the institution

        //Traverse the classrooms array list
        for(int i=0; i < classrooms.size(); ++i){
            //If classroom is in the institution
            if(classroomName == classrooms.get(i)){
                classroomExist = true; // set true
                break;
            }
        }

        //If there is a classroom in the institution assign classroom to the course
        if(classroomExist){
            setCourseLocation(classroomName); //set classroomName to the course location
            System.out.println(classroomName + "has been assigned successfully.");
        }
        else{
            System.out.println("Institution does not have classroom called: " + classroomName);
        }
    }

    //It gives book to the library
    public void giveBook(Library library){
        //If no book assigned to course
        if(getBook() == null){
            System.out.println("No book assigned to this course");
        }
        else{
            library.setBookName(getBook());
        }
    }

    //Assigns the assignment
    public void takeAssignment(String lecturerId, String assignmentName){

        //If instructor assigned to this course
        if(lecturer != null){
            //If the instructor that wants to give assignment is teaching this course
            if(lecturer.getId().equals(lecturerId)){
                assignment = assignmentName; //assign the assignment name
                System.out.println(assignmentName + " has assigned to the course");
            }
            else{
                System.out.println("Instructor is not teaching this course");
            }
        }
        else{
            System.out.println("There is no instructor assigned to this course.");
        }
    }
}

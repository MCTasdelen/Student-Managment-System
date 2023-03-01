package Student;

import Areas.Areas;
import Courses.Courses;
import Lecturer.Lecturer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Student {
    private final String id;
    private final String name_surname;
    private final Integer year;

    private boolean scholarship = false;
    private boolean doSports = false;

    private Integer credit_Card_Balance;
    private String credit_Card_Number;

    //Holds courses information
    private ArrayList<Courses> courses = new ArrayList<Courses>();

    //To check how many courses does a student have to give certificate
    private Integer courseCounter = 0;

    //Holds grades for each lesson
    private HashMap<String, Integer> grades = new HashMap<String, Integer>();
    private double GPA;

    //Graduate certificate
    private boolean hasCertificate = false;

    private String borrowedBook;

    public Student(String id, String name_surname, Integer year, Integer credit_Card_Balance, String credit_Card_Number) {
        this.id = id;
        this.name_surname = name_surname;
        this.year = year;
        this.credit_Card_Balance = credit_Card_Balance;
        this.credit_Card_Number = credit_Card_Number;
    }

    //Enrolls the student into a course
    public void enrollToCourse(Courses course){

        //If student has already enrolled to the course
        if(courses.contains(course)){
            System.out.println("Student has already enrolled to this course");
        }
        else{

            //If there is no prerequisite course for the course which system want to assign
            if(course.getPrerequisiteCourseCode() == null){
                courses.add(course); //add course to the courses arraylist
                course.setStudentId(id); //sets student id to the relevant course
                ++courseCounter; //increment course number for later checking graduate certificate
                System.out.println("Student has added to the course");
            }
            else{
                //For checking student has prerequisite course or not
                boolean hasPrerequisiteCourse = false;

                //Searching the prerequisite course code
                for(int i=0; i < courses.size(); ++i){
                    //If student has the prerequisite course
                    //assign true to hasPrerequisiteCourse and terminate loop
                    if(courses.get(i).getCourseCode() == course.getPrerequisiteCourseCode()){
                        hasPrerequisiteCourse = true;
                        break;
                    }
                }

                //If student has the prerequisite course
                if(hasPrerequisiteCourse){
                    courses.add(course);//add course to the courses arraylist
                    course.setStudentId(id);//sets student id to the relevant course
                    ++courseCounter;//increment course number for later checking graduate certificate
                    System.out.println("Student has added to the course");
                }
                else{
                    System.out.println("This course has prerequiste from " + course.getPrerequisiteCourseCode() + " first take the course.");
                }
            }
        }
    }

    //Calculates the gpa for the student
    public void calculateGPA(){
        double result = 0; //Holds result
        int totalCredit = 0; // Holds total credit of the courses

        //Traverse the courses arraylist
        for(int i=0; i< courses.size(); ++i){
            //If course has grade in the grades hashmap
            if(grades.containsKey(courses.get(i).getCourseCode())){
                result += courses.get(i).getCredit() * grades.get(courses.get(i).getCourseCode()); // multiply credit and grade then assign to the result
                totalCredit += courses.get(i).getCredit();// add credit to total credit
            }
        }

        //If there is no grade assigned
        if(result == 0){
            System.out.println("Student who takes courses does not have a grade\n");
            this.GPA = 0.0;
        }
        else{
            result = (result/totalCredit) * 0.04;
            this.GPA = result;
        }
    }

    //Applying for scholarship only head of the department can decide for that
    public void applyScholarship(Lecturer lecturer){

        if(lecturer.getHead() == true){
            boolean evaluation = lecturer.decideScholarship(getGPA(), isDoSports());//calls lecturer decidescholarship function

            //If the response is true
            if(evaluation == true){
                setScholarship(true);
                System.out.println(getName_surname() + " is qualified for scholarship");
            }
            else{
                System.out.println(getName_surname() + " is not qualified for scholarship");
            }
        }
        else{
            System.out.println("Only the head of the department can decide scholarship. Please reach to the head of the department.");
        }
    }

    //Checks the credit card number
    public void cardCheck(Areas areas)
    {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Please enter your card number: ");
        String cardNumberString=scanner.next();
        if(getCredit_Card_Number().equals(cardNumberString)) //If credit card number is matched with the number which saved in the system
        {
            setCredit_Card_Balance(areas.ATM(getCredit_Card_Balance()));//set credit card balance
            System.out.println("Your new balance is: " + getCredit_Card_Balance());

        }
        else {
            System.out.println("Incorrect entry!");
        }
    }

    //Student borrows book from the library
    public void borrowBook(Areas areas, String bookName){
        if(areas.lendBook(bookName) == true){ // If the response from len book is true
            setBorrowedBook(bookName); //Set borrowed book name
            System.out.println("Student has borrowed the book");
        }
        else{
            System.out.println("Book is not found in the library");
        }
    }

    //Function is used for pay money in dining hall
    public void payFoodPrice(){
        setCredit_Card_Balance(getCredit_Card_Balance() - 4);
    }

    //Function is used for pay tuition
    public void payTuition(){
        setCredit_Card_Balance(getCredit_Card_Balance() - 100);
    }

    //Sets grades with course code and grade <String,Integer> -> <courseCode, grade>
    public void setGradeToStudent(String courseCode, int grade){
        grades.put(courseCode, grade);
    }

    //public getters for fundamental information
    public String getId() {
        return id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getCourseCounter() {
        return courseCounter;
    }

    //public getters and setters

    public Double getGPA() {
        calculateGPA();
        return GPA;
    }

    public boolean isHasCertificate() {
        return hasCertificate;
    }

    public void setHasCertificate(boolean hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public boolean isDoSports() {
        return doSports;
    }

    public void setDoSports(boolean doSports) {
        this.doSports = doSports;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public Integer getCredit_Card_Balance() {
        return credit_Card_Balance;
    }

    public void setCredit_Card_Balance(Integer credit_Card_Balance) {
        this.credit_Card_Balance = credit_Card_Balance;
    }

    public String getCredit_Card_Number() {
        return credit_Card_Number;
    }

    public void setCredit_Card_Number(String credit_Card_Number) {
        this.credit_Card_Number = credit_Card_Number;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }
}

package Areas;

import Courses.Courses;
import Student.Student;
import Staff.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class Areas {

    //Keeps lecturerOffice names
    private ArrayList<String> lecturerOffice;
    //Keeps assistantstaffOffice names
    private ArrayList<String> assistantstaffOffice;
    //Keeps classroom names
    private ArrayList<String> classrooms;
    //Keeps social places like garden
    private ArrayList<String> social;

    //Sportshall is just a one building and with this arraylist it holds student id's who goes to sport.
    private ArrayList<String> sportshall = new ArrayList<String>();

    private Library library;


    public Areas() {
        lecturerOffice = new ArrayList<String>();
        assistantstaffOffice = new ArrayList<String>();
        classrooms = new ArrayList<String>();
        social = new ArrayList<String>();
        library = new Library();
    }

    public Areas(ArrayList<String> lecturerOffice, ArrayList<String> assistantstaffOffice, ArrayList<String> classrooms, ArrayList<String> social) {
        this.lecturerOffice = lecturerOffice;
        this.assistantstaffOffice = assistantstaffOffice;
        this.classrooms = classrooms;
        this.social = social;
    }

    //Place to load money
    public int ATM(int balance)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the money: ");
        balance+= scanner.nextInt(); //Add the input to the balance
        return balance;
    }

    //Lends a book to the student which is in the library
    public boolean lendBook(String bookName){
        //If the book is in the library
        if(library.getBookName().contains(bookName)){
            return true;
        }
        else{
            return false;
        }
    }

    //Student is going dining hall
    public void goingDiningHall(Student student){
        if(student.getCredit_Card_Balance() < 4){
            System.out.println("Insufficient balance!\n");
        }
        else{
            student.payFoodPrice();
            System.out.println("Transaction is successful.\n");
        }
    }

    //Staff is going dining hall for lunch break
    public void staffIsGoingDiningHall(Staff staff, String duration){
        staff.lunchBreak(duration);
    }

    //public getters and setters

    //It takes book from the course
    public void takeBookFromCouse(Courses coures){
        coures.giveBook(library);
    }

    public ArrayList<String> getLecturerOffice() {
        return lecturerOffice;
    }

    public void setLecturerOffice(String lecturerOfficeName) {
        lecturerOffice.add(lecturerOfficeName);
    }

    public ArrayList<String> getAssistantstaffOffice() {
        return assistantstaffOffice;
    }

    public void setAssistantstaffOffice(String assistantstaffOfficeName) {
        assistantstaffOffice.add(assistantstaffOfficeName);
    }

    public ArrayList<String> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(String classroomName) {
        classrooms.add(classroomName);
    }

    public ArrayList<String> getSocial() {
        return social;
    }

    public void setSocial(String socialPlace) {
        social.add(socialPlace);
    }

    //Gets student's id's
    public ArrayList<String> getSportshall() {
        return sportshall;
    }

    //Adds student's id to the sportshall
    public void setSportshall(String studentId) {
        sportshall.add(studentId);
    }

    public Library getLibrary() {
        return library;
    }
}

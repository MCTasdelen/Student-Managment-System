package Areas;

import java.util.ArrayList;

public final class Library {

    //It holds students who enrolled to the library
    ArrayList<String> studentsId = new ArrayList<String>();
    //It holds the books which lecturer assigned to course
    ArrayList<String> bookName = new ArrayList<String>();

    public Library() {
    }

    public ArrayList<String> getStudenstId() {
        return studentsId;
    }

    public void setStudenstId(String studentId) {
        //If student has already enrolled
        if(studentsId.contains(studentId)){
            System.out.println("Student has already enrolled.");
        }
        else{
            studentsId.add(studentId);
            System.out.println("Student has added to the library.");
        }
    }

    public ArrayList<String> getBookName() {
        return bookName;
    }

    public void setBookName(String book) {
        //If student has already enrolled
        if(bookName.contains(book)){
            System.out.println("This book has already given to the library.");
        }
        else{
            bookName.add(book);
            System.out.println("Book has added to the library.");
        }
    }
}

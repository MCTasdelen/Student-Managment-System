package Staff;
import Lecturer.*;
import Student.Student;

//Extra class
public class Accountant extends Staff{
    private final float  hourlyWageCleaning=15;
    private final float  hourlyWageSecretary= (float) 18.5;
    private final float  hourlyWageTechnical= (float) 21.5;
    private final float  wagePerLesson= (float) 28.5;

    public Accountant(String id, String task, Integer workingHours) {
        super(id, task, workingHours);
    }

    //Calculates lecturer salary
    public void  calculateLecturerSalary(Lecturer lecturer)
    {
        //Lecturers base salary is 8000, and additionally it adds wage per lesson if instructor is teaching
        lecturer.setSalary(8000+(lecturer.getCourseCounter()*getWagePerLesson()));

    }

    //Calculates staff salary
    public void calculateStaffSalary(Staff staff)
    {
        //If staff is an instance of cleaning
        if(staff instanceof Cleaning)
        {
            staff.setSalary((getHourlyWageCleaning()*staff.getWorkingHours())); //set staff salary by their hourly wage times working hours

        }
        //If staff is an instance of secretary
        else if(staff instanceof Secretary)
        {
            staff.setSalary((getHourlyWageSecretary()*staff.getWorkingHours())); //set staff salary by their hourly wage times working hours
        }
        //If staff is an instance of technical
        else if(staff instanceof Technical)
        {
            staff.setSalary((getHourlyWageTechnical()*staff.getWorkingHours())); //set staff salary by their hourly wage times working hours
        }
        else {
            {
                System.out.println("Appropriate department not entered");
            }
        }

    }

    //Checks whether student has to pay tuition or not.
    public void controlTuition(Student student){
        //If student stays in college after four years
        if(student.getYear() > 4){
            //If students credit card balance is less than 100
            if(student.getCredit_Card_Balance() < 100){
                System.out.println("Not enough money to pay tuition");
            }
            else{
                student.payTuition();
                System.out.println("Student has payed the tuition");
            }
        }
        else{
            System.out.println("Student don't have to pay tuition");
        }
    }

    //Evaluates road toll money
    public void evaluateRoadToll(Staff staff){
        double distance = staff.apllyRoadToll(); //call applyRoadToll and assign the response to the distance variable
        try{

            double roadToll = distance * 10.7; //10.7 is price per kilometer

            staff.setRoadToll(roadToll); //setting road toll
            System.out.println(roadToll + " is given.");
        }
        catch (Exception exception){
            System.out.println("An error occurred!");
        }

    }

    //public getters
    public float getWagePerLesson() {
        return wagePerLesson;
    }
    public float getHourlyWageCleaning() {
        return hourlyWageCleaning;
    }

    public float getHourlyWageSecretary() {
        return hourlyWageSecretary;
    }

    public float getHourlyWageTechnical() {
        return hourlyWageTechnical;
    }
}

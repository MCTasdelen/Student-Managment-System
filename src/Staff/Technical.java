package Staff;

import java.util.Calendar;

public class Technical extends Staff{

    private String profession, certificate;

    // Constructor of Technical class
    public Technical(String id, String task, int workingHours, String profession, String certificate) {
        super(id, task, workingHours);
        this.profession = profession;
        this.certificate = certificate;
    }

    // Technical class getter and setter methods
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    // Function that controls maintenance
    public void weeklyMaintenance() {
        Calendar calendar = Calendar.getInstance(); //getting instance of a calendar
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //get day of week
        if (dayOfWeek == Calendar.MONDAY) {
            System.out.println("All the responsible devices were maintained and checked.");
        }
        else if (dayOfWeek == Calendar.TUESDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 1 day ago.");

        }
        else if (dayOfWeek == Calendar.WEDNESDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 2 days ago.");

        }
        else if (dayOfWeek == Calendar.THURSDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 3 days ago.");

        }
        else if (dayOfWeek == Calendar.FRIDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 4 days ago.");

        }
        else if (dayOfWeek == Calendar.SATURDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 5 days ago.");

        }
        else if (dayOfWeek == Calendar.SUNDAY) {
            System.out.println("Maintenance and control of all responsible devices was done 6 days ago.");
        }
    }

    public void performMaintenanceTask(String taskDescription, int workingHours) {
        // Defining new duties and working hours to the technical staff
        setTask(taskDescription);
        setWorkingHours(workingHours);

        System.out.println("The technical staff performs task " + taskDescription);
        System.out.println("The technical staff worked for " + workingHours + " hours for this task.");
    }
}

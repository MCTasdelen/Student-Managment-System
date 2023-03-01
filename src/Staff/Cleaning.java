package Staff;

public class Cleaning extends Staff{

    private String floorInCharge; // Floor where the cleaning staff is responsible.
    private String shift; // The time which cleaning staff is working

    // Constructor of Cleaning class.
    public Cleaning(String id, String task, int workingHours, String floorInCharge,
                    String shift) {
        super(id, task, workingHours);
        this.floorInCharge = floorInCharge;
        this.shift = shift;

    }

    // Cleaning class getter and setter methods.
    public String getFloorInCharge() {
        return floorInCharge;
    }

    public void setFloorInCharge(String floorInCharge) {
        this.floorInCharge = floorInCharge;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    // assignment function by shift
    public void assignTask() {
        if (shift == "morning") {
            System.out.println("Today's task is to clean the corridor and the stairs.");
        } else if (shift == "afternoon") {
            System.out.println("Today's task is to clean the toilets");
        }
    }

    // cleaning the desired place function
    public void cleanArea(String area) {
        System.out.println("The cleaning staff cleaned the " + area);
    }
}

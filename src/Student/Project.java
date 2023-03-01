package Student;

//Creating this class for creating a structure for project
public class Project {
    private String projectName; //Project's name
    private String projectsDueDate; //Project's due date

    public Project() {
    }

    //public getters and setters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectsDueDate() {
        return projectsDueDate;
    }

    public void setProjectsDueDate(String projectsDueDate) {
        this.projectsDueDate = projectsDueDate;
    }
}

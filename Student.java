import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String Gender;
    private String Grade;
    private String ExtraCurric;

    public Student(String id, String firstName, String lastName, String dateOfBirth, String Gender, String Grade, String ExtraCurric) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.Gender = Gender;
        this.Grade = Grade;
        this.ExtraCurric = ExtraCurric;
    }

    public String getID() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getGender() { return Gender; }
    public String getGrade() { return Grade; }
    public String getExtraCurric() { return ExtraCurric; }

    public void setID(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setGender(String Gender) { this.Gender = Gender; }
    public void setGrade(String Grade) { this.Grade = Grade; }
    public void setExtraCurric(String ExtraCurric) { this.ExtraCurric = ExtraCurric; }

    public String toString() {
        return id + "," + firstName + "," + lastName + "," + dateOfBirth + "," + Gender + "," + Grade + "," + ExtraCurric;
    }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 7) return null;
        return new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}

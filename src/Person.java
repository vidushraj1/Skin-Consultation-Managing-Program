import java.io.Serializable;

public class Person implements Serializable {
    // Variables for the driver class

    protected String Firstname;
    protected String Surname;
    protected String dateOfBirth;
    protected int mobileNumber;

// Getters and Setters for the person name, person surname, person date of birth , person mobile number.


    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMobileNumber() {return mobileNumber;}

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Person(String firstname, String surname, String dateOfBirth, int mobileNumber) {
        this.Firstname = firstname;
        this.Surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }
}
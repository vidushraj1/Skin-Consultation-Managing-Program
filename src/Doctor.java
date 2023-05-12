import java.io.Serializable;
import java.util.Comparator;

public class Doctor extends Person implements Serializable,Comparator<Doctor>{
    private int medicalLicenceNumber;
    private String specialisation;

    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "medicalLicenceNumber='" + medicalLicenceNumber + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Surname='" + Surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", mobileNumber=" + mobileNumber +
                "}\n";
    }

    public Doctor(String firstname, String surname, String dateOfBirth, int mobileNumber, int medicalLicenceNumber, String specialisation) {
        super(firstname, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public int compare(Doctor doctora, Doctor doctorb) {
        return doctora.getSurname().compareTo(doctorb.getSurname());
    }
}


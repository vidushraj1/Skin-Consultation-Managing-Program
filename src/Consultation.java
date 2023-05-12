import java.io.Serializable;

public class Consultation implements Serializable {
    String date;
    float cost;
    String note;

    int doctorLicenceNum;
    int patientID;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDoctorLicenceNum() {
        return doctorLicenceNum;
    }

    public void setDoctorLicenceNum(int doctorLicenceNum) {
        this.doctorLicenceNum = doctorLicenceNum;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Consultation(String date, float cost, String note, int doctorLicenceNum, int patientID) {
        this.date = date;
        this.cost = cost;
        this.note = note;
        this.doctorLicenceNum = doctorLicenceNum;
        this.patientID = patientID;
    }
}

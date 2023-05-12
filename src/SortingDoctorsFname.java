import java.util.Comparator;

public class SortingDoctorsFname implements Comparator<Doctor> {
    @Override
    public int compare(Doctor doctorFirst, Doctor doctorSecond) {
        return doctorFirst.getFirstname().compareTo(doctorSecond.getFirstname());
    }
}

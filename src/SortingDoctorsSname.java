import java.util.Comparator;
public class SortingDoctorsSname implements Comparator<Doctor> {

    @Override
    public int compare(Doctor doctorFirst, Doctor doctorSecond) {
        return doctorFirst.getSurname().compareTo(doctorSecond.getSurname());
    }
}

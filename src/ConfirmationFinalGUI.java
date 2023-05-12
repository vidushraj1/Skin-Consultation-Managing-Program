import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfirmationFinalGUI {
    private static String patientFistName;
    private static String patientSurName;
    private static String patientDateofBirth;
    private static long patientMobileNumber;
    private static int patientId;
    private static String patientPassword;
    private static int consultationHour;
    private static String consultationDate;
    private static String consultationNote;
    private static int consultationCost;
    private static int doctorMedicalLicenceNumber;
    private static String doctorFullName;

    public static ArrayList<Doctor> doctorList;
    String message;

    public static void doctorObjectTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    public static void patientObjectTransfer(String patientfirstname, String patientsurname, String patientdob, long patientmobilenumber, int patientid, String patientpassword) {
        patientFistName = patientfirstname;
        ConfirmationFinalGUI.patientSurName = patientsurname;
        patientDateofBirth = patientdob;
        patientMobileNumber = patientmobilenumber;
        ConfirmationFinalGUI.patientId = patientid;
        patientPassword = patientpassword;
    }

    public static void consultationObjectTransfer(int consultationhour, String consultationdate, String consultationnote) {
        ConfirmationFinalGUI.consultationHour = consultationhour;
        ConfirmationFinalGUI.consultationDate = consultationdate;
        ConfirmationFinalGUI.consultationNote = consultationnote;
    }

    public static void doctorTransfer(int doctormedicallicensenumber, String doctorfullname) {
        doctorMedicalLicenceNumber = doctormedicallicensenumber;
        ConfirmationFinalGUI.doctorFullName = doctorfullname;
    }

    ConfirmationFinalGUI() {
        Patient patient = new Patient(patientFistName, patientSurName, patientDateofBirth, (int) patientMobileNumber, patientId, patientPassword);
        WestminsterSkinConsultationManager.PatientListAdd(patient);
        for (Patient value : WestminsterSkinConsultationManager.patients) {
            if (value.getPatientId() == patientId) {
                consultationCost = 25 * consultationHour;
            } else {
                consultationCost = 15 + (consultationHour - 1) * 25;
            }
        }

        boolean available = checkDoctorAvailability(doctorMedicalLicenceNumber, consultationDate);

        if (available) {
            message = "your Consultation is placed";
            Consultation consultation = new Consultation(consultationDate, consultationCost, consultationNote, doctorMedicalLicenceNumber, patientId);
            WestminsterSkinConsultationManager.ConsultationListAdd(consultation);
        } else {
            message = "The doctor chosen is already booked on that day.\n hence new doctor will be chosen automatically";
            int randomMedLicNo;
            String randomDoctorFullName;
            do {
                int randomIndex = (int) (Math.random() * doctorList.size());
                Doctor randomDoctor = doctorList.get(randomIndex);
                randomDoctorFullName = randomDoctor.getFirstname()+" "+randomDoctor.getSurname();
                randomMedLicNo = randomDoctor.getMedicalLicenceNumber();
                available = checkDoctorAvailability(randomMedLicNo, consultationDate);
            } while (!available);

            doctorMedicalLicenceNumber = randomMedLicNo;
            doctorFullName = randomDoctorFullName;

            Consultation consultation = new Consultation(consultationDate, consultationCost, consultationNote, doctorMedicalLicenceNumber, patientId);
            WestminsterSkinConsultationManager.ConsultationListAdd(consultation);
        }



        JPanel EditPanel = new JPanel(new GridBagLayout());
        EditPanel.setBackground(Color.WHITE);

        GridBagConstraints EditComponents = new GridBagConstraints();
        EditComponents.insets = new Insets(5, 5, 5, 5);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        JLabel messageL = new JLabel(message);
        messageL.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 0;
        messageL.setSize(300,100);
        EditPanel.add(messageL,EditComponents);

        JLabel doctorfullname1 = new JLabel("Doctor full Name");
        doctorfullname1.setForeground(Color.BLUE);
        EditComponents.gridx = 0;
        EditComponents.gridy = 1;
        EditPanel.add(doctorfullname1,EditComponents);

        JLabel doctorfullname2 = new JLabel(doctorFullName);
        doctorfullname2.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        EditPanel.add(doctorfullname2,EditComponents);

        JLabel patientfullname1 = new JLabel("Patient full Name");
        patientfullname1.setForeground(Color.BLUE);
        EditComponents.gridx = 0;
        EditComponents.gridy = 2;
        EditPanel.add(patientfullname1,EditComponents);

        JLabel patientfullname2 = new JLabel(patientFistName +" "+ patientSurName);
        patientfullname2.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 2;
        EditPanel.add(patientfullname2,EditComponents);

        JLabel price1 = new JLabel("Consultation Fee");
        price1.setForeground(Color.BLUE);
        EditComponents.gridx = 0;
        EditComponents.gridy = 3;
        EditPanel.add(price1,EditComponents);

        JLabel price2 = new JLabel(String.valueOf(consultationCost));
        price2.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 3;
        EditPanel.add(price2,EditComponents);

        JButton btnForHome = new JButton("Home");
        btnForHome.setBackground(Color.LIGHT_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 4;
        EditPanel.add(btnForHome,EditComponents);

        JButton btnForClose = new JButton("exit");
        btnForClose.setBackground(Color.LIGHT_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 5;
        EditPanel.add(btnForClose,EditComponents);

        JFrame frame = new JFrame();
        frame.setTitle("confirmation window");
        frame.setVisible(true);
        frame.setSize(700, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(EditPanel);

        btnForHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new StartGUI();
            }
        });

        btnForClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
    private boolean checkDoctorAvailability(int doctorLicenceNum, String consultationDate) {
        for (Consultation value : WestminsterSkinConsultationManager.consultations) {
            if (value.getDoctorLicenceNum() == doctorLicenceNum && value.getDate().equals(consultationDate)) {
                return false;
            }
        }
        return true;
    }

}



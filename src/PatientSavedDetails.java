import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PatientSavedDetails {

    private static int patientid;

    private String patientfullname;

    public static void patientIdTransfer(int patId) {
        patientid = patId;
    }

    public PatientSavedDetails() {
        JPanel EditPanel = new JPanel(new GridLayout(2,1));
        EditPanel.setBackground(Color.YELLOW);
        EditPanel.setForeground(Color.BLUE);
        JPanel PanelBottom = new JPanel(new GridBagLayout());
        PanelBottom.setBackground(Color.YELLOW);
        PanelBottom.setForeground(Color.BLUE);

        GridBagConstraints EditComponents = new GridBagConstraints();
        EditComponents.insets = new Insets(5, 5, 5, 5);
        EditComponents.fill = GridBagConstraints.VERTICAL;
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        model.addColumn("Doctor medical licence number");
        model.addColumn("Patient Fullname");
        model.addColumn("Consultation Date");
        model.addColumn("Consultation Cost");
        model.addColumn("Consultation Note");

        for (Patient value1 : WestminsterSkinConsultationManager.patients) {
            if (value1.getPatientId() == patientid) {
                patientfullname = value1.getFirstname()+" "+value1.getSurname();
            }
        }

        for (Consultation value : WestminsterSkinConsultationManager.consultations) {
            if (value.getPatientID() == patientid) {
                int i = 0;
                String encodedNote = value.getNote();
                byte[] decodedBytes = Base64.getDecoder().decode(encodedNote);
                String decodedNote= new String(decodedBytes, StandardCharsets.UTF_8);
                model.insertRow(i,new String[]{String.valueOf(value.getDoctorLicenceNum()), patientfullname, value.getDate(), String.valueOf(value.getCost()), decodedNote});
                ++i;
            }
        }

        JScrollPane scrollPane = new JScrollPane(table);
        EditPanel.add(scrollPane);

        JButton btnForFirstGUI = new JButton("Home");
        btnForFirstGUI.setBackground(Color.BLUE);
        btnForFirstGUI.setForeground(Color.WHITE);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        PanelBottom.add(btnForFirstGUI,EditComponents);

        EditPanel.add(PanelBottom);

        JFrame frame = new JFrame();
        frame.setTitle("Booked Consultations");
        frame.setVisible(true);
        frame.setSize(700, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.PINK);
        frame.setForeground(Color.BLACK);
        frame.add(EditPanel);


        btnForFirstGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new StartGUI();
            }
        });
    }
}

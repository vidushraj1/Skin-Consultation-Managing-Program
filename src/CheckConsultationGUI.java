import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class CheckConsultationGUI {

    CheckConsultationGUI() {
        JPanel EditPanel = new JPanel(new GridBagLayout());
        EditPanel.setBackground(Color.YELLOW);
        EditPanel.setForeground(Color.BLUE);

        GridBagConstraints EditComponents = new GridBagConstraints();
        EditComponents.insets = new Insets(5, 5, 5, 5);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        JLabel patientidL = new JLabel("Patient's ID: ");
        patientidL.setBackground(Color.GREEN);
        patientidL.setForeground(Color.BLACK);
        EditComponents.gridx = 0;
        EditComponents.gridy = 1;
        EditPanel.add(patientidL,EditComponents);

        JTextField patientidT = new JTextField(5);
        patientidT.setBackground(Color.WHITE);
        patientidT.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        patientidT.setMinimumSize(patientidT.getPreferredSize());
        EditPanel.add(patientidT,EditComponents);

        JLabel patientpasswordL = new JLabel("Patient's Password: ");
        patientpasswordL.setBackground(Color.GREEN);
        patientpasswordL.setForeground(Color.BLACK);
        EditComponents.gridx = 0;
        EditComponents.gridy = 2;
        EditPanel.add(patientpasswordL,EditComponents);

        JTextField patientpasswordT = new JTextField(10);
        patientpasswordT.setBackground(Color.WHITE);
        patientpasswordT.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 2;
        patientpasswordT.setMinimumSize(patientpasswordT.getPreferredSize());
        EditPanel.add(patientpasswordT,EditComponents);

        JButton btnForView = new JButton("View");
        btnForView.setBackground(Color.BLUE);
        btnForView.setForeground(Color.WHITE);
        EditComponents.gridx = 1;
        EditComponents.gridy = 3;
        EditPanel.add(btnForView,EditComponents);

        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.PINK);
        frame.setForeground(Color.BLACK);
        frame.add(EditPanel);

        btnForView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (patientidT.getText().equals("")) {
                    showMessageDialog(patientidT, "Enter the patient ID");
                } else if (patientpasswordT.getText().equals("")) {
                    showMessageDialog(patientpasswordT,"Enter the password");
                } else {
                    try {
                        int patId = Integer.parseInt(patientidT.getText());
                        String patPassword = patientpasswordT.getText();
                        PatientSavedDetails.patientIdTransfer(patId);
                        for (Patient value : WestminsterSkinConsultationManager.patients) {
                            if (value.getPatientId() == patId && value.getPassword().equals(patPassword)) {
                                frame.setVisible(false);
                                new PatientSavedDetails();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(btnForView,"you entered Patient ID or Password is incorrect");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(patientidT,"Invalid data");
                    }
                }
            }
        });
    }
}

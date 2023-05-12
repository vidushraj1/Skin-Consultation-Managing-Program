import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class MedicalLNumberPromptGUI {

    MedicalLNumberPromptGUI() {
        JPanel EditPanel = new JPanel(new GridBagLayout());
        EditPanel.setBackground(Color.BLUE);

        GridBagConstraints EditComponents = new GridBagConstraints();
        EditComponents.insets = new Insets(5, 50, 5, 50);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        JLabel LicNoL = new JLabel("Enter the Medical licence number");
        LicNoL.setForeground(Color.GREEN);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;
        EditPanel.add(LicNoL,EditComponents);

        JTextField LicNoT = new JTextField(5);
        EditComponents.gridx = 1;
        EditComponents.gridy = 0;
        EditComponents.weightx = 1;
        EditPanel.add(LicNoT,EditComponents);

        JButton btnForBook = new JButton("Click Here");
        btnForBook.setBackground(Color.YELLOW);
        btnForBook.setForeground(Color.RED);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        EditPanel.add(btnForBook,EditComponents);

        JFrame frame = new JFrame();
        frame.setTitle("Medical License Number");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(EditPanel);
        new SortingDoctorsGUI();

        btnForBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = true;
                if (LicNoT.getText().equals("")) {
                    showMessageDialog(LicNoT, "Enter Doctor's Medical license number");
                } else {
                    try {
                        int MedNo = Integer.parseInt(LicNoT.getText());
                        ConsultationDetailsAddGUI.MedicalLicenseNoTransfer(MedNo);
                        for (Doctor value : WestminsterSkinConsultationManager.doctors) {
                            if (value.getMedicalLicenceNumber() == MedNo) {
                                frame.setVisible(false);
                                new ConsultationDetailsAddGUI();
                                check = false;
                            }
                        }
                        if (check) {
                            JOptionPane.showMessageDialog(btnForBook,"Given Medical License Number is not in database");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(LicNoT,"you have entered invalid characters or it is blank");
                    }
                }
            }
        });
    }
}

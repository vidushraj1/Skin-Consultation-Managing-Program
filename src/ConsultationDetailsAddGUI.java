import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class ConsultationDetailsAddGUI {

    private static int doctormedicalicensenumber;

    private static String doctorfullname;

    public static void MedicalLicenseNoTransfer(int number) {
        doctormedicalicensenumber =  number;
    }

    ConsultationDetailsAddGUI() {
        JPanel Editpanel = new JPanel(new GridBagLayout());
        Editpanel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints EditComponents = new GridBagConstraints();
        EditComponents.insets = new Insets(5, 50, 5, 50);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        JLabel doctormedicalL = new JLabel("Doctor's Medical licence Number.");
        doctormedicalL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;
        Editpanel.add(doctormedicalL,EditComponents);

        JLabel doctormedicalT = new JLabel(String.valueOf(doctormedicalicensenumber));
        doctormedicalT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 0;
        Editpanel.add(doctormedicalT,EditComponents);

        JLabel doctornameL = new JLabel("Doctor's full Name");
        doctornameL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 1;
        Editpanel.add(doctornameL,EditComponents);

        for (Doctor value: BookSortGUI.doctorList) {
            if (value.getMedicalLicenceNumber() == doctormedicalicensenumber) {
                doctorfullname = value.getFirstname()+" "+value.getSurname();
            }
        }

        JLabel doctornameT = new JLabel(doctorfullname);
        doctornameT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        Editpanel.add(doctornameT,EditComponents);

        JLabel patientfirstnameL = new JLabel("Enter the Patient firstame");
        patientfirstnameL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 2;
        Editpanel.add(patientfirstnameL,EditComponents);

        JTextField patientfirstnameT = new JTextField(10);
        patientfirstnameT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 2;
        EditComponents.weightx = 1;
        patientfirstnameT.setMinimumSize(patientfirstnameT.getPreferredSize());
        Editpanel.add(patientfirstnameT,EditComponents);

        JLabel patientsurnameL = new JLabel("Enter the Patient surname");
        patientsurnameL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 3;
        Editpanel.add(patientsurnameL,EditComponents);

        JTextField patientsurnameT = new JTextField(10);
        patientsurnameT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 3;
        EditComponents.weightx = 1;
        patientsurnameT.setMinimumSize(patientsurnameT.getPreferredSize());
        Editpanel.add(patientsurnameT,EditComponents);

        JLabel patientDOBL = new JLabel("Enter the Patient Date of Birth. ex.yyyy/mm/dd");
        patientDOBL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 4;
        Editpanel.add(patientDOBL,EditComponents);

        JTextField patientDOBT = new JTextField(10);
        patientDOBT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 4;
        EditComponents.weightx = 1;
        patientDOBT.setMinimumSize(patientDOBT.getPreferredSize());
        Editpanel.add(patientDOBT,EditComponents);

        JLabel patientmobnoL = new JLabel("Enter the Patient Mobile Number. ex.07xxxxxxx");
        patientmobnoL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 5;
        Editpanel.add(patientmobnoL,EditComponents);

        JTextField patientmobnoT = new JTextField(10);
        patientmobnoT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 5;
        EditComponents.weightx = 1;
        patientmobnoT.setMinimumSize(patientmobnoT.getPreferredSize());
        Editpanel.add(patientmobnoT,EditComponents);

        JLabel patientidL = new JLabel("Enter the Patient ID");
        patientidL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 6;
        Editpanel.add(patientidL,EditComponents);

        JTextField patientidT = new JTextField(10);
        patientidT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 6;
        EditComponents.weightx = 1;
        patientidT.setMinimumSize(patientidT.getPreferredSize());
        Editpanel.add(patientidT,EditComponents);

        JLabel consulthourL = new JLabel("How many Consultation Hours?");
        consulthourL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 7;
        Editpanel.add(consulthourL,EditComponents);

        JTextField consulthourT = new JTextField(5);
        consulthourT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 7;
        EditComponents.weightx = 1;
        consulthourT.setMinimumSize(consulthourT.getPreferredSize());
        Editpanel.add(consulthourT,EditComponents);

        JLabel consultdateL = new JLabel(" Enter a Consultation Date. ex.yyyy/mm/dd");
        consultdateL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 8;
        Editpanel.add(consultdateL,EditComponents);

        JTextField consultdateT = new JTextField(10);
        consultdateT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 8;
        EditComponents.weightx = 1;
        consultdateT.setMinimumSize(consultdateT.getPreferredSize());
        Editpanel.add(consultdateT,EditComponents);

        JLabel consultnoteL = new JLabel(" Type some Consultation Note");
        consultnoteL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 9;
        Editpanel.add(consultnoteL,EditComponents);

        JTextArea consultnoteT = new JTextArea(5,20);
        consultnoteT.setLineWrap(true);
        consultnoteT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 9;
        EditComponents.weightx = 1;
        consultnoteT.setMinimumSize(consultnoteT.getPreferredSize());
        Editpanel.add(consultnoteT,EditComponents);

        JLabel patientpasswordL = new JLabel("Enter a Password");
        patientpasswordL.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 0;
        EditComponents.gridy = 10;
        Editpanel.add(patientpasswordL,EditComponents);

        JTextField patientpasswordT = new JTextField(10);
        patientpasswordT.setForeground(Color.DARK_GRAY);
        EditComponents.gridx = 1;
        EditComponents.gridy = 10;
        EditComponents.weightx = 1;
        patientpasswordT.setMinimumSize(patientpasswordT.getPreferredSize());
        Editpanel.add(patientpasswordT,EditComponents);

        JButton btnForSave= new JButton("Save");
        btnForSave.setForeground(Color.blue);
        EditComponents.gridx = 1;
        EditComponents.gridy = 11;
        Editpanel.add(btnForSave,EditComponents);

        JFrame frame = new JFrame();
        frame.setTitle("Book details");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.DARK_GRAY);
        frame.setBackground(Color.orange);
        frame.add(Editpanel);

        btnForSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temppatientfirstname;
                String temppatientsurname;
                String temppatientdob;
                String temppatientpassword;
                long temppatientmobileno;
                int temppatientid;
                String tempconsultnote;
                String tempconsultdate;
                int tempconsulthour;

                if (patientfirstnameT.getText().equals("")) {
                    showMessageDialog(patientfirstnameT,"Enter the patient firstname");

                }else if (patientsurnameT.getText().equals("")) {
                    showMessageDialog(patientsurnameT,"Enter the patient surname");

                } else if (patientDOBT.getText().equals("")) {
                    showMessageDialog(patientDOBT,"Enter the patient's date of birth(yyyy/mm/dd)");

                } else if (patientmobnoT.getText().equals("")) {
                    showMessageDialog(patientmobnoT, "Enter the patient mobile No.");

                } else if (patientidT.getText().equals("")) {
                    showMessageDialog(patientidT, "Enter the patient ID");

                } else if (consulthourT.getText().equals("")) {
                    showMessageDialog(consulthourT, "Enter the consultation hours");

                }else if (consultdateT.getText().equals("")) {
                    showMessageDialog(consultdateT,"Enter the consultation date(yyyy/mm/dd)");

                } else if (consultnoteT.getText().equals("")) {
                    showMessageDialog(consultnoteT,"Enter a note");

                } else if (patientpasswordT.getText().equals("")) {
                    showMessageDialog(consultnoteT,"Enter the password");
                } else {
                    temppatientfirstname = patientfirstnameT.getText();
                    temppatientsurname = patientsurnameT.getText();
                    temppatientpassword = patientpasswordT.getText();

                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    Date date;

                    temppatientdob = patientDOBT.getText();
                    try {
                        date = df.parse(temppatientdob);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(patientDOBT,"invalid try again!!! Enter in this format yyyy/MM/dd");
                    }

                    tempconsultnote = consultnoteT.getText();
                    String encodedconNote = Base64.getEncoder().encodeToString(tempconsultnote.getBytes());

                    tempconsultdate = consultdateT.getText();
                    try {
                        date = df.parse(tempconsultdate);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(consultdateT,"invalid try again!!! Enter in this format yyyy/MM/dd");
                    }

                    try {
                        temppatientmobileno = Long.parseLong(patientmobnoT.getText());
                        temppatientid = Integer.parseInt(patientidT.getText());
                        tempconsulthour = Integer.parseInt(consulthourT.getText());

                        ConfirmationFinalGUI.patientObjectTransfer(temppatientfirstname,temppatientsurname,temppatientdob,temppatientmobileno,temppatientid,temppatientpassword);
                        ConfirmationFinalGUI.consultationObjectTransfer(tempconsulthour,tempconsultdate,encodedconNote);
                        ConfirmationFinalGUI.doctorTransfer(doctormedicalicensenumber, doctorfullname);

                        frame.setVisible(false);
                        new ConfirmationFinalGUI();

                    } catch (NumberFormatException ex) {
                        showMessageDialog(patientmobnoT,"invalid try again");
                    }
                }
            }
        });
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SortingDoctorsGUI {
    public static ArrayList<Doctor> doctorList;

    public static void doctorTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    SortingDoctorsGUI() {
        JPanel EditPanel = new JPanel(new GridLayout(2,1));
        JPanel PanelBottom = new JPanel(new GridBagLayout());

        GridBagConstraints EditComponents = new GridBagConstraints();

        EditComponents.insets = new Insets(5, 5, 5, 5);
        EditComponents.fill = GridBagConstraints.VERTICAL;
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);

        model.addColumn("Doctor's Firstname");
        model.addColumn("Doctor's Surname");
        model.addColumn("Doctor's Date of birth");
        model.addColumn("Doctor's Mobile No.");
        model.addColumn("Doctor's Licence No.");
        model.addColumn("Doctor's Specialization");

        doctorList.sort(new SortingDoctorsFname());

        int i = 0;
        for (Doctor value : doctorList) {
            model.insertRow(i,new String[]{value.getFirstname(), value.getSurname(), String.valueOf(value.getDateOfBirth()), Long.toString(value.getMobileNumber()), Integer.toString(value.getMedicalLicenceNumber()), value.getSpecialisation()});
            i++;
        }

        JScrollPane scrollPane = new JScrollPane(table);
        EditPanel.add(scrollPane);

        JButton btnForBack = new JButton("Back");
        btnForBack.setBackground(Color.BLUE);
        btnForBack.setForeground(Color.WHITE);
        EditComponents.gridx = 1;
        EditComponents.gridy = 0;
        PanelBottom.add(btnForBack,EditComponents);

        EditPanel.add(PanelBottom);

        JFrame frame = new JFrame();
        frame.setTitle("Sort Table");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(EditPanel);

        btnForBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BookSortGUI();
            }
        });
    }
}


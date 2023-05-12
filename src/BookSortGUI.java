// Packages to import
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookSortGUI extends JFrame {

    public static ArrayList<Doctor> doctorList;

    public static void doctorTransfer(ArrayList<Doctor> doctorList2) {
        doctorList = doctorList2;
    }

    BookSortGUI()
    {
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

        int i = 0;
        for (Doctor value : doctorList) {
            model.insertRow(i,new String[]{value.getFirstname(), value.getSurname(), String.valueOf(value.getDateOfBirth()), Long.toString(value.getMobileNumber()), Integer.toString(value.getMedicalLicenceNumber()), value.getSpecialisation()});
            i++;
        }

        JScrollPane scrollPane = new JScrollPane(table);
        EditPanel.add(scrollPane);

        JButton btnForSorting = new JButton("Sort");
        btnForSorting.setBackground(Color.BLUE);
        btnForSorting.setForeground(Color.WHITE);
        EditComponents.gridx = 1;
        EditComponents.gridy = 0;
        PanelBottom.add(btnForSorting,EditComponents);

        JButton btnForBook = new JButton("Book a Doctor");
        btnForBook.setBackground(Color.GREEN);
        btnForBook.setForeground(Color.WHITE);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        PanelBottom.add(btnForBook,EditComponents);

        EditPanel.add(PanelBottom);

        JFrame frame = new JFrame();
        frame.setTitle("Sort Doctors");
        frame.setVisible(true);
        frame.setSize(700, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(EditPanel);

        btnForBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MedicalLNumberPromptGUI();
            }
        });


        btnForSorting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingDoctorsGUI.doctorTransfer(doctorList);
                frame.setVisible(false);
                new SortingDoctorsGUI();
            }
        });
    }
}

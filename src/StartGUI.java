import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI extends JFrame {

    StartGUI() {
        JPanel EditPanel = new JPanel(new GridBagLayout());
        GridBagConstraints EditComponents = new GridBagConstraints();

        EditComponents.fill = GridBagConstraints.VERTICAL;
        EditComponents.gridx = 0;
        EditComponents.gridy = 0;
        EditComponents.gridwidth = 3;
        EditComponents.insets = new Insets(20, 0, 20, 0);
        EditComponents.anchor = GridBagConstraints.CENTER;

        JLabel label = new JLabel("Westminster Skin Consultation Welcomes you!!!!!");
        label.setForeground(Color.BLUE);
        EditPanel.add(label, EditComponents);

        EditComponents.gridwidth = 1;
        EditComponents.anchor = GridBagConstraints.LINE_START;

        JButton btnForCheckList = new JButton("Check for the Doctor List");
        btnForCheckList.setBackground(Color.GREEN);
        btnForCheckList.setForeground(Color.WHITE);
        EditComponents.gridx = 0;
        EditComponents.gridy = 1;
        EditPanel.add(btnForCheckList, EditComponents);

        JButton btnForChenkConsult = new JButton("Check for any booked consultations");
        btnForChenkConsult.setBackground(Color.YELLOW);
        btnForChenkConsult.setForeground(Color.BLACK);
        EditComponents.gridx = 1;
        EditComponents.gridy = 1;
        EditPanel.add(btnForChenkConsult, EditComponents);

        JFrame frame = new JFrame();
        frame.setTitle("Westminster Skin Consultation Manager");
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(EditPanel);

        btnForCheckList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BookSortGUI();
            }
        });
                btnForChenkConsult.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (WestminsterSkinConsultationManager.patients.isEmpty()) {
                            JOptionPane.showMessageDialog(btnForChenkConsult,"no patients Available");
                        } else {
                            frame.setVisible(false);
                            new CheckConsultationGUI();
                        }
                    }
                });
            }
        }

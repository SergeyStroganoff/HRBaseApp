package UIX;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame {

    public void initFrame() {

        JFrame frame = new JFrame("База данных сотрудников предприятия");
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridFrame = new GridBagConstraints();


        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.GRAY);
        gridFrame.gridx = 100;
        gridFrame.gridy = 100;
        frame.add(jPanel, gridFrame);


        JButton jButtonConnect = new JButton();
        jButtonConnect.setText("Connect with base");
        jButtonConnect.setVisible(true);
        jButtonConnect.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jButtonConnect.setBounds(200, 250, 100, 40);
        jPanel.add(jButtonConnect);

        JTextField jTextFieldFind = new JTextField(10);
        frame.add(jTextFieldFind);
        jTextFieldFind.setVisible(true);


        JLabel labelInformation = new JLabel();
        labelInformation.setVisible(true);
        frame.add(labelInformation);
        frame.setVisible(true);
    }


}

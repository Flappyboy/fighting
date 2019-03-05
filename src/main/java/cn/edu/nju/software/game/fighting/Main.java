package cn.edu.nju.software.game.fighting;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new LoginPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

class LoginPanel extends JPanel {
    JTextField userfield = new JTextField(10);
    JPasswordField passfield = new JPasswordField(10);
    JButton login = new JButton("Login");
    JButton create = new JButton("Create Account");

    public LoginPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel label = new JLabel("Username: ");
        add(label, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        add(userfield, gbc);

        gbc.gridy = 1;
        add(passfield, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 2;
        label = new JLabel("Password: ");
        add(label, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridwidth = 5;
        add(new JSeparator(JSeparator.HORIZONTAL), gbc);
    }
}

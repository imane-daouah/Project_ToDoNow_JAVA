package Presentation;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JFrame {

    private static final long serialVersionUID = 1L;

    public Connexion() {
        setTitle("DO NAW");
        setSize(500, 300); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        getContentPane().setBackground(new Color(253, 235, 191)); // Light yellow background
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning
        
        // Email Label
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        GridBagConstraints gbcEmailLabel = new GridBagConstraints();
        gbcEmailLabel.gridx = 0;
        gbcEmailLabel.gridy = 0;
        gbcEmailLabel.insets = new Insets(10, 10, 10, 10);
        gbcEmailLabel.anchor = GridBagConstraints.WEST;
        getContentPane().add(emailLabel, gbcEmailLabel);
        
        // Email Text Field
        JTextField emailField = new JTextField(15);
        emailField.setPreferredSize(new Dimension(150, 24));
        GridBagConstraints gbcEmailField = new GridBagConstraints();
        gbcEmailField.gridx = 1;
        gbcEmailField.gridy = 0;
        gbcEmailField.insets = new Insets(10, 10, 10, 10);
        gbcEmailField.anchor = GridBagConstraints.WEST;
        getContentPane().add(emailField, gbcEmailField);
        
        // Connect Button
        JButton connectButton = new JButton("Connecter");
        connectButton.setBackground(new Color(51, 187, 88)); // A shade of teal
        connectButton.setForeground(Color.WHITE);
        connectButton.setFont(new Font("Arial", Font.BOLD, 12));
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0;
        gbcButton.gridy = 1;
        gbcButton.gridwidth = 3;
        gbcButton.anchor = GridBagConstraints.CENTER;
        gbcButton.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(connectButton, gbcButton);

        // Action listener pour le bouton "Connecter"
        connectButton.addActionListener(e -> openDashboard());
    }

    private void openDashboard() {
        Dashboard dashboard = new Dashboard();
        dispose();
        dashboard.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Connexion frame = new Connexion();
            frame.setVisible(true);
        });
    }
}
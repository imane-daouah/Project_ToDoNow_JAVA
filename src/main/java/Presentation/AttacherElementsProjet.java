package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttacherElementsProjet extends JFrame {

    private static final long serialVersionUID = 1L;

    public AttacherElementsProjet() {
        setTitle("Attacher Éléments au Projet");
        setSize(900, 600);  // Set size of the window
        setLocationRelativeTo(null);  // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close operation
        getContentPane().setBackground(new Color(255, 230, 153));  // Background color

        // Create navigation buttons panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnBack = new JButton("Reviens");
        btnBack.setBackground(new Color(154, 215, 237));
        JButton btnMenu = new JButton("Menu");
        btnMenu.setBackground(new Color(51, 187, 88));
        JButton btnClose = new JButton("Fermer");
        btnClose.setBackground(new Color(255, 62, 62));
        topPanel.add(btnBack);
        topPanel.add(btnMenu);
        topPanel.add(btnClose);
        btnClose.addActionListener(e -> System.exit(0));  // Add action to close the window

        // Create buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(253, 235, 191));
        JButton btnAttachTask = new JButton("Attacher une tache");
        btnAttachTask.setBackground(new Color(154, 215, 237));
        JButton btnAttachSession = new JButton("Attacher une séance");
        btnAttachSession.setBackground(new Color(154, 215, 237));
        JButton btnAttachDocument = new JButton("Attacher un document");
        btnAttachDocument.setBackground(new Color(154, 215, 237));
        SpringLayout sl_buttonPanel = new SpringLayout();
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, btnAttachSession, 237, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, btnAttachSession, -236, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, btnAttachDocument, 54, SpringLayout.SOUTH, btnAttachSession);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, btnAttachDocument, 128, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, btnAttachDocument, -125, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, btnAttachDocument, 0, SpringLayout.EAST, btnAttachTask);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, btnAttachSession, 128, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, btnAttachSession, -107, SpringLayout.EAST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, btnAttachTask, 126, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, btnAttachTask, 128, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, btnAttachTask, -54, SpringLayout.NORTH, btnAttachSession);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, btnAttachTask, 0, SpringLayout.EAST, btnAttachSession);
        buttonPanel.setLayout(sl_buttonPanel);
        buttonPanel.add(btnAttachTask);
        buttonPanel.add(btnAttachSession);
        buttonPanel.add(btnAttachDocument);

        // Add panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // Action listener for "Attacher une tache" button
        btnAttachTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Ferme la fenêtre actuelle
                SwingUtilities.invokeLater(() -> {
                    new AttacherTache().setVisible(true);  // Ouvre la fenêtre AttacherTache
                });
            }
        });

        // Action listener for "Attacher une séance" button
        btnAttachSession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Ferme la fenêtre actuelle
                SwingUtilities.invokeLater(() -> {
                    new AttacherSeance().setVisible(true);  // Ouvre la fenêtre AttacherSeance
                });
            }
        });
     // Action listener for "Menu" button
        btnMenu.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
       
        btnBack.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                dispose();
            	ModifierProjet attacher= new ModifierProjet();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });

        // Action listener for "Attacher un document" button
        btnAttachDocument.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Ferme la fenêtre actuelle
                SwingUtilities.invokeLater(() -> {
                    new AttacherDocument().setVisible(true);  // Ouvre la fenêtre AttacherDocument
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AttacherElementsProjet().setVisible(true);
        });
    }
}

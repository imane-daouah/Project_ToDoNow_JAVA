package Presentation;

import javax.swing.*;
import java.awt.*;

public class AttacherDocument extends JFrame {

	private static final long serialVersionUID = 1L;

	public AttacherDocument() {
        setTitle("DO NOW : Attacher un Document");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new BorderLayout());
        

        // Panel pour les boutons "Revenir en Menu" et "Fermer" en haut
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));
        
        JButton btnRevenir = new JButton("Revenir");
        btnRevenir.setBackground(new Color(154, 215, 237));
        btnRevenir.setHorizontalAlignment(SwingConstants.LEFT);
        topPanel.add(btnRevenir);
        topPanel.add(menuButton);
        topPanel.add(closeButton);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Panel pour les boutons "Créer une tâche" et "Importer une tâche" au centre
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(253, 235, 191));
        JButton createButton = new JButton("Créer un document");
        createButton.addActionListener(e -> {
            dispose();
            CreéDocument createDocumentWindow = new CreéDocument();
            createDocumentWindow.setVisible(true);
        });

        createButton.setFont(new Font("Arial", Font.BOLD, 15));
        createButton.setBackground(new Color(154, 215, 237));
        JButton importButton = new JButton("Importer un document");
        importButton.addActionListener(e -> {
            dispose();
        	importerDocument create = new importerDocument();
            create.setVisible(true);
        });
        importButton.setFont(new Font("Arial", Font.BOLD, 15));
        importButton.setBackground(new Color(154, 215, 237));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, createButton, 154, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, createButton, -322, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, importButton, 79, SpringLayout.SOUTH, createButton);
        sl_centerPanel.putConstraint(SpringLayout.WEST, importButton, 0, SpringLayout.WEST, createButton);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, importButton, -189, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, importButton, -163, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, createButton, 175, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, createButton, -163, SpringLayout.EAST, centerPanel);
        centerPanel.setLayout(sl_centerPanel);
        centerPanel.add(createButton);
        centerPanel.add(importButton);
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Action listeners pour les boutons
        
        menuButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        btnRevenir.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                dispose();
            	AttacherElementsProjet attacher= new AttacherElementsProjet();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
       
    
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            new AttacherDocument().setVisible(true);
        });
    }
}

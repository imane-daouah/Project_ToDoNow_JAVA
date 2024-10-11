package Presentation;

import javax.swing.*;
import java.awt.*;

public class DocumentSeance extends JFrame {

    private static final long serialVersionUID = 1L;

    public DocumentSeance() {
        setTitle("DO NOW : Documents de Séance");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        // Création du panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Ajout de quelques documents à titre d'exemple
        mainPanel.add(createDocumentPanel("Document 1", "Description du document 1", "Date d'ajout: 01/01/2024"));
        mainPanel.add(createDocumentPanel("Document 2", "Description du document 2", "Date d'ajout: 02/02/2024"));
        mainPanel.add(createDocumentPanel("Document 3", "Description du document 3", "Date d'ajout: 03/03/2024"));

        // Scroll Pane pour gérer plusieurs documents
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Panneau pour les boutons de navigation
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Reviens");  // Correction orthographique
        backButton.setBackground(new Color(154, 215, 237));
        
        backButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                ProjetDetail projetDetail = new ProjetDetail("Titre du Projet");
                projetDetail.setVisible(true);  // Ouvre la fenêtre ProjetDetail
            });
        });
        
        
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));

        menuButton.addActionListener(e -> retourMenu());
        closeButton.addActionListener(e -> dispose());

        navPanel.add(backButton);
        navPanel.add(menuButton);
        navPanel.add(closeButton);

        getContentPane().add(navPanel, BorderLayout.NORTH);
    }

    private JPanel createDocumentPanel(String title, String description, String date) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        JLabel descLabel = new JLabel(description);
        JLabel dateLabel = new JLabel(date);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(253, 235, 191));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(descLabel);
        infoPanel.add(dateLabel);
        
        panel.add(infoPanel, BorderLayout.CENTER);

        JButton deleteButton = new JButton(new ImageIcon("supprimer.png")); // Assurez-vous que l'icône existe
        deleteButton.setBackground(new Color(227, 227, 227));
        deleteButton.addActionListener(e -> panel.setVisible(false)); // Ajout d'une action pour supprimer le panel
        panel.add(deleteButton, BorderLayout.EAST);

        return panel; // Assurez-vous de retourner le panel créé
    }
    
    


    private void retourMenu() {
        // Logic for returning to the main menu
        dispose(); // Ferme cette fenêtre
        Dashboard dashboard = new Dashboard(); // Supposer que Dashboard est la fenêtre principale
        dashboard.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DocumentSeance().setVisible(true);
        });
    }
}

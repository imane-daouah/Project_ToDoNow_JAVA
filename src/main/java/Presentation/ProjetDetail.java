package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjetDetail extends JFrame {

	private static final long serialVersionUID = 1L;

	public ProjetDetail(String projetTitre) {
        initializeUI(projetTitre);
    }
	
	
    private void initializeUI(String projetTitre) {
        setTitle("DO NOW : Projet Detail ");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel pour le titre du projet
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Détails du Projet: " + projetTitre);
        titleLabel.setBackground(new Color(227, 227, 227));
        titleLabel.setVerticalAlignment(SwingConstants.TOP);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Panel pour les détails du projet
        JPanel detailPanel = new JPanel(new GridLayout(5, 1));
        JLabel lblCatgorieEnseignement = new JLabel(" Catégorie : Enseignement");
        lblCatgorieEnseignement.setBackground(new Color(253, 235, 191));
        lblCatgorieEnseignement.setFont(new Font("Arial", Font.BOLD, 12));
        detailPanel.add(lblCatgorieEnseignement);
        JLabel lblTypeCours = new JLabel(" Type : Cours");
        lblTypeCours.setBackground(new Color(253, 235, 191));
        lblTypeCours.setFont(new Font("Arial", Font.BOLD, 12));
        detailPanel.add(lblTypeCours);
        JLabel lblDateDpart = new JLabel(" Date Départ : 10-09-2024");
        lblDateDpart.setBackground(new Color(253, 235, 191));
        lblDateDpart.setFont(new Font("Arial", Font.BOLD, 12));
        detailPanel.add(lblDateDpart);
        JLabel lblDateFin = new JLabel(" Date fin : 2-01-2025");
        lblDateFin.setBackground(new Color(253, 235, 191));
        lblDateFin.setFont(new Font("Arial", Font.BOLD, 12));
        detailPanel.add(lblDateFin);
        JLabel lblDescription = new JLabel(" Description : ....................................................");
        lblDescription.setBackground(new Color(253, 235, 191));
        lblDescription.setFont(new Font("Arial", Font.BOLD, 12));
        detailPanel.add(lblDescription);

        // Panel pour les boutons des tâches, séances, et documents
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(227, 227, 227));
        SpringLayout sl_buttonPanel = new SpringLayout();
        buttonPanel.setLayout(sl_buttonPanel);
        JButton seancesButton = new JButton("Voir les séances de ce projet");
        
        seancesButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	DesSéancesProjet attacher= new DesSéancesProjet();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        seancesButton.setBackground(new Color(154, 215, 237));
        sl_buttonPanel.putConstraint(SpringLayout.WEST, seancesButton, 92, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, seancesButton, -166, SpringLayout.EAST, buttonPanel);
        buttonPanel.add(seancesButton);
        JButton tachesButton = new JButton("Voir les tâches de ce projet");
        
        tachesButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	DocumentTache attacher= new DocumentTache();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, seancesButton, -110, SpringLayout.NORTH, tachesButton);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, tachesButton, 242, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, tachesButton, 0, SpringLayout.WEST, seancesButton);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, tachesButton, 0, SpringLayout.EAST, seancesButton);
        tachesButton.setBackground(new Color(154, 215, 237));
        buttonPanel.add(tachesButton);
        JButton documentsButton = new JButton("Voir les documents de ce projet");
        
        documentsButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	DocumentsProjet attacher= new DocumentsProjet();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, documentsButton, 378, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, documentsButton, -135, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, tachesButton, -104, SpringLayout.NORTH, documentsButton);
        documentsButton.setBackground(new Color(154, 215, 237));
        sl_buttonPanel.putConstraint(SpringLayout.WEST, documentsButton, 0, SpringLayout.WEST, seancesButton);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, documentsButton, -166, SpringLayout.EAST, buttonPanel);
        documentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(documentsButton);

        // Configuration des boutons Menu et Fermer
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(227, 227, 227));

        // Ajout des panels au frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(detailPanel, BorderLayout.WEST);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("Voir Les Pièces Jointes Du Projet:");
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, seancesButton, 44, SpringLayout.SOUTH, lblNewLabel);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 38, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, seancesButton);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        buttonPanel.add(lblNewLabel);
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, menuButton, 0, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, menuButton, -97, SpringLayout.EAST, buttonPanel);
        buttonPanel.add(menuButton);
        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));
        buttonPanel.add(closeButton);
        closeButton.addActionListener(e -> dispose());
        

        sl_buttonPanel.putConstraint(SpringLayout.NORTH, closeButton, 0, SpringLayout.NORTH, menuButton);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, closeButton, 6, SpringLayout.EAST, menuButton);
        menuButton.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProjetDetail("Titre du Projet").setVisible(true);
        });
    }
}

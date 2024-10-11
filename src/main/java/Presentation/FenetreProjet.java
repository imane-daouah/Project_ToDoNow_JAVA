package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreProjet extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private JPanel panelProjets;
    private JTextField searchField;
    private JComboBox<String> comboBoxFiltre;

    public FenetreProjet() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO Now : Fenetre Vos Projet");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new BorderLayout());

        // North Panel for filters, search, menu, and close
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northPanel.setBackground(new Color(253, 235, 191));

        JLabel labelFiltrer = new JLabel("Filtrer:");
        northPanel.add(labelFiltrer);

        String[] filtres = { "Catégorie", "Type", "Catégorie&Type" };
        comboBoxFiltre = new JComboBox<>(filtres);
        northPanel.add(comboBoxFiltre);
        JButton searchButton = new JButton("Rechercher");
        searchButton.setBackground(new Color(154, 215, 237));
        northPanel.add(searchButton);

        searchField = new JTextField(20);
        northPanel.add(searchField);

        JButton addButton = new JButton("Ajouter un nouveau projet");
        addButton.setBackground(new Color(154, 215, 237));
        addButton.addActionListener(e -> ajouterProjet());
        northPanel.add(addButton);

        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        menuButton.addActionListener(e -> ouvrirDashboard());
        northPanel.add(menuButton);

        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));
        closeButton.addActionListener(e -> dispose());
        northPanel.add(closeButton);

        getContentPane().add(northPanel, BorderLayout.NORTH);

        // Central Panel for project list
        panelProjets = new JPanel();
        panelProjets.setBackground(new Color(253, 235, 191));
        panelProjets.setLayout(new BoxLayout(panelProjets, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelProjets);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Populate with dummy data
        populateProjects();
    }

    private void populateProjects() {
        for (int i = 1; i <= 3; i++) {
            JPanel projectPanel = new JPanel(new BorderLayout());
            projectPanel.setBorder(BorderFactory.createTitledBorder("Projet " + i));
            projectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            projectPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(FenetreProjet.this, "Ouvrir les détails du projet");
                }
            });

            JLabel label = new JLabel(
                    "<html>Catégorie : Enseignement<br>Type : Cours<br>Date Départ : 10-09-2024<br>Date fin : 2-01-2025<br>Description : .................</html>",
                    JLabel.CENTER);
            projectPanel.add(label, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            ImageIcon modifierIcon = new ImageIcon("modifier.png");
            ImageIcon supprimerIcon = new ImageIcon("supprimer.png");
            JButton editButton = new JButton(modifierIcon);
            JButton deleteButton = new JButton(supprimerIcon);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            projectPanel.add(buttonPanel, BorderLayout.EAST);

            editButton.addActionListener(e -> modifierProjet());

            panelProjets.add(projectPanel);
        }
    }

    

	private void ajouterProjet() {
        dispose();
        CreéUnProjet creerProjet = new CreéUnProjet();
        creerProjet.setVisible(true);
    }

    private void modifierProjet() {
        ModifierProjet modifierProjet = new ModifierProjet();
        modifierProjet.setVisible(true);
    }

  

    private void ouvrirDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dispose(); // Ferme la fenêtre actuelle
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FenetreProjet().setVisible(true);
        });
    }
}

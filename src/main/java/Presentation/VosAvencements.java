package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VosAvencements extends JFrame {
 
	private static final long serialVersionUID = 1L;

	public VosAvencements() {
        setTitle("DO NOW : Vos Avancements");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Centrer la fenêtre par rapport à l'écran
        setLocationRelativeTo(null);

        // North panel for action buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnMenu = new JButton("Menu");
        btnMenu.setBackground(new Color(255, 62, 62));
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(51, 187, 88));

        // ActionListener for "Menu" button
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();
                // Ouvrir la fenêtre Dashboard
                SwingUtilities.invokeLater(() -> {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                });
            }
        });

        // ActionListener for "Fermer" button
        btnFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();
            }
        });

        buttonPanel.add(btnMenu);
        buttonPanel.add(btnFermer);
        topPanel.add(buttonPanel, BorderLayout.NORTH);

        // Grid panel for the information sections
        JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the grid

        // Adding custom styled panels
        gridPanel.add(createStyledPanel("Nombre d'heures de travail sur un projet", "14h"));
        gridPanel.add(createStyledPanel("Nombre de documents par projet", "14"));
        gridPanel.add(createStyledPanel("Nombre d'heure de travail", "PAR SEMAINE : \nPAR MOIS : \nPAR ANNÉE :"));
        gridPanel.add(createStyledPanel("Pourcentage d'heure de travail par catégorie", "PAR SEMAINE : \nPAR MOIS : \nPAR ANNÉE :"));
        gridPanel.add(createStyledPanel("Nombre d'heure de travail", "PAR SEMAINE : \nPAR MOIS : \nPAR ANNÉE :"));

        // Assembling the main frame
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(gridPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createStyledPanel(String title, String detail) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel.setBackground(new Color(253, 235, 191)); // Light yellow background

        JLabel lblTitle = new JLabel("<html><body style='text-align: center;'><strong>" + title + "</strong><br/>" + detail + "</body></html>", JLabel.CENTER);
        lblTitle.setBackground(new Color(253, 235, 191));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblTitle, BorderLayout.CENTER);

        // Adding mouse listener for interactivity
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, "Vous avez cliqué sur : " + title);
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        new VosAvencements();
    }
}

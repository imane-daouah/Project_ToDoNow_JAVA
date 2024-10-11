package Presentation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private static final long serialVersionUID = 1L;

    public Dashboard() {
        setTitle("DO NOW : MENU");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 230, 153));
        initializeUI();
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 230, 153));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(255, 230, 153));
        JButton btnClose = new JButton("Fermer");
        btnClose.setBackground(Color.RED);
        btnClose.setForeground(Color.WHITE);
        topPanel.add(btnClose);
        btnClose.addActionListener(e -> System.exit(0));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        ImageIcon projetIcon = new ImageIcon("Projet.png");
        Image projetImage = projetIcon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        ImageIcon projetResizedIcon = new ImageIcon(projetImage);
        SpringLayout sl_mainPanel = new SpringLayout();
        mainPanel.setLayout(sl_mainPanel);
        JButton btnProjects = new JButton("Vos Projets", projetResizedIcon);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, btnProjects, 178, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, btnProjects, 21, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, btnProjects, -599, SpringLayout.EAST, mainPanel);
        btnProjects.setBackground(new Color(170, 219, 251));
        mainPanel.add(btnProjects);
        btnProjects.addActionListener(this::openProjetWindow);

        ImageIcon listeIcon = new ImageIcon("Liste.png");
        Image listeImage = listeIcon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        ImageIcon listeResizedIcon = new ImageIcon(listeImage);
        JButton btnLists = new JButton("Vos Listes", listeResizedIcon);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, btnLists, 0, SpringLayout.NORTH, btnProjects);
        sl_mainPanel.putConstraint(SpringLayout.WEST, btnLists, 30, SpringLayout.EAST, btnProjects);
        btnLists.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLists.setBackground(new Color(170, 219, 251));
        mainPanel.add(btnLists);

        ImageIcon avancementIcon = new ImageIcon("Avencement.png");
        Image avancementImage = avancementIcon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        ImageIcon avancementResizedIcon = new ImageIcon(avancementImage);
        JButton btnProgress = new JButton("Vos Avancements", avancementResizedIcon);
        sl_mainPanel.putConstraint(SpringLayout.EAST, btnLists, -33, SpringLayout.WEST, btnProgress);
        sl_mainPanel.putConstraint(SpringLayout.WEST, btnProgress, 610, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, btnProgress, -10, SpringLayout.EAST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, btnProgress, 0, SpringLayout.NORTH, btnProjects);
        btnProgress.setBackground(new Color(170, 219, 251));
        mainPanel.add(btnProgress);

        // ActionListener pour ouvrir la fenêtre VosAvencements
        btnProgress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();
                // Ouvrir la fenêtre VosAvencements
                SwingUtilities.invokeLater(() -> {
                    VosAvencements vosAvencements = new VosAvencements();
                    vosAvencements.setVisible(true);
                });
            }
        });
    
        btnLists.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Fermer la fenêtre actuelle
            dispose();
            // Ouvrir la fenêtre VosAvencements
            SwingUtilities.invokeLater(() -> {
                FenetreListe fenetreListe = new FenetreListe();
				fenetreListe.setVisible(true);
            });
        }
    });
}

    private void openProjetWindow(ActionEvent e) {
        dispose();
        FenetreProjet projetWindow = new FenetreProjet();
        projetWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard frame = new Dashboard();
            frame.setVisible(true);
        });
    }
}

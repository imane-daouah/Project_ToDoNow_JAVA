package Presentation;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class CreéTache extends JFrame {
 
	private static final long serialVersionUID = 1L;

	public CreéTache() {
        setTitle("DO NOW : Nouveau Tache");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // North panel with top buttons
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(227, 227, 227));
        JButton btnReviens = new JButton("Reviens");
        btnReviens.setBackground(new Color(154, 215, 237));
        JButton btnMenu = new JButton("Menu");
        btnMenu.setBackground(new Color(51, 187, 88));
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(255, 62, 62));
        northPanel.add(btnReviens);
        northPanel.add(btnMenu);
        northPanel.add(btnFermer);

        // Center panel for form elements
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(253, 235, 191)); // Purple color

        JLabel lblCategorie = new JLabel("Catégorie :");
        lblCategorie.setFont(new Font("Arial", Font.BOLD, 15));
        JComboBox<String> cbCategorie = new JComboBox<>(new String[] {"Enseignement", "Recherche", "Administration"});
        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Arial", Font.BOLD, 15));
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblDateDebut = new JLabel("Date de départ :");
        lblDateDebut.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel lblDateFin = new JLabel("Date de fin :");
        lblDateFin.setFont(new Font("Arial", Font.BOLD, 15));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, cbCategorie, 55, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, cbCategorie, 398, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, cbCategorie, 92, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, cbCategorie, 0, SpringLayout.EAST, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, txtDescription, 156, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateFin, 304, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateFin, 0, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDateFin, 395, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDateFin, 388, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateDebut, 203, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateDebut, 0, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDateDebut, 294, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDateDebut, 388, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, txtDescription, 398, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, txtDescription, 193, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, txtDescription, 786, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDescription, 102, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDescription, 193, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDescription, 388, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblCategorie, 1, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblCategorie, 0, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblCategorie, 92, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblCategorie, 388, SpringLayout.WEST, centerPanel);
        centerPanel.setLayout(sl_centerPanel);

        centerPanel.add(lblCategorie);
        centerPanel.add(cbCategorie);
        centerPanel.add(lblDescription);
        centerPanel.add(txtDescription);
        centerPanel.add(lblDateDebut);
        centerPanel.add(lblDateFin);

        // South panel with bottom buttons
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(227, 227, 227));
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBackground(new Color(255, 62, 62));
        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setBackground(new Color(51, 187, 88));
        southPanel.add(btnSupprimer);
        southPanel.add(btnEnregistrer);

        // Add panels to frame
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, dateChooser, 54, SpringLayout.SOUTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, dateChooser, 10, SpringLayout.EAST, lblDateDebut);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, dateChooser, 80, SpringLayout.SOUTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.EAST, dateChooser, 225, SpringLayout.EAST, lblDateDebut);
        centerPanel.add(dateChooser);
        
        JDateChooser dateChooser_1 = new JDateChooser();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, dateChooser_1, 78, SpringLayout.SOUTH, dateChooser);
        sl_centerPanel.putConstraint(SpringLayout.WEST, dateChooser_1, 10, SpringLayout.EAST, lblDateFin);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, dateChooser_1, 104, SpringLayout.SOUTH, dateChooser);
        sl_centerPanel.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, dateChooser);
        centerPanel.add(dateChooser_1);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
        btnMenu.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        btnReviens.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	AttacherTache attacher= new AttacherTache();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }

    public static void main(String[] args) {
        new CreéTache();
    }
}

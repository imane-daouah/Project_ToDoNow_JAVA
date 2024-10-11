package Presentation;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class importerDocument extends JFrame {

	private static final long serialVersionUID = 1L;

	public importerDocument() {
        setTitle("DO NOW : Importer Document");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // North panel with top buttons
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(235, 235, 235));
        JButton btnReviens = new JButton("Reviens");
        btnReviens.setBackground(new Color(154, 215, 237));
        
        
        JButton btnMenu = new JButton("Menu");
        btnMenu.setBackground(new Color(51, 187, 88));
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(255, 62, 62));
        northPanel.add(btnReviens);
        northPanel.add(btnMenu);
        northPanel.add(btnFermer);

        // Center panel for date selection
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(253, 235, 191));
        JLabel lblChooseDate = new JLabel("Choisir une Date :");
        lblChooseDate.setFont(new Font("Arial", Font.BOLD, 15));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblChooseDate, 210, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblChooseDate, -246, SpringLayout.SOUTH, centerPanel);
        centerPanel.setLayout(sl_centerPanel);
        centerPanel.add(lblChooseDate);

        // South panel for action buttons
        JPanel southPanel = new JPanel();
        JButton btnCancel = new JButton("Annuler");
        btnCancel.setBackground(Color.RED);
        JButton btnImport = new JButton("Importer");
        btnImport.setBackground(new Color(51, 187, 88));
        southPanel.add(btnCancel);
        southPanel.add(btnImport);

        // Add panels to frame
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, dateChooser, 228, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, dateChooser, 353, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, dateChooser, -249, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, dateChooser, -237, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblChooseDate, 0, SpringLayout.NORTH, dateChooser);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblChooseDate, -6, SpringLayout.WEST, dateChooser);
        centerPanel.add(dateChooser);
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
                AttacherDocument attacherDocument = new AttacherDocument();
				attacherDocument.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }

    public static void main(String[] args) {
        new importerDocument();
    }
}
	
package Presentation;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;

public class CreéUnProjet extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JButton btnAttacher = new JButton("Attacher Une : Tach/Séance/Document");
    
    

    public CreéUnProjet() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO NOW : Nouveau Projet");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        // Panneau principal pour la saisie des données
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(253, 235, 191));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SpringLayout sl_mainPanel = new SpringLayout();
        mainPanel.setLayout(sl_mainPanel);

        // Labels et champs de saisie
        JLabel label = new JLabel("Catégorie :");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        sl_mainPanel.putConstraint(SpringLayout.WEST, label, 14, SpringLayout.WEST, mainPanel);
        mainPanel.add(label);
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Enseignement", "Recherche", "Autre"});
        sl_mainPanel.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, categoryComboBox, 55, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, categoryComboBox, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, categoryComboBox, 84, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, categoryComboBox, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(categoryComboBox);

        JLabel label_1 = new JLabel("Type :");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        sl_mainPanel.putConstraint(SpringLayout.NORTH, label_1, 37, SpringLayout.SOUTH, label);
        sl_mainPanel.putConstraint(SpringLayout.WEST, label_1, 14, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, label_1, 135, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, label);
        mainPanel.add(label_1);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Cours", "Séminaire", "Atelier"});
        sl_mainPanel.putConstraint(SpringLayout.NORTH, typeComboBox, 0, SpringLayout.NORTH, label_1);
        sl_mainPanel.putConstraint(SpringLayout.WEST, typeComboBox, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, typeComboBox, 143, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, typeComboBox, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(typeComboBox);

        JLabel label_2 = new JLabel("Description:");
        label_2.setFont(new Font("Arial", Font.BOLD, 15));
        label_2.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, label_2, 252, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, label_2, 392, SpringLayout.WEST, mainPanel);
        mainPanel.add(label_2);
        JTextArea descriptionTextArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, scrollPane);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, scrollPane, 178, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, scrollPane, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, scrollPane, 252, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, scrollPane, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(scrollPane);

        JLabel label_3 = new JLabel("Date de départ :");
        label_3.setFont(new Font("Arial", Font.BOLD, 15));
        label_3.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, label_3, 262, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, label_3, 10, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, label_3, 336, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, label_3, 388, SpringLayout.WEST, mainPanel);
        mainPanel.add(label_3);

        JLabel label_4 = new JLabel("Date de fin :");
        label_4.setFont(new Font("Arial", Font.BOLD, 15));
        label_4.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, label_4, 346, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, label_4, 10, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, label_4, 420, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, label_4, 388, SpringLayout.WEST, mainPanel);
        mainPanel.add(label_4);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(253, 235, 191));
        btnAttacher.setBackground(new Color(154, 215, 237));
        buttonPanel.add(btnAttacher);
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 430, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, buttonPanel, 876, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 430, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, mainPanel, 786, SpringLayout.WEST, getContentPane());
        getContentPane().setLayout(springLayout);
        getContentPane().add(mainPanel);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_mainPanel.putConstraint(SpringLayout.NORTH, dateChooser, 19, SpringLayout.SOUTH, scrollPane);
        sl_mainPanel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, dateChooser, -119, SpringLayout.SOUTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, dateChooser, 258, SpringLayout.EAST, label_3);
        mainPanel.add(dateChooser);
        
        JDateChooser dateChooser_1 = new JDateChooser();
        sl_mainPanel.putConstraint(SpringLayout.WEST, dateChooser_1, 0, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, dateChooser_1, -41, SpringLayout.SOUTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, dateChooser_1, 258, SpringLayout.EAST, label_4);
        mainPanel.add(dateChooser_1);
        
        JLabel lblNewLabel = new JLabel("_Creé Un Nouveau Projet_");
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 210, SpringLayout.WEST, mainPanel);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, label);
        mainPanel.add(lblNewLabel);
        getContentPane().add(buttonPanel);
        
        btnAttacher.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	AttacherElementsProjet attacher= new AttacherElementsProjet();
    			attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        JButton saveButton = new JButton("Enregistrer");
        saveButton.setBackground(new Color(51, 187, 88));
        buttonPanel.add(saveButton);
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(new Color(255, 62, 62));
        buttonPanel.add(deleteButton);}
    

        // Action listeners pour les boutons
       

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreéUnProjet().setVisible(true);
        });
    }
}



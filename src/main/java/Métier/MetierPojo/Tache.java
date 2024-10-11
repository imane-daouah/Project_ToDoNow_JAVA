package Métier.MetierPojo;

import java.util.ArrayList;

public class Tache {
	private String ID;
    private String categorie;
    private String description;
    private String date_debut;
    private String date_fin;
    private ArrayList<String> documents_associes;
    private String id_seance;
    public Tache() {
    	
    }
	public Tache(String iD, String categorie, String description, String date_debut, String date_fin) {
		super();
		ID = iD;
		this.categorie = categorie;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public ArrayList<String> getDocuments_associes() {
		return documents_associes;
	}
	public void setDocuments_associes(ArrayList<String> documents_associes) {
		this.documents_associes = documents_associes;
	}
	public String getSeance() {
		return id_seance;
	}
	public void setSeance(String id_seance) {
		this.id_seance = id_seance;
	}
}

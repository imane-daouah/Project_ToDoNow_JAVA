package Métier.MetierPojo;

import java.util.ArrayList;

public class Projet {
	private String ID;
    private String categorie;
    private String type;
    private String description;
    private String date_debut;
    private String date_fin;
    private ArrayList<String> seances_id;
    private ArrayList<String> documents_id;
    private ArrayList<String> taches_id;
    public Projet() {
    	
    }
	public Projet(String categorie, String type, String description, String date_debut, String date_fin) {
		super();
		this.categorie = categorie;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public ArrayList<String> getSeances() {
		return seances_id;
	}
	public void setSeances(ArrayList<String> seances) {
		this.seances_id = seances;
	}
	public ArrayList<String> getDocuments() {
		return documents_id;
	}
	public void setDocuments(ArrayList<String> documents) {
		this.documents_id = documents;
	}
	public ArrayList<String> getTaches() {
		return taches_id;
	}
	public void setTaches(ArrayList<String> taches) {
		this.taches_id = taches;
	}
	@Override
	public String toString() {
		return "Projet [ID=" + ID + ", categorie=" + categorie + ", type=" + type + ", description=" + description
				+ ", date_debut=" + date_debut + ", date_fin=" + date_fin + "]";
	}
	public void affiche() {
		System.out.println(this.toString());
		
	}
}
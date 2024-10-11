package Métier.MetierPojo;

import java.util.ArrayList;

public class Seance {
	private String ID;
    private String description;
    private String date_debut;
    private String date_fin;
    private String notes;
    private ArrayList<String> Documents_id;
    public Seance() {
    	
    }
    public Seance(String iD, String description, String date_debut, String date_fin, String notes) {
		super();
		ID = iD;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.notes = notes;
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public ArrayList<String> getDocuments() {
		return Documents_id;
	}
	public void setDocuments(ArrayList<String> documents) {
		Documents_id = documents;
	}
}

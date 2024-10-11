package Métier.MetierPojo;

public class DocumentPojo {
	private String ID;
    private String description;
    private String date_ajout;
    private String chemin_acces;
    public DocumentPojo() {
    	
    }
	public DocumentPojo( String description, String date_ajout, String chemin_acces) {
		super();
		this.description = description;
		this.date_ajout = date_ajout;
		this.chemin_acces = chemin_acces;
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
	public String getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(String date_ajout) {
		this.date_ajout = date_ajout;
	}
	public String getChemin_acces() {
		return chemin_acces;
	}
	public void setChemin_acces(String chemin_acces) {
		this.chemin_acces = chemin_acces;
	}
}

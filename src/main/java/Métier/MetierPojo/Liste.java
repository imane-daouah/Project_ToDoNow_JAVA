package Métier.MetierPojo;

import java.util.ArrayList;

public class Liste {
	private String ID;
    private String description;
    private ArrayList<String> taches_id;
    public Liste() {
    	
    }
    public Liste(String iD, String description, ArrayList<String> taches_id) {
		super();
		ID = iD;
		this.description = description;
		this.taches_id = taches_id;
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
	public ArrayList<String> getTaches_id() {
		return taches_id;
	}
	public void setTaches_id(ArrayList<String> taches_id) {
		this.taches_id = taches_id;
	}
}

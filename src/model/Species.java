package model;

public class Species {
	private String speciesID;
	private String speciesName;
	private String description;
	
	public Species() {
	}
	
	public Species(String speciesID, String speciesName, String description) {
		this.speciesID = speciesID;
		this.speciesName = speciesName;
		this.description = description;
	}
	
	public String getSpeciesID() {
		return speciesID;
	}
	
	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}
	
	public String getSpeciesName() {
		return speciesName;
	}
	
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

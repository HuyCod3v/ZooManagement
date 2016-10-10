package model;

public class Species {
	private String speciesID;
	private String speciesName;
	private String description;
	
	public Species() {
		// TODO Auto-generated constructor stub
	}
	
	public Species(String speciesID, String speciesName, String description) {
		super();
		this.speciesID = speciesID;
		this.speciesName = speciesName;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Species [speciesID=" + speciesID + ", speciesName=" + speciesName + ", description=" + description
				+ "]";
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

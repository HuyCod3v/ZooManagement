package model;

public class Animal {
	private String  animalID;
	private String animalName;
	private String speciesID;
	private Species species;
	private int gender;
	private double height;
	private double weight;
	private String healthStatus;
	private String description;
	private String cellID;
	private Cell cell;
	private String regionName;
	private String regionID;
	
        public Animal(String animalID, String animalName, String speciesID, int gender, String healthStatus,String cellID) {
		super();
		this.animalID = animalID;
		this.animalName = animalName;
		this.speciesID = speciesID;
		this.gender = gender;
                this.healthStatus = healthStatus;
		this.cellID = cellID;
	}                
        
	public Animal(String animalID, String animalName, String speciesID, int gender, double height, double weight,
			String healthStatus, String description, String cellID, String regionName, String regionID) {
		super();
		this.animalID = animalID;
		this.animalName = animalName;
		this.speciesID = speciesID;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.healthStatus = healthStatus;
		this.description = description;
		this.cellID = cellID;
		this.regionName = regionName;
		this.regionID = regionID;
	}
	


	public Animal(String animalID, String animalName, int gender, double height, double weight, String healthStatus,
			String description, String cellID) {
		super();
		this.animalID = animalID;
		this.animalName = animalName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.healthStatus = healthStatus;
		this.description = description;
		this.cellID = cellID;
	}
	
	

	public Animal(String animalID, String animalName, String speciesID, int gender, double height, double weight,
			String healthStatus, String description, String cellID) {
		super();
		this.animalID = animalID;
		this.animalName = animalName;
		this.speciesID = speciesID;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.healthStatus = healthStatus;
		this.description = description;
		this.cellID = cellID;
	}

	public String getRegionName() {
		return regionName;
	}

	



	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}




	public String getRegionID() {
		return regionID;
	}




	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}




	public String getCellID() {
		return cellID;
	}



	public void setCellID(String cellID) {
		this.cellID = cellID;
	}


	
	
	
	
	@Override
	public String toString() {
		return "Animal [animalID=" + animalID + ", animalName=" + animalName + ", speciesID=" + speciesID + ", species="
				+ species + ", gender=" + gender + ", height=" + height + ", weight=" + weight + ", healthStatus="
				+ healthStatus + ", description=" + description + ", cellID=" + cellID + ", cell=" + cell
				+ ", regionName=" + regionName + ", regionID=" + regionID + "]";
	}




	public String getSpeciesID() {
		return speciesID;
	}
	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}
	public String getAnimalID() {
		return animalID;
	}
	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	
	
	
	public int getGender() {
		return gender;
	}


	

	public void setGender(int gender) {
		this.gender = gender;
	}




	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	
	
	
}

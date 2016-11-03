package model;

public class Cell {
	private String cellID;
	private String cellName;
	private String regionID;
	private String speciesID;
	private Species species;
	private int capacity;
	private int cellStatusID;
	private CellStatus cellStatus;
	private String description;
	private Region region;
	public String getCellID() {
		return cellID;
	}
	public void setCellID(String cellID) {
		this.cellID = cellID;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getRegionID() {
		return regionID;
	}
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
	public String getSpeciesID() {
		return speciesID;
	}
	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCellStatusID() {
		return cellStatusID;
	}
	public void setCellStatusID(int cellStatusID) {
		this.cellStatusID = cellStatusID;
	}
	public CellStatus getCellStatus() {
		return cellStatus;
	}
	public void setCellStatus(CellStatus cellStatus) {
		this.cellStatus = cellStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Cell [cellID=" + cellID + ", cellName=" + cellName + ", regionID=" + regionID + ", speciesID="
				+ speciesID + ", species=" + species + ", capacity=" + capacity + ", cellStatusID=" + cellStatusID
				+ ", cellStatus=" + cellStatus + ", description=" + description + "]";
	}
	
	
	
	
	public Cell(String cellID, String cellName, String regionID, String speciesID, int capacity, int cellStatusID,
			String description) {
		super();
		this.cellID = cellID;
		this.cellName = cellName;
		this.regionID = regionID;
		this.speciesID = speciesID;
		this.capacity = capacity;
		this.cellStatusID = cellStatusID;
		this.description = description;
	}
	
	public Cell(String cellID, String cellName, String regionID, String speciesID, int capacity, int cellStatusID,
			CellStatus cellStatus, String description) {
		super();
		this.cellID = cellID;
		this.cellName = cellName;
		this.regionID = regionID;
		this.speciesID = speciesID;
		this.capacity = capacity;
		this.cellStatusID = cellStatusID;
		this.cellStatus = cellStatus;
		this.description = description;
	}
	
	
	
}

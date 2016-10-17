package model;

public class Region {
	
	private String regionID;
	
	private String regionName;
	
	private int regionStatusID;
	
	private double regionArea;
	
	private String description;
	
	private RegionStatus regionStatus;
		
	public String getRegionID() {
		return regionID;
	}
	
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
	
	public String getRegionName() {
		return regionName;
	}
	
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	public int getRegionStatusID() {
		return regionStatusID;
	}
	
	public void setRegionStatusID(int regionStatusID) {
		this.regionStatusID = regionStatusID;
	}
	
	public double getRegionArea() {
		return regionArea;
	}
	
	public void setRegionArea(double regionArea) {
		this.regionArea = regionArea;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
		
	public RegionStatus getRegionStatus() {
		return regionStatus;
	}
	
	public void setRegionStatus(RegionStatus regionStatus) {
		this.regionStatus = regionStatus;
	}
	
	public Region(String regionID, String regionName, int regionStatusID, double regionArea, String description) {
		super();
		this.regionID = regionID;
		this.regionName = regionName;
		this.regionStatusID = regionStatusID;
		this.regionArea = regionArea;
		this.description = description;
	}

}

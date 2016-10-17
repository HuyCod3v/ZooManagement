package model;

public class RegionStatus {
	
	private int regionStatusID;
	
	private String regionStatusName;
	
	public RegionStatus(int regionStatusID, String regionStatusName) {
		this.regionStatusID = regionStatusID;
		this.regionStatusName = regionStatusName;
	}
	
	public int getRegionStatusID() {
		return regionStatusID;
	}
	
	public void setRegionStatusID(int regionStatusID) {
		this.regionStatusID = regionStatusID;
	}
	
	public String getRegionStatusName() {
		return regionStatusName;
	}
	
	public void setRegionStatusName(String regionStatusName) {
		this.regionStatusName = regionStatusName;
	}
		
}

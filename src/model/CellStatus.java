package model;

public class CellStatus {
	private int cellStatusID;
	private String cellStatusName;
	
	public CellStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CellStatus(int cellStatusID, String cellStatusName) {
		super();
		this.cellStatusID = cellStatusID;
		this.cellStatusName = cellStatusName;
	}
	@Override
	public String toString() {
		return "CellStatus [cellStatusID=" + cellStatusID + ", cellStatusName=" + cellStatusName + "]";
	}
	public int getCellStatusID() {
		return cellStatusID;
	}
	public void setCellStatusID(int cellStatusID) {
		this.cellStatusID = cellStatusID;
	}
	public String getCellStatusName() {
		return cellStatusName;
	}
	public void setCellStatusName(String cellStatusName) {
		this.cellStatusName = cellStatusName;
	}
	
	
}

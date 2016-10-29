package bo;

import java.util.ArrayList;

import dao.CellDAO;
import model.Cell;

public class CellBO {
	
	private CellDAO cellDAO;
	
	public CellBO() {
		cellDAO = new CellDAO();
	}
	
	public ArrayList<Cell> getAllCells() {
		return cellDAO.getAll();
	}
	
	public ArrayList<Cell> getByRegion(String regionID) {
		return cellDAO.getByRegion(regionID);
	}
}

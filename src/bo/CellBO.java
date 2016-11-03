package bo;

import java.util.ArrayList;

import dao.CellDAO;
import model.Cell;

public class CellBO {
	
	private CellDAO mCellDAO;

	public CellBO() {

		this.mCellDAO = new CellDAO();

	}
	
	public ArrayList<Cell> getAllCells() {

		return mCellDAO.getAll();

	}

	public boolean addCell(Cell cell) {

		return mCellDAO.addCell(cell);

	}

	public boolean checkExistCell(String cellID) {

		return (mCellDAO.getCellByID(cellID)!=null);

	}

	public boolean deleteCell(String cellID){
		
		return mCellDAO.deleteCell(cellID);
	}
	
	public Cell getCellByID(String cellID){
		
		return mCellDAO.getCellByID(cellID);
		
	}
	
	public boolean updateCell(Cell cell){
		
		return mCellDAO.updateCell(cell);
		
	}
	
	public ArrayList<Cell> getByRegion(String regionID) {
		return cellDAO.getByRegion(regionID);
}

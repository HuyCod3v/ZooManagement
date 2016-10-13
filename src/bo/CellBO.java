package bo;

import java.util.ArrayList;

import dao.CellDAO;
import model.Cell;

public class CellBO {
	public ArrayList<Cell> getAllCells() {
		return new CellDAO().getAll();
	}
}

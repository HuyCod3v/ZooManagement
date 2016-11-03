package bo;

import java.util.List;

import dao.CellStatusDAO;
import model.CellStatus;

public class CellStatusBO {
	private CellStatusDAO cellStatusDAO;
	
	public CellStatusBO() {
		cellStatusDAO = new CellStatusDAO();
	}
	
	public List<CellStatus> getAll() {
		return cellStatusDAO.getAll();
	}

}

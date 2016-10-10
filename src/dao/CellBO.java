package dao;

import java.util.ArrayList;

import model.Cell;

public class CellBO {
	public ArrayList<Cell> getAllCells() {
		return new CellDAO().getAllCells();
	}
}

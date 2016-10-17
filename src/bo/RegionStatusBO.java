package bo;

import java.util.List;

import dao.RegionStatusDAO;
import model.RegionStatus;

public class RegionStatusBO {
	private RegionStatusDAO regionStatusDAO;
	
	public RegionStatusBO() {
		regionStatusDAO = new RegionStatusDAO();
	}
	
	public List<RegionStatus> getAll() {
		return regionStatusDAO.getAll();
	}

}

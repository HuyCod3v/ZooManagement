package bo;

import java.util.ArrayList;

import dao.RegionDAO;
import model.Region;

public class RegionBO {
	RegionDAO regionDAO = null;
	
	public ArrayList<Region> getAllRegions() {
		regionDAO = new RegionDAO();
		return regionDAO.getAll();
	}
	public Region getRegionById(String id) {
		regionDAO = new RegionDAO();
		return regionDAO.find(id);
	}
}

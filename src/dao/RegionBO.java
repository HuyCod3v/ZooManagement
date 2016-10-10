package dao;

import java.util.ArrayList;

import model.Region;

public class RegionBO {
	RegionDAO regionDAO = null;
	
	public ArrayList<Region> getAllRegions() {
		regionDAO = new RegionDAO();
		return regionDAO.getAllRegions();
	}
	public Region getRegionById(String id) {
		regionDAO = new RegionDAO();
		return regionDAO.getRegionById(id);
	}
}

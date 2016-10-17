package bo;

import java.util.List;
import dao.RegionDAO;
import model.Region;

public class RegionBO {
	
	private RegionDAO regionDAO;
	
	public RegionBO() {
		regionDAO = new RegionDAO();
	}
	
	public List<Region> getAll() {
		return regionDAO.getAll();
	}
	public Region getRegionById(String id) {
		return regionDAO.find(id);
	}
}

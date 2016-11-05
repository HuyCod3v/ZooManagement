package bo;

import java.util.List;
import dao.SpeciesDAO;
import model.Species;

public class SpeciesBO {
	private SpeciesDAO speciesDAO;
	
	public SpeciesBO() {
		speciesDAO = new SpeciesDAO();
	}
	
	public List<Species> getAll() {
		return speciesDAO.getAll();
	}
	
	public Species find(String id) {
		return speciesDAO.find(id);
	}
	
	public boolean add(Species region) {
		return speciesDAO.add(region);
	}
	
	public boolean edit(Species region) {
		return speciesDAO.edit(region);
	}
	
	public boolean delete(String id) {
		return speciesDAO.delete(id);
	}
}

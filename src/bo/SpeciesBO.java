package bo;

import java.util.ArrayList;

import dao.SpeciesDAO;
import model.Species;

public class SpeciesBO {
	public ArrayList<Species> getAllSpecies() {
		return new SpeciesDAO().getAll();
	}
}

package dao;

import java.util.ArrayList;

import model.Species;

public class SpeciesBO {
	public ArrayList<Species> getAllSpecies() {
		return new SpeciesDAO().getAllSpecies();
	}
}

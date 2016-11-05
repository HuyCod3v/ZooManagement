package bo;

import java.util.ArrayList;

import dao.AnimalDAO;
import model.Animal;

public class AnimalBO {
	
	public boolean deleteAnimal(String animalID) {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.delete(animalID);
	}
	
	public boolean updateAnimal(Animal updatedAnimal) {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.edit(updatedAnimal);
	}
	
	public ArrayList<Animal> getAllAnimals() {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.getAll();
	}
	
	public Animal getAnimalById(String id) {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.find(id);
	}
	
	public ArrayList<Animal> searchAnimalById(String id) {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.getById(id);
	}
	
	public boolean addNewAnimal(Animal newAnimal) {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.add(newAnimal);
	}
	
	public ArrayList<Animal> searchAnimalByRegion(String regionId) {
		AnimalDAO animalDA0 = new AnimalDAO();
		return animalDA0.getByRegion(regionId);
	}
	
	public static ArrayList<Animal> searchAnimalByCell(String cellId) {
		return new AnimalDAO().getByCell(cellId);
	}
	
	public ArrayList<Animal> searchAnimalBySpecies(String speciesId) {
		return new AnimalDAO().getBySpecies(speciesId);
	}

	public boolean checkExistAnimal(String animalID) {
		
		return new AnimalDAO().checkExistAnimal(animalID);
	}

	public boolean addAnimal(Animal animal) {
		
		return new AnimalDAO().add(animal);
	}
	
	
	 
}
